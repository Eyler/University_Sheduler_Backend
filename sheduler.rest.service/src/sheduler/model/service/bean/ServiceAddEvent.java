package sheduler.model.service.bean;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ServiceAddEvent {

	private String day;
	
	private int groupID;
	
	private Date eventDate;
	
	public String getDay() {
		return day;
	}
	
	private ServiceAuditorium auditorium; 
	
	public void setDay(String day) {
		this.day = day;
	}

	public int getGroupID() {
		return groupID;
	}

	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}

	public ServiceAddEvent(String day, int groupID) {
		super();
		this.day = day;
		this.groupID = groupID;
	}

	public ServiceAddEvent() {
		super();
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public ServiceAuditorium getAuditorium() {
		return auditorium;
	}

	public void setAuditorium(ServiceAuditorium auditorium) {
		this.auditorium = auditorium;
	}
}
