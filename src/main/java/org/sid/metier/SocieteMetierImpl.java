package org.sid.metier;

import org.sid.dao.OrdreRepository;
import org.sid.dao.SocieteRepository;
import org.sid.entities.Ordre;
import org.sid.entities.Societe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class SocieteMetierImpl implements ISocieteMetier {
	
	@Autowired
	private OrdreRepository ordreRepository;
	
	@Autowired
	private SocieteRepository societeRepository;
	

	@Override
	public Societe getDetail(String code) {
		Societe societe = societeRepository.findOne(code);
		if(societe == null ) throw new RuntimeException("Societe non trouvée !!"); 	
		return societe;
	}


	@Override
	public Ordre consulterOrdre(Long codeCpte) {
		Ordre ordre = ordreRepository.findOne(codeCpte);
		if(ordre == null ) throw new RuntimeException("Ordre Introuvable !!"); 
		return ordre;
	}


	@Override
	public Page<Ordre> listOrdres(String codeSte, int page, int size) {
		
		return ordreRepository.listeOrdres(codeSte, new PageRequest(page, size));

	}



	@Override
	public Page<Societe> chercherSociete(String codeSte, int page, int size) {
		// TODO Auto-generated method stub
		return societeRepository.chercherSociete(codeSte,new PageRequest(page, size));
	}

}
