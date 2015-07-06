package com.hitema.services;

import java.util.List;

import com.hitema.model.Service;

public interface RegistryService {
	public boolean publishService(Service service, String organisationName, String password);
	public Service findServiceByName(String nameService);
	public void updateUrlService(Service service);
	public List<Service> getAllServices();

}
