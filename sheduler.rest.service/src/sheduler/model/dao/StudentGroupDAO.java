package sheduler.model.dao;

import java.util.List;

import org.hibernate.Session;

import sheduler.model.bean.StudentGroup;
import sheduler.model.interfaces.IStudentGroupDao;

public class StudentGroupDAO extends BaseCrudDAO<StudentGroup> implements
		IStudentGroupDao {

	public StudentGroupDAO(Session session) {
		super(session);
	}

	@Override
	public List<StudentGroup> readAll() {
		return session.createQuery("From StudentGroup").list();
	}

	@Override
	protected Class<StudentGroup> getEntityClass() {
		return StudentGroup.class;
	}

}
