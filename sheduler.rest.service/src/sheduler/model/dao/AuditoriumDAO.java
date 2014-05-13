package sheduler.model.dao;

import java.util.List;

import org.hibernate.Session;

import sheduler.model.bean.Auditorium;
import sheduler.model.interfaces.IAuditoriumDao;

public class AuditoriumDAO extends BaseCrudDAO<Auditorium> implements IAuditoriumDao {

	public AuditoriumDAO(Session session) {
		super(session);
	}

	@Override
	public List<Auditorium> readAll() {
		return session.createQuery("From Auditorium").list();
	}

	@Override
	protected Class<Auditorium> getEntityClass() {
		return Auditorium.class;
	}

}

