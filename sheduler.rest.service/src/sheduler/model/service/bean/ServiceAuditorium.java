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


}
