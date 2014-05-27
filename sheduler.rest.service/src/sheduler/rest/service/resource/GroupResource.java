package sheduler.rest.service.resource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;




import models.page_objects.Lecturer;

import org.hibernate.SessionFactory;

import sheduler.model.HibernateUtil;
import sheduler.model.bean.StudentGroup;
import sheduler.model.dao.StudentGroupDAO;
import sheduler.model.interfaces.IStudentGroupDao;
import sheduler.model.service.bean.ServiceLecturer;
import sheduler.model.service.bean.ServiceGroup;
import sheduler.model.service.bean.builder.GroupBuilder;

@Path("/groups")
public class GroupResource {

	// Allows to insert contextual objects into the class,
	// e.g. ServletContext, Request, Response, UriInfo
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	// Return the list of todos for applications
	@GET
	@Produces({MediaType.APPLICATION_JSON })
	public List<ServiceGroup> getGrpoups() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		org.hibernate.Session session = sf.openSession();
		try {
			session.beginTransaction();
			IStudentGroupDao dao = new StudentGroupDAO(session);
			List<StudentGroup> groups = dao.readAll();
			List<ServiceGroup> serviceGroups = new ArrayList<ServiceGroup>();
			for(StudentGroup group : groups) {
				ServiceGroup serviceGroup = new GroupBuilder(group).build();
				serviceGroups.add(serviceGroup);
			}
			return serviceGroups;
		} finally {
			session.close();

		}
	}
	
	@GET
	@Path("/lectures")
	@Produces({MediaType.APPLICATION_JSON })
	public Set<ServiceLecturer> getGrpoupsForLectures() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		org.hibernate.Session session = sf.openSession();
		try {
			session.beginTransaction();
			IStudentGroupDao dao = new StudentGroupDAO(session);
			List<StudentGroup> groups = dao.readAll();
			Set<ServiceLecturer> lectures = new HashSet<ServiceLecturer>();
			for(StudentGroup group : groups) {
				ServiceGroup serviceGroup = new GroupBuilder(group).build();
				if(serviceGroup.getGroupName().length() > 7) {
					lectures.add(new ServiceLecturer(serviceGroup.getGroupName()));
				}
			}
			return lectures;
		} finally {
			session.close();

		}
	}
	
	
}
