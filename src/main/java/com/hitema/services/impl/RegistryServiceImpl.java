package com.hitema.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.hitema.dao.OrganisationDAO;
import com.hitema.dao.ServiceDAO;
import com.hitema.model.Service;
import com.hitema.services.RegistryService;

@org.springframework.stereotype.Service
@Transactional
public class RegistryServiceImpl implements RegistryService {
	
	@Autowired
	private OrganisationDAO organisationDao; 
	@Autowired
	private ServiceDAO serviceDao; 
	
	public boolean publishService(Service service,String organisationName, String password) {
		boolean isPublish = false; 
		boolean isOrganisation = organisationDao.checkOrganisation(organisationName, password);

		if(isOrganisation && serviceDao.findServiceByName(service.getNomService()) == null ){
			serviceDao.publishService(service);
			isPublish = true;
		}
		
		return isPublish;
	}

	public Service findServiceByName(String nameService) {
		Service service = serviceDao.findServiceByName(nameService);
		return service;
	}
	
	public void updateUrlService(Service service) {
		serviceDao.publishService(service);
	}
	
	public List<Service> getAllServices(){
		return serviceDao.getAllServices();
	}
	
	public boolean checkOrganisation(String organisationName,String password) {
		
		return organisationDao.checkOrganisation(organisationName, password);
	}
	
	
}
