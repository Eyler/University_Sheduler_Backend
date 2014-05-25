package sheduler.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import sheduler.model.interfaces.ICrudDao;

public abstract class BaseCrudDAO<T> implements ICrudDao<T> {

	protected Session session;

	public BaseCrudDAO(Session session) {
		super();
		this.session = session;
	}

	protected abstract Class<T> getEntityClass();

	@Override
	public void create(T obj) {
		session.getTransaction().begin();
		session.save(obj);
		session.getTransaction().commit();
	}

	@Override
	public void update(T obj) {
		session.getTransaction().begin();
		session.update(obj);
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T read(String table, String parameter, String value) {
		Query query = session.createQuery("from " + table + " where " + parameter + "='" + value + "'");
		List<T> list = query.list();
		if (list != null && !list.isEmpty()) {
			return (T) list.get(0);
		} else {
			return null;
		}
	}
	
	@Override
	public void delete(Integer id) {
		session.delete(session.get(getEntityClass(), id));
	}
	
}	