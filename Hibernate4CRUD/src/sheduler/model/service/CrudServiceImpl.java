package sheduler.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sheduler.model.dao.ICrudDao;

@Service
public class CrudServiceImpl implements ICrudService {

	@Autowired
	private ICrudDao CRUDDao;

	@Transactional
	public <T> List<T> getAll(Class<T> klass) {
		return CRUDDao.getAll(klass);
	}

	@Transactional
	public <T> T save(T t) {
		T newRecord = null;
		newRecord = CRUDDao.save(t);
		return newRecord;
	}

	@Transactional
	public <T> void delete(T t) {
		CRUDDao.delete(t);
	}
}