package org.sid.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Societe implements Serializable{
	@Id
	private String code;

	private String nom;
	private String adresse;
	@OneToMany(mappedBy="societe",fetch=FetchType.LAZY)
	private Collection<Ordre> ordres;
	
	
	public Societe() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Societe(String code, String nom, String adresse) {
		super();
		this.code = code;
		this.nom = nom;
		this.adresse = adresse;
	}





	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	

	public Collection<Ordre> getOrdres() {
		return ordres;
	}


	public void setOrdres(Collection<Ordre> ordres) {
		this.ordres = ordres;
	}
	
	
	
	

}
