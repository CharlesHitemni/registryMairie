package com.hitema.services;

import com.hitema.model.Service;

public interface RegistryService {
	public boolean publishService(Service service, String organisationName, String password);
	public Service findServiceByName(String nameService);

}
