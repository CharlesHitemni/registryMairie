package com.hitema.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hitema.dao.OrganisationDAO;
import com.hitema.model.Organisation;

@Repository
public class OrganisationDAOImpl implements OrganisationDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public boolean checkOrganisation(String organisationName, String password) {
		
		Organisation organisation = getOrganisationByName(organisationName);
		
		boolean OrganisationNameCheck = false;
		boolean passwordCheck = false;
		if(organisation != null)
		{
			OrganisationNameCheck = true;
			if(organisation.getPassword().equals(password))
				passwordCheck=true;
		}
		
		if(OrganisationNameCheck && passwordCheck)
			return true;
		
		return false;
	}

	@Transactional
	public Organisation getOrganisationByName(String organisationName) {
		return (Organisation) sessionFactory.getCurrentSession().createCriteria(Organisation.class).add(Restrictions.eq("organisationName",organisationName)).uniqueResult();
	}
}
