package sheduler.model.dao;

import java.util.List;

import org.hibernate.Session;

import sheduler.model.bean.Period;
import sheduler.model.interfaces.IPeriodDao;

public class PeriodDAO extends BaseCrudDAO<Period> implements IPeriodDao {

	public PeriodDAO(Session session) {
		super(session);
	}

	@Override
	public List<Period> readAll() {
		return session.createQuery("From Period").list();
	}

	@Override
	protected Class<Period> getEntityClass() {
		return Period.class;
	}

}
