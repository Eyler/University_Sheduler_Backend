import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.YarikPeriod;
import models.YarikStudentGroup;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import sheduler.model.HibernateUtil;
import sheduler.model.bean.Auditorium;
import sheduler.model.bean.Period;
import sheduler.model.bean.StudentGroup;
import controllers.Parser;

/**
 * Created by ykoby_000 on 09.05.2014.
 */
public class WebDriverScheduleParser {
	
	private static Map<String, Auditorium> auditoriumCache = new HashMap<>();
	
    public static void main(String[] args) throws InterruptedException {
        Parser parser = new Parser();
        SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		int i = 0;
        List<YarikStudentGroup> studentGroupList = parser.start();
        //PeriodDAO periodDAO = new PeriodDAO(session);
        for(YarikStudentGroup yarikGroup : studentGroupList) {
        	session.beginTransaction();
        	StudentGroup studentGroup = new StudentGroup(yarikGroup.getGroupName(), yarikGroup.getInstitute());
        	studentGroup.setGroupID(i++);
        	for(YarikPeriod yarikPeriod : yarikGroup.getSchedule()) {
        		Period period = new Period();
        		Auditorium auditorium = new Auditorium(yarikPeriod.getAuditorium().getLocation(), yarikPeriod.getAuditorium().getNumber());
        		if(auditoriumCache.get(auditorium.getAuditoriumID()) == null) {
        			auditoriumCache.put(auditorium.getAuditoriumID(), auditorium);
        		} else {
        			auditorium = auditoriumCache.get(auditorium.getAuditoriumID());
        		} 
        		period.setAuditorium(auditorium);
        		period.setDay(yarikPeriod.getDay());
        		period.setPeriodNumber(yarikPeriod.getNumber());
        		period.setDiscipline(yarikPeriod.getDiscipline());
        		period.setLecturer(yarikPeriod.getLecturer());
        		period.setPeriodType("period");
        		period.setGroupID(studentGroup);
        		session.save(period);	
        	}
        	session.getTransaction().commit();
        }
        session.close();
    }

}
