package sheduler.model.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "period")
public class Period {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "period_ID")
	private int periodID; 
	
	@Column(name = "day")
	private String day;

	@Column(name = "period_number")
	private int periodNumber;
	
	// Types = period, event
	@Column(name = "period_type")
	private String periodType;
	
	@Column(name = "discipline")
	private String discipline;
	
	@Column(name = "lecturer")
	private String lecturer;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@Cascade({CascadeType.SAVE_UPDATE})
	@JoinColumn(name = "group_ID")
	private StudentGroup groupID;

	@ManyToOne
	@Cascade({CascadeType.SAVE_UPDATE})
	@JoinColumn(name = "Aud_ID")
	private Auditorium auditorium;
	
	@Column(name = "event_day")
	private Date eventDate;
	
	public Period() {
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

	public StudentGroup getGroupID() {
		return groupID;
	}

	public void setGroupID(StudentGroup groupID) {
		this.groupID = groupID;
	}

	public int getPeriodID() {
		return periodID;
	}

	public void setPeriodID(int periodID) {
		this.periodID = periodID;
	}

	public Auditorium getAuditorium() {
		return auditorium;
	}

	public void setAuditorium(Auditorium auditorium) {
		this.auditorium = auditorium;
	}

	public String getPeriodType() {
		return periodType;
	}

	public void setPeriodType(String periodType) {
		this.periodType = periodType;
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
