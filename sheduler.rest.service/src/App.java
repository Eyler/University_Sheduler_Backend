

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import sheduler.model.HibernateUtil;
import sheduler.model.bean.Auditorium;
import sheduler.model.bean.Person;
import sheduler.model.bean.StudentGroup;

public class App {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();
		
		StudentGroup myGroup = new StudentGroup("SPKm-12", "IKNI");
		Person student = new Person("oliyarnykpp@gmail.com", "student", "password", myGroup);
		student.setGroupID(myGroup);
		Set<Person> students = new HashSet<Person>();
		students.add(student);
		Auditorium auditorium = new Auditorium("4 korpus", "134");
		Set<Auditorium> auditoriums = new HashSet<Auditorium>();
		auditoriums.add(auditorium);
		session.save(student);
		/*	session.save(marksDetails2);
		session.save(marksDetails3);*/
		session.getTransaction().commit();
		/*IPersonDao dao = new PersonDAO(session);
		List<Person> persons = dao.readAll();
		System.out.println(persons.get(0));*/
		session.close();
	}
}