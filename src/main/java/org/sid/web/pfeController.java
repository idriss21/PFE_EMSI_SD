package org.sid.web;


import java.util.List;

import org.sid.dao.OrdreRepository;
import org.sid.dao.SocieteRepository;
import org.sid.entities.Ordre;
import org.sid.entities.Societe;
import org.sid.metier.ISocieteMetier;
import org.sid.metier.SocieteMetierImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller 
public class pfeController {
	
	
	@Autowired 
	private ISocieteMetier iSocieteMetier;

	@Autowired 
	private OrdreRepository ordreRepository;
	
	@Autowired 
	private SocieteRepository societeRepository;
	

	
	@RequestMapping(name="/index")
	public String index(Model model )
	{
		List<Societe> listSociete = societeRepository.findAll();
		
		model.addAttribute("listeSte", listSociete);
		
			
		return "index";
	}
	
	@RequestMapping("/consulterOrdre")
	public String consulterOrdre(Model model , @RequestParam(name="code")  String code )
	{
		List<Societe> listSociete = societeRepository.findAll();
		
		model.addAttribute("listeSte", listSociete);
		
		model.addAttribute("codeSte", code);
		try{		
		Societe societe = societeRepository.findOne(code);
		 Page<Ordre> listeOrdre =   iSocieteMetier.listOrdres(code, 0, 4);
		 
		 model.addAttribute("societe", societe);
		 model.addAttribute("listeOrdre", listeOrdre);
		 
		 
	} catch (Exception e) {
		model.addAttribute("exception",e);
	}
		 
		return "index";
	}
	
	
	
	@RequestMapping("/index2")
	public String index2()
	{
		return "ordre";
		
	}
	
	
	
	
	
	
	

}
