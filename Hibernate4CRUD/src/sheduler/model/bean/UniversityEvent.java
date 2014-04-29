package sheduler.model.bean;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "event")
public class UniversityEvent {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "event_ID")
	private int eventID;
	
	@ManyToOne
	@Cascade({CascadeType.SAVE_UPDATE})
	@JoinColumn(name = "Aud_ID")
	private Auditorium auditoriumID;
	
	@ManyToMany(mappedBy = "universityEvents")  
	@Cascade({CascadeType.SAVE_UPDATE})
	private Set<StudentGroup> groups;  
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "description")
	private String description;

	@Column(name = "time")
	private Date time;

	public UniversityEvent(String type, String description, Date time) {
		super();
		this.type = type;
		this.description = description;
		this.time = time;
	}

	public int getEventID() {
		return eventID;
	}
	
	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	public Auditorium getAuditoriumID() {
		return auditoriumID;
	}

	public void setAuditoriumID(Auditorium auditoriumID) {
		this.auditoriumID = auditoriumID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}
