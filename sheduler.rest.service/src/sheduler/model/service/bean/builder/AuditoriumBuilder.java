package sheduler.model.service.bean.builder;

import sheduler.model.bean.Auditorium;
import sheduler.model.service.bean.ServiceAuditorium;

public class AuditoriumBuilder {
	private Auditorium auditorium;

	public AuditoriumBuilder(Auditorium auditorium) {
		this.auditorium = auditorium;
	}

	public ServiceAuditorium build() {
		ServiceAuditorium serviceAuditorium = new ServiceAuditorium();
		serviceAuditorium.setAuditoriumID(auditorium.getAuditoriumID());
		serviceAuditorium.setAuditoriumLocation(auditorium.getAuditoriumLocation());
		serviceAuditorium.setAuditoriumNumber(auditorium.getAuditoriumNumber());
		return serviceAuditorium;
	}
}
