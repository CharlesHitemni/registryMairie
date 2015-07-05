package com.hitema.dao;

import com.hitema.model.Organisation;

public interface OrganisationDAO {
	
	public boolean checkOrganisation(String login, String password);
	public Organisation getOrganisationByName(String organisationName);
}
