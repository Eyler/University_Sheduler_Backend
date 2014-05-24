package sheduler.model.service.bean;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class ServiceAuditorium {

	private String auditoriumID; 
	
	private String auditoriumLocation;
	
	private String auditoriumNumber;
	
	public ServiceAuditorium() {
		super();
	}
	

	public String getAuditoriumLocation() {
		return auditoriumLocation;
	}

	public void setAuditoriumLocation(String auditoriumLocation) {
		this.auditoriumLocation = auditoriumLocation;
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

	public void setAuditoriumID(String auditoriumID) {
		this.auditoriumID = auditoriumID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		ServiceAuditorium other = (ServiceAuditorium) obj;
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
