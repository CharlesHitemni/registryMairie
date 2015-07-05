package com.hitema.services.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hitema.dao.OrganisationDAO;
import com.hitema.dao.ServiceDAO;
import com.hitema.model.Service;
import com.hitema.services.RegistryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context-RegistryService-test.xml" })
@Transactional
public class RegistryServiceImplTest {

	@Autowired
	private RegistryService registryService;
	@Autowired
	private ServiceDAO serviceDao; 
	@Autowired
	private OrganisationDAO organisationDao; 
	
	
	@Test
	public void shouldInsertOneService() {
		Service service = new Service(); 
		service.setDescriptionService("description du test");
		service.setNomService("bidon");
		service.setUrlService("http://urlbidon.fr");
		boolean isPublish = registryService.publishService(service, "organisationTest", "bidon");
		assertThat(isPublish).isEqualTo(true);
		Service serviceExpected = serviceDao.findServiceByName("bidon");
		assertThat(serviceExpected).isNotNull();
		assertThat(serviceExpected.getNomService()).isEqualTo("bidon");
	}
	
	@Test
	public void shouldNotInserOneService() {
		Service service = new Service(); 
		service.setDescriptionService("description du test");
		service.setNomService("bidon");
		service.setUrlService("http://urlbidon.fr");
		boolean isPublish = registryService.publishService(service, "organisationTest", "bou");
		assertThat(isPublish).isEqualTo(false);
		Service serviceExpected = serviceDao.findServiceByName("bidon");
		assertThat(serviceExpected).isNull();
	}
	
	@Test
	public void shouldNotInserTwoServiceWithTheSameName() {
		Service service = new Service(); 
		service.setDescriptionService("description du test");
		service.setNomService("test");
		service.setUrlService("http://urlbidon.fr");
		registryService.publishService(service, "organisationTest", "bidon");
		List<Service> services = serviceDao.getAllServices();
		assertThat(services.size()).isEqualTo(1);
	}

	@Test
	public void shouldReturnOneOrganisation(){
		assertThat(organisationDao.getOrganisationByName("organisationTest")).isNotNull();
	}

	@Test
	public void testFindServiceByName() {
		Service service = registryService.findServiceByName("test");
		assertThat(service).isNotNull();
	}

}
