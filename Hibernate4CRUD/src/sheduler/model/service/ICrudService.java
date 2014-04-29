package sheduler.model.service;

import java.util.List;

public interface ICrudService {
	
	<T> List<T> getAll(Class<T> klass);

	<T> T save(T t);

	<T> void delete(T t);
}
