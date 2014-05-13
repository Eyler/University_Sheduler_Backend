package sheduler.model.service.bean.builder;

import sheduler.model.bean.Period;
import sheduler.model.service.bean.ServicePeriod;

public class PeriodBuilder {
	
	private Period period;
	
	public PeriodBuilder(Period period) {
		this.period = period;
	}
	
	public ServicePeriod build() {
		ServicePeriod servicePeriod = new ServicePeriod();
		servicePeriod.setPeriodID(period.getPeriodID());
		servicePeriod.setDay(period.getDay());
		servicePeriod.setPeriodNumber(period.getPeriodNumber());
		servicePeriod.setPeriodType(period.getPeriodType());
		servicePeriod.setGroupID(period.getGroupID().getGroupID());
		servicePeriod.setAuditorium(new AuditoriumBuilder(period.getAuditorium()).build());
		servicePeriod.setEventDate(period.getEventDate());
		servicePeriod.setDiscipline(period.getDiscipline());
		servicePeriod.setLecturer(period.getLecturer());
		return servicePeriod;
	} 
	
}
