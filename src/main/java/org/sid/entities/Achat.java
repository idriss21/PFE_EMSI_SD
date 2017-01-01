package org.sid.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Achat")
public class Achat extends Ordre{

	public Achat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Achat(int nombreAction, int quantite, double cours, Societe societe) {
		super(nombreAction, quantite, cours, societe);
		// TODO Auto-generated constructor stub
	}

	public Achat(int nombreAction, int quantite, double cours) {
		super(nombreAction, quantite, cours);
		// TODO Auto-generated constructor stub
	}

	
	
}
