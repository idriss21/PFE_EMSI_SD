package org.sid.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
<<<<<<< HEAD
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document
public class Societe implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
=======
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Societe implements Serializable{
	@Id
	private String code;
>>>>>>> 0af2fd25ca9c18b05bc05df8498bd97e7f246dd9
	private String nom;
	private String adresse;
	@OneToMany(mappedBy="societe",fetch=FetchType.LAZY)
	private Collection<Ordre> ordres;
	
	
	public Societe() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Societe(Long code, String nom, String adresse) {
		super();
		this.code = code;
		this.nom = nom;
		this.adresse = adresse;
	}


	public Long getCode() {
		return code;
	}


	public void setCode(Long code) {
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
