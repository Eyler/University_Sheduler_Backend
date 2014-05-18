package sheduler.model.interfaces;

import java.util.List;

public interface ICrudDao<T> {

	public void create(T obj);

	public void update(T obj);

	public void delete(Integer id);

	public List<T> readAll();

	T read(String table, String parameter, String value);

}
