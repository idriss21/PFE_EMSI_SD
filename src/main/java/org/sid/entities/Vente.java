package org.sid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Vente")
public class Vente extends Ordre implements Serializable{

	public Vente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vente(int nombreAction, int quantite, double cours, Societe societe) {
		super(nombreAction, quantite, cours, societe);
		// TODO Auto-generated constructor stub
	}

	public Vente(int nombreAction, int quantite, double cours) {
		super(nombreAction, quantite, cours);
		// TODO Auto-generated constructor stub
	}

	

}

