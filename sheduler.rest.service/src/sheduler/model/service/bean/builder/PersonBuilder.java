package sheduler.model.service.bean.builder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import sheduler.model.HibernateUtil;
import sheduler.model.bean.Person;
import sheduler.model.bean.StudentGroup;
import sheduler.model.dao.StudentGroupDAO;
import sheduler.model.service.bean.ServicePerson;

public class PersonBuilder {
	
	public PersonBuilder() {
	
	}

	public ServicePerson buildServicePerson(Person person) {
		if(person.getGroupID() == null) {
			return null;
		}
		ServicePerson servicePerson = new ServicePerson();
		servicePerson.setPersonID(person.getPersonID());
		servicePerson.setRole(person.getRole());
		servicePerson.setPassword(person.getPassword());
		servicePerson.setGroupID(person.getGroupID().getGroupID());
		servicePerson.setFirstname(person.getFirstname());
		servicePerson.setLastname(person.getLastname());
		servicePerson.setDepartment(person.getDepartment());
		return servicePerson;
	} 

	public Person buildPerson(ServicePerson servicePerson) {
		Person person = new Person();
		person.setPersonID(servicePerson.getPersonID());
		person.setRole(servicePerson.getRole());
		person.setPassword(servicePerson.getPassword());
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		StudentGroupDAO dao = new StudentGroupDAO(session);
		StudentGroup studentGroup = dao.read("StudentGroup", "group_ID", Integer.toString(servicePerson.getGroupID()));
		session.close();
		person.setGroupID(studentGroup);
		person.setFirstname(servicePerson.getFirstname());
		person.setLastname(servicePerson.getLastname());
		person.setDepartment(servicePerson.getDepartment());
		return person;
	}
	
	
	
}

