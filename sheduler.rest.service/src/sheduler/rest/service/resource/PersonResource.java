package sheduler.rest.service.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import sheduler.model.HibernateUtil;
import sheduler.model.bean.Auditorium;
import sheduler.model.bean.Period;
import sheduler.model.bean.Person;
import sheduler.model.dao.AuditoriumDAO;
import sheduler.model.dao.PeriodDAO;
import sheduler.model.dao.PersonDAO;
import sheduler.model.interfaces.IAuditoriumDao;
import sheduler.model.interfaces.IPersonDao;
import sheduler.model.service.bean.ServiceAuditorium;
import sheduler.model.service.bean.ServiceAuditoriumPeriod;
import sheduler.model.service.bean.ServicePeriod;
import sheduler.model.service.bean.ServicePerson;
import sheduler.model.service.bean.builder.AuditoriumBuilder;
import sheduler.model.service.bean.builder.PeriodBuilder;
import sheduler.model.service.bean.builder.PersonBuilder;

@Path("/persons")
public class PersonResource {

	// Allows to insert contextual objects into the class,
	// e.g. ServletContext, Request, Response, UriInfo
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	// Return the list of service persons for applications
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<ServicePerson> getPersons() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		org.hibernate.Session session = sf.openSession();
		try {
			session.beginTransaction();
			IPersonDao dao = new PersonDAO(session);
			List<Person> persons = dao.readAll();
			List<ServicePerson> servicePersons = new ArrayList<ServicePerson>();
			for (Person person : persons) {
				servicePersons.add(new PersonBuilder().buildServicePerson(person));
			}
			return servicePersons;
		} finally {
			session.close();

		}
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response registerPerson(JAXBElement<ServicePerson> p) {
		Response res;
		ServicePerson servicePerson = p.getValue();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Person person = new PersonBuilder().buildPerson(servicePerson);
		PersonDAO dao = new PersonDAO(session);
		try {
			dao.create(person);
			session.close();
			res = Response.created(uriInfo.getAbsolutePath()).build();
		} catch (Exception e) {
			res = Response.status(Status.BAD_REQUEST).build();
		}
		return res;

	}

	@POST
	@Path("login")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public ServicePerson loginPerson(JAXBElement<ServicePerson> p) {
		ServicePerson servicePerson = p.getValue();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		PersonDAO dao = new PersonDAO(session);
		try {
			Person person = dao.read("Person", "person_ID", servicePerson.getPersonID());
			session.close();
			if (person != null && person.getPassword().equals(servicePerson.getPassword())) {
				servicePerson = new PersonBuilder().buildServicePerson(person);
			} else {
				servicePerson = null;
			}
			return servicePerson;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}


	@GET
	@Path("{groupdID}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public List<ServicePeriod> getScheduler(@PathParam("groupdID") String groupdID) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		try {
			PeriodDAO periodDAO = new PeriodDAO(session);
			List<Period> groupPeriods = periodDAO.readGroupScheduler(groupdID);
			session.close();
			List<ServicePeriod> periods = new ArrayList<>();
			if (groupPeriods != null && !groupPeriods.isEmpty()) {
				for (Period period : groupPeriods) {
					if (period.getPeriodType().equals("period")) {
						periods.add(new PeriodBuilder().buildServicePeriod(period));
					}
				}
			}
			return periods;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	

	@GET
	@Path("/free_auditoriums/{day}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public List <ServiceAuditoriumPeriod> getFreeAuditoriums(@PathParam("day") String day) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		try {
			// Get all periods by day 
			PeriodDAO periodDAO = new PeriodDAO(session);
			List<Period> groupPeriods = periodDAO.readPeriodsByDay(day);
			List<ServicePeriod> periods = new ArrayList<>();
			if (groupPeriods != null && !groupPeriods.isEmpty()) {
				for (Period period : groupPeriods) {
					if (period.getPeriodType().equals("period")) {
						periods.add(new PeriodBuilder().buildServicePeriod(period));
					}
				}
			}
			// Get all auditoriums
			Set<ServiceAuditorium> allAuditoriums = new HashSet<>();
			IAuditoriumDao dao = new AuditoriumDAO(session);
			List<Auditorium> auditoriums = dao.readAll();
			for(Auditorium auditorium : auditoriums) {
				ServiceAuditorium serviceAuditorium = new AuditoriumBuilder(auditorium).build(); 
				allAuditoriums.add(serviceAuditorium);
			}
			session.close();
			// Get reserved auditoriums
			Map<Integer, Set<ServiceAuditorium>> periodAuditoriumsMap = new HashMap<>();
			for(ServicePeriod per : periods) {
				if(periodAuditoriumsMap.get(per.getPeriodNumber()) == null) {
					Set<ServiceAuditorium> serAuditoriums = new HashSet<>();
					serAuditoriums.add(per.getAuditorium());
					periodAuditoriumsMap.put(per.getPeriodNumber(), serAuditoriums);
				} else {
					Set<ServiceAuditorium> auds = periodAuditoriumsMap.get(per.getPeriodNumber());
					auds.add(per.getAuditorium());
				}
			} 
			// Remove reserved auditoriums from all auditoriums
			for(Map.Entry<Integer, Set<ServiceAuditorium>> entry : periodAuditoriumsMap.entrySet()) {
				Set<ServiceAuditorium> actualAuditoriums = new HashSet<>(allAuditoriums);
				Set<ServiceAuditorium> rezulSet = entry.getValue();
				actualAuditoriums.removeAll(rezulSet);
				entry.setValue(actualAuditoriums);
			}
			List<ServiceAuditoriumPeriod> auditoriumPeriods = new ArrayList<>();
			for(Map.Entry<Integer, Set<ServiceAuditorium>> entry : periodAuditoriumsMap.entrySet()) {
				auditoriumPeriods.add(new ServiceAuditoriumPeriod(entry.getKey(), entry.getValue()));
			}
			return auditoriumPeriods;
		} catch (Exception e) {
			e.printStackTrace(); 
			return null;
		}

	}

	@PUT
	@Path("addEvent")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response addEvent(JAXBElement<ServicePeriod> p) {
		Response res;
		ServicePeriod servicePerson = p.getValue();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Period period = new PeriodBuilder().buildPeriod(servicePerson);
		Session session = sf.openSession();
		PeriodDAO dao = new PeriodDAO(session);
		try {
			dao.create(period);
			session.close();
			res = Response.created(uriInfo.getAbsolutePath()).build();
		} catch (Exception e) {
			res = Response.status(Status.BAD_REQUEST).build();
		}
		return res;

	}

	@GET
	@Path("getEvents/{groupdID}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public List<ServicePeriod> getEvents(@PathParam("groupdID") String groupdID) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		try {
			PeriodDAO periodDAO = new PeriodDAO(session);
			List<Period> groupPeriods = periodDAO.readGroupEvents(groupdID);
			session.close();
			List<ServicePeriod> periods = new ArrayList<>();
			if (groupPeriods != null && !groupPeriods.isEmpty()) {
				for (Period period : groupPeriods) {
					periods.add(new PeriodBuilder().buildServicePeriod(period));
				}
			}
			return periods;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	
	@DELETE
	@Path("deleteEvent")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteEvent(JAXBElement<ServicePeriod> p) {
		Response res;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Period period = new PeriodBuilder().buildPeriod(p.getValue());
		Session session = sf.openSession();
		PeriodDAO dao = new PeriodDAO(session);
		Period recievedEvent = new PeriodBuilder().buildPeriod(p.getValue());
		try {
			List<Period> events = dao.readGroupEvents(Integer.toString(period.getGroupID().getGroupID()));
			Period toDelete = null;
			for (Period event : events) {
				//ServiceAuditorium auditorium = new AuditoriumBuilder(event.getAuditorium()).build();
				if (event.getAuditorium().equals(recievedEvent.getAuditorium()) && event.getPeriodNumber() == recievedEvent.getPeriodNumber()) {
					toDelete = event;
				}
			}
			session.getTransaction().begin();
			dao.delete(toDelete.getPeriodID());
			session.getTransaction().commit();
			session.close();
			res = Response.created(uriInfo.getAbsolutePath()).build();
		} catch (Exception e) {
			e.printStackTrace();
			res = Response.status(Status.BAD_REQUEST).build();
		}
		return res;

	}

	
	
}
