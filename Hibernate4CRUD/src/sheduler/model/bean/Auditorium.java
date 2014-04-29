package sheduler.model.bean;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
@Table(name = "auditorium")
public class Auditorium {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Aud_ID")
	private int auditoriumID; 
	
	@Column(name = "reserved")
	private String reserved;

	@Column(name = "auditorium_location")
	private String auditoriumLocation;
	
	@Column(name = "auditorium_number")
	private int auditoriumNumber;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "auditoriumID")
	@Cascade({CascadeType.SAVE_UPDATE})
	private Set<UniversityEvent> events;
	
	@ManyToMany(mappedBy = "auditoriums")
	@Cascade({CascadeType.SAVE_UPDATE})
	private Set<StudentGroup> groups;  
	
	public Set<StudentGroup> getGroups() {
		return groups;
	}

	public void setGroups(Set<StudentGroup> groups) {
		this.groups = groups;
	}

	public Set<UniversityEvent> getEvents() {
		return events;
	}

	public void setEvents(Set<UniversityEvent> events) {
		this.events = events;
	}

	public int getAuditoriumID() {
		return auditoriumID;
	}

	public void setAuditoriumID(int auditoriumID) {
		this.auditoriumID = auditoriumID;
	}

	public String getReserved() {
		return reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}

	public String getAuditoriumLocation() {
		return auditoriumLocation;
	}

	public void setAuditoriumLocation(String auditoriumLocation) {
		this.auditoriumLocation = auditoriumLocation;
	}

	public int getAuditoriumNumber() {
		return auditoriumNumber;
	}

	public void setAuditoriumNumber(int auditoriumNumber) {
		this.auditoriumNumber = auditoriumNumber;
	}

	public Auditorium(String auditoriumLocation, int auditoriumNumber) {
		super();
		this.auditoriumLocation = auditoriumLocation;
		this.auditoriumNumber = auditoriumNumber;
	}
	
}
