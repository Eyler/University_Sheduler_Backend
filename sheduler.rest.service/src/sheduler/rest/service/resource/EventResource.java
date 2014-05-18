package sheduler.rest.service.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import sheduler.model.service.bean.ServicePeriod;

@Path("/events")
public class EventResource {
	
	@GET
	@Path("add")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public List<ServicePeriod> getScheduler(JAXBElement<ServicePeriod> p) {
		
		
		return null;
	}
	
}
