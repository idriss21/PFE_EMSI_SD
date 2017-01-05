package org.sid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING,length=5)
public abstract class Ordre implements Serializable{
	
	@Id
	@GeneratedValue
	private Long num;
	//private Date date;
	private int nombreAction;
	private int quantite;
	private double cours;
	private Date dateOrdre;
	@ManyToOne
	@JoinColumn(name="CODE_STE")
	private Societe societe;
	
	
	public Ordre() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Ordre(int nombreAction, int quantite, double cours) {
		super();
		this.nombreAction = nombreAction;
		this.quantite = quantite;
		this.cours = cours;
	}


	public Ordre(int nombreAction, int quantite, double cours, Societe societe) {
		super();
		this.nombreAction = nombreAction;
		this.quantite = quantite;
		this.cours = cours;
		this.societe = societe;
	}


	public Long getNum() {
		return num;
	}


	public void setNum(Long num) {
		this.num = num;
	}


	public int getNombreAction() {
		return nombreAction;
	}


	public void setNombreAction(int nombreAction) {
		this.nombreAction = nombreAction;
	}


	public int getQuantite() {
		return quantite;
	}


	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


	public double getCours() {
		return cours;
	}


	public void setCours(double cours) {
		this.cours = cours;
	}


	public Societe getSociete() {
		return societe;
	}


	
	public Date getDateOrdre() {
		return dateOrdre;
	}


	public void setDateOrdre(Date dateOrdre) {
		this.dateOrdre = dateOrdre;
	}


	public void setSociete(Societe societe) {
		this.societe = societe;
	}
}
