package sheduler.model.service.bean;

import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ServiceAuditoriumPeriod {

	private int periodNumber;
	
	private  Set<ServiceAuditorium> auditoriums;
	
	public ServiceAuditoriumPeriod() {
		super();
	}
	
	
	public ServiceAuditoriumPeriod(int periodNumber, Set<ServiceAuditorium> auditoriums) {
		super();
		this.periodNumber = periodNumber;
		this.auditoriums = auditoriums;
	}


	public int getPeriodNumber() {
		return periodNumber;
	}

	public void setPeriodNumber(int periodNumber) {
		this.periodNumber = periodNumber;
	}

	public Set<ServiceAuditorium> getAuditoriums() {
		return auditoriums;
	}

	public void setAuditoriums(Set<ServiceAuditorium> auditoriums) {
		this.auditoriums = auditoriums;
	}
	
	
}
