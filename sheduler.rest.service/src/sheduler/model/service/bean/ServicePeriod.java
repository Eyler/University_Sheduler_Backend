package sheduler.model.service.bean;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ServicePeriod {

	private int periodID; 
	
	private String day;

	private int periodNumber;
	
	private String periodType;
	
	private int groupID;

	private ServiceAuditorium auditorium;
	
	private Date eventDate;

	private String discipline;
	
	private String lecturer;
	
	public ServicePeriod() {
		super();
	}
	
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getPeriodNumber() {
		return periodNumber;
	}

	public void setPeriodNumber(int periodNumber) { 
		this.periodNumber = periodNumber;
	}


	public String getPeriodType() {
		return periodType;
	}

	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}

	public int getGroupID() {
		return groupID;
	}

	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}

	public int getPeriodID() {
		return periodID;
	}

	public void setPeriodID(int periodID) {
		this.periodID = periodID;
	}

	public ServiceAuditorium getAuditorium() {
		return auditorium;
	}

	public void setAuditorium(ServiceAuditorium auditorium) {
		this.auditorium = auditorium;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getDiscipline() {
		return discipline;
	}

	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}

	public String getLecturer() {
		return lecturer;
	}

	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}
	
}
