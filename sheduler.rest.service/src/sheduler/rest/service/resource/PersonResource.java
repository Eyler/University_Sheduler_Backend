package sheduler.rest.service.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import sheduler.model.HibernateUtil;
import sheduler.model.bean.Person;
import sheduler.model.dao.PersonDAO;
import sheduler.model.interfaces.IPersonDao;
import sheduler.model.service.bean.ServicePerson;
import sheduler.model.service.bean.builder.PersonBuilder;

@Path("/persons")
public class PersonResource {

	// Allows to insert contextual objects into the class,
	// e.g. ServletContext, Request, Response, UriInfo
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	// Return the list of todos for applications
	@GET
	@Produces({MediaType.APPLICATION_JSON })
	public List<ServicePerson> getPersons() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		org.hibernate.Session session = sf.openSession();
		try {
			session.beginTransaction();
			IPersonDao dao = new PersonDAO(session);
			List<Person> persons = dao.readAll();
			List<ServicePerson> servicePersons = new ArrayList<ServicePerson>();
			for(Person person : persons) {
				servicePersons.add(new PersonBuilder().buildServicePerson(person));
			}
			return servicePersons;
		} finally {
			session.close();

		}
	}
	
	@PUT
	@Consumes( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML} )
	public Response putTodo(JAXBElement<ServicePerson> p) {
		Response res;
		ServicePerson servicePerson = p.getValue();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Person person = new PersonBuilder().buildPerson(servicePerson);
		PersonDAO dao = new PersonDAO(session);
		dao.create(person);
		session.close();
		res = Response.created(uriInfo.getAbsolutePath()).build();
		return res;
		
	}

}
