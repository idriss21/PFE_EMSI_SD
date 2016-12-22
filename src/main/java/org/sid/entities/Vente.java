package org.sid.entities;

import java.util.Date;


public class Vente extends Ordre{

	public Vente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vente(Date date, int nombreAction, double prixAction) {
		super(date, nombreAction, prixAction);
		// TODO Auto-generated constructor stub
	}

	public Vente(Date date, int nombreAction, double prixAction, Societe societe) {
		super(date, nombreAction, prixAction, societe);
		// TODO Auto-generated constructor stub
	}

}
