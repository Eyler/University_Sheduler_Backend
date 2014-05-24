package sheduler.model.service.bean.builder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import sheduler.model.HibernateUtil;
import sheduler.model.bean.Auditorium;
import sheduler.model.bean.Period;
import sheduler.model.bean.StudentGroup;
import sheduler.model.dao.AuditoriumDAO;
import sheduler.model.dao.StudentGroupDAO;
import sheduler.model.service.bean.ServicePeriod;

public class PeriodBuilder {
	
	
	public PeriodBuilder() {
	}
	
	public ServicePeriod buildServicePeriod(Period period) {
		ServicePeriod servicePeriod = new ServicePeriod();
		servicePeriod.setPeriodID(period.getPeriodID());
		servicePeriod.setDay(period.getDay());
		servicePeriod.setPeriodNumber(period.getPeriodNumber());
		servicePeriod.setPeriodType(period.getPeriodType());
		servicePeriod.setGroupID(period.getGroupID().getGroupID());
		servicePeriod.setAuditorium(new AuditoriumBuilder(period.getAuditorium()).build());
		servicePeriod.setEventDate(period.getEventDate());
		servicePeriod.setDiscipline(period.getDiscipline());
		servicePeriod.setLecturer(period.getLecturer());
		return servicePeriod;
	} 
	
	public Period buildPeriod(ServicePeriod servicePeriod) {
		Period period = new Period();
		period.setPeriodID(servicePeriod.getPeriodID());
		period.setDay(servicePeriod.getDay());
		period.setPeriodNumber(servicePeriod.getPeriodNumber());
		period.setPeriodType(servicePeriod.getPeriodType());
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		StudentGroupDAO dao = new StudentGroupDAO(session);
		StudentGroup studentGroup = dao.read("StudentGroup", "group_ID", Integer.toString(servicePeriod.getGroupID()));
		AuditoriumDAO auditoriumDAO = new AuditoriumDAO(session);
		Auditorium auditorium = auditoriumDAO.read("Auditorium", "Aud_ID", servicePeriod.getAuditorium().getAuditoriumID());
		session.close();
		period.setGroupID(studentGroup);
		period.setAuditorium(auditorium);
		//period.setEventDate(servicePeriod.getEventDate());
		period.setDiscipline(servicePeriod.getDiscipline());
		period.setLecturer(servicePeriod.getLecturer());
	
		return period;
	}
	
}
