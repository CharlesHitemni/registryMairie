package com.hitema.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hitema.dao.ServiceDAO;
import com.hitema.model.Service;
import com.hitema.services.RegistryService;

@Component
@Path("/registry")
public class RegistryServiceRest {

	@Autowired
	private ServiceDAO serviceDao;
	@Autowired
	private RegistryService registryService;
 
	@GET
	@Produces("application/json")
	@Path("/findServices")
	public List<Service> getAllServices() {
		List<Service> services = serviceDao.getAllServices();
		if(services == null ){
			return new ArrayList<Service>();
		}
		return services;
	}
	
	@GET
	@Produces("application/json")
	@Path("/findServices/{nameService}")
	public Service getServicesByName(@PathParam("nameService") String nameService) {
		Service service  = registryService.findServiceByName(nameService);
		if(service == null){
			return new Service();
		}
		return service;
	}
}
