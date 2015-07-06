package com.hitema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hitema.model.Service;
import com.hitema.services.RegistryService;

@Controller
public class publishController {
	
	@Autowired
	private RegistryService registryService;
	
	
	@RequestMapping(value = "/accueil", method = RequestMethod.GET)
    public ModelAndView publishAccueil() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Accueil publish");
        model.setViewName("accueil");

        return model;
    }

	@RequestMapping(value = "/publish", method = RequestMethod.POST)
    public ModelAndView publishTraitement(@RequestParam("nameService")String nameService, @RequestParam("description")String description,@RequestParam("url")String url, @RequestParam("organisation")String organisation, @RequestParam("password")String password) {

		Service service = new Service();
		service.setDescriptionService(description);
		service.setNomService(nameService);
		service.setUrlService(url);
        ModelAndView model = new ModelAndView();
        
        if(!registryService.publishService(service, organisation, password))
        	model.addObject("messageError", "Le service existe déja ! ");
        else
        	model.addObject("messageSucces", "Le service à été publié avec succés!");
        
        model.setViewName("accueil");

        return model;
    }
	
	@RequestMapping(value = "/publishUpdate", method = RequestMethod.POST)
    public ModelAndView publishUpdate(@RequestParam("serviceSelected")String nameService, @RequestParam("url")String nouvelUrl,@RequestParam("organisation")String organisation, @RequestParam("password")String password) {

		Service service =registryService.findServiceByName(nameService);
		service.setUrlService(nouvelUrl);
		ModelAndView model = new ModelAndView();
		if (registryService.checkOrganisation(organisation, password))
		{
			 registryService.updateUrlService(service);
			 model.addObject("messageSucces", "Le service à été mis à jour avec succés!");
		}
		else
			model.addObject("messageError", "Vos identifiants sont incorrects!");
		List<Service> services = registryService.getAllServices();
		
        model.addObject("listeServices", services);
        model.setViewName("accueilUpdate");

        return model;
    }
	
	@RequestMapping(value = "/accueilUpdate", method = RequestMethod.GET)
    public ModelAndView accueilUpdate() {

		List<Service> services = registryService.getAllServices();
		
		ModelAndView model = new ModelAndView();
        model.addObject("listeServices", services);
        model.setViewName("accueilUpdate");

        return model;
    }
	

}
