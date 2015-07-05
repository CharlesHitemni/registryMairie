package com.hitema.dao;

import java.util.List;

import com.hitema.model.Service;

public interface ServiceDAO {
	
	public Service findServiceByName(String nameService);
	public void publishService(Service service);
	public List<Service> getAllServices();
}
