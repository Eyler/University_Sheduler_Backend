package sheduler.model.dao;

import java.util.List;

import org.hibernate.Session;

import sheduler.model.bean.Person;
import sheduler.model.interfaces.IPersonDao;

public class PersonDAO extends BaseCrudDAO<Person> implements IPersonDao {

	public PersonDAO(Session session) {
		super(session);
	}

	@Override
	public List<Person> readAll() {

		return session.createQuery("From Person").list();
	}

	@Override
	protected Class<Person> getEntityClass() {
		return Person.class;
	}

}

