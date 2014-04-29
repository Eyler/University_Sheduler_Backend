package sheduler.model.dao;

import java.util.List;

public interface ICrudDao {
	
	<T> List<T> getAll(Class<T> klass);

	<T> T save(T t);

	<T> void delete(T t);
	
	
}
