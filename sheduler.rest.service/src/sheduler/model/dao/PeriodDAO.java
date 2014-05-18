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
	
	public List<Period> readGroupScheduler(String groupID) {
		return session.createQuery("From Period where group_ID =" + "'" + groupID + "'").list();
	}

	public List<Period> readPeriodsByDay(String day) {
		return session.createQuery("From Period where day =" + "'" + day + "'").list();
	}
}
