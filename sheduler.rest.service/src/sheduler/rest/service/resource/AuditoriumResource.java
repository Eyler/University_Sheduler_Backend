package sheduler.rest.service.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import org.hibernate.SessionFactory;

import sheduler.model.HibernateUtil;
import sheduler.model.bean.Auditorium;
import sheduler.model.dao.AuditoriumDAO;
import sheduler.model.interfaces.IAuditoriumDao;
import sheduler.model.service.bean.ServiceAuditorium;
import sheduler.model.service.bean.builder.AuditoriumBuilder;

@Path("/auditoriums")
public class AuditoriumResource {

	// Allows to insert contextual objects into the class,
	// e.g. ServletContext, Request, Response, UriInfo
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	// Return the list of todos for applications
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<ServiceAuditorium> getAuditoriums() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		org.hibernate.Session session = sf.openSession();
		try {
			session.beginTransaction();
			IAuditoriumDao dao = new AuditoriumDAO(session);
			List<Auditorium> auditoriums = dao.readAll();
			List<ServiceAuditorium> serviceAuditoriums = new ArrayList<ServiceAuditorium>();
			for(Auditorium auditorium : auditoriums) {
				ServiceAuditorium serviceAuditorium = new AuditoriumBuilder(auditorium).build(); 
				serviceAuditoriums.add(serviceAuditorium);
			}
			return serviceAuditoriums;
		} finally {
			session.close();

		}
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getTodoHTML() {
		return "OLOLOLO";
	}
}
