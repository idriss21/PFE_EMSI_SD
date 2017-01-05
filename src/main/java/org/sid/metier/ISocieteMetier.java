package org.sid.metier;

import org.sid.entities.Ordre;
import org.sid.entities.Societe;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;



public interface ISocieteMetier {
	  public Ordre consulterOrdre(Long codeCpte);
	  public Societe getDetail(String code);
	  public Page<Ordre> listOrdres(String codeSte,int page,int size);
	  public Page<Societe> chercherSociete(String codeSte   , int page , int size);  
}
