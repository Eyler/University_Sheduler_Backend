package sheduler.model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "auditorium")
public class Auditorium {

	@Id
	@Column(name = "Aud_ID")
	private String auditoriumID; 
	
	@Column(name = "auditorium_location")
	private String auditoriumLocation;
	
	@Column(name = "auditorium_number")
	private String auditoriumNumber;
	
	public Auditorium() {
	
	}


	public String getAuditoriumLocation() {
		return auditoriumLocation;
	}

	public void setAuditoriumLocation(String auditoriumLocation) {
		this.auditoriumLocation = auditoriumLocation;
	}


	public Auditorium(String auditoriumLocation, String auditoriumNumber) {
		super();
		this.auditoriumLocation = auditoriumLocation;
		this.auditoriumNumber = auditoriumNumber;
		this.auditoriumID = auditoriumLocation + auditoriumNumber;
	}


	public String getAuditoriumNumber() {
		return auditoriumNumber;
	}


	public void setAuditoriumNumber(String auditoriumNumber) {
		this.auditoriumNumber = auditoriumNumber;
	}


	public String getAuditoriumID() {
		return auditoriumID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auditoriumID == null) ? 0 : auditoriumID.hashCode());
		result = prime * result + ((auditoriumLocation == null) ? 0 : auditoriumLocation.hashCode());
		result = prime * result + ((auditoriumNumber == null) ? 0 : auditoriumNumber.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auditorium other = (Auditorium) obj;
		if (auditoriumID == null) {
			if (other.auditoriumID != null)
				return false;
		} else if (!auditoriumID.equals(other.auditoriumID))
			return false;
		if (auditoriumLocation == null) {
			if (other.auditoriumLocation != null)
				return false;
		} else if (!auditoriumLocation.equals(other.auditoriumLocation))
			return false;
		if (auditoriumNumber == null) {
			if (other.auditoriumNumber != null)
				return false;
		} else if (!auditoriumNumber.equals(other.auditoriumNumber))
			return false;
		return true;
	}
	
}
