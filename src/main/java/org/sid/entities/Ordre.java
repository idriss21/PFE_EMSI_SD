package org.sid.entities;

import java.io.Serializable;
import java.util.Date;



public abstract class Ordre implements Serializable{
	
	
	private Long num;
	private Date date;
	private int nombreAction;
	private double prixAction;
	private Societe societe;
	
	
	public Ordre(Date date, int nombreAction, double prixAction, Societe societe) {
		super();
		this.date = date;
		this.nombreAction = nombreAction;
		this.prixAction = prixAction;
		this.societe = societe;
	}


	public Ordre(Date date, int nombreAction, double prixAction) {
		super();
		this.date = date;
		this.nombreAction = nombreAction;
		this.prixAction = prixAction;
	}


	public Ordre() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getNum() {
		return num;
	}


	public void setNum(Long num) {
		this.num = num;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public int getNombreAction() {
		return nombreAction;
	}


	public void setNombreAction(int nombreAction) {
		this.nombreAction = nombreAction;
	}


	public double getPrixAction() {
		return prixAction;
	}


	public void setPrixAction(double prixAction) {
		this.prixAction = prixAction;
	}


	public Societe getSociete() {
		return societe;
	}


	public void setSociete(Societe societe) {
		this.societe = societe;
	}
	
	

}
