package org.sid.entities;

import java.util.Date;



public class Achat extends Ordre{

	public Achat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Achat(Date date, int nombreAction, double prixAction) {
		super(date, nombreAction, prixAction);
		// TODO Auto-generated constructor stub
	}

	public Achat(Date date, int nombreAction, double prixAction, Societe societe) {
		super(date, nombreAction, prixAction, societe);
		// TODO Auto-generated constructor stub
	}

	
}
