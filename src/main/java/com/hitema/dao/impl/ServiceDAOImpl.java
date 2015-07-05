package com.hitema.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hitema.dao.ServiceDAO;
import com.hitema.model.Service;

@Repository
public class ServiceDAOImpl implements ServiceDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public Service findServiceByName(String nomService) {
		return (Service) sessionFactory.getCurrentSession().createCriteria(Service.class).add(Restrictions.eq("nomService",nomService)).uniqueResult();
	}

	@Transactional
	public void publishService(Service service) {
		sessionFactory.getCurrentSession().saveOrUpdate(service);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Service> getAllServices(){
		Query query = sessionFactory.getCurrentSession().createQuery("from Service");
		return query.list();
	}
}
