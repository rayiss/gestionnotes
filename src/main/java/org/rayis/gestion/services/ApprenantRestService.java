package org.rayis.gestion.services;

import org.rayis.gestion.dao.ApprenantRepository;
import org.rayis.gestion.entities.Apprenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class ApprenantRestService {

	@Autowired
	private ApprenantRepository apprenantRepository;
	
	//@RequestMapping(value="/saveApprenant", method = RequestMethod.POST)
	public Apprenant saveApprenant(@RequestBody Apprenant apprenant) {
		return apprenantRepository.save(apprenant);
	}
	 
	//@RequestMapping(value = "/apprenants")
	public Page<Apprenant> listApprenants(int page, int size){
		return apprenantRepository.findAll(PageRequest.of(page, size));
	}
}
