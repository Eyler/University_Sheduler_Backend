package sheduler.model.utils;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import sheduler.model.HibernateUtil;
import sheduler.model.bean.Auditorium;
import sheduler.model.bean.Person;
import sheduler.model.bean.StudentGroup;
import sheduler.model.bean.UniversityEvent;

public class App {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();

		/*Student student = new Student("Nagesh", "Chauhan", "beingjavaguy@gmail.com", "8789876765");
		session.save(student);

		MarksDetails marksDetails1 = new MarksDetails("Maths", "100", "87", "Passed");
		MarksDetails marksDetails2 = new MarksDetails("Science", "100", "90", "Passed");
		MarksDetails marksDetails3 = new MarksDetails("English", "100", "85", "Passed");

		marksDetails1.setStudent(student);
		marksDetails2.setStudent(student);
		marksDetails3.setStudent(student);*/
		
		StudentGroup myGroup = new StudentGroup("SPKm-12", "IKNI", "empty");
		Person student = new Person("student", "password", myGroup);
		Set<Person> students = new HashSet<Person>();
		students.add(student);
		myGroup.setStudents(students);
		Auditorium auditorium = new Auditorium("4 korpus", 134);
		Set<Auditorium> auditoriums = new HashSet<Auditorium>();
		auditoriums.add(auditorium);
		UniversityEvent event = new UniversityEvent("para", "OOP languages", new Date(313133131l));
		Set<UniversityEvent> events = new HashSet<UniversityEvent>();
		events.add(event);
		auditorium.setEvents(events);
		myGroup.setAuditoriums(auditoriums);
		
		session.save(student);
	/*	session.save(marksDetails2);
		session.save(marksDetails3);*/

		session.getTransaction().commit();
		session.close();
	}
}