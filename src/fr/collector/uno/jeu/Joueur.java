package fr.collector.uno.jeu;

import java.util.ArrayList;

import fr.collector.uno.cartes.Carte;

public class Joueur {

	static int idCourant = 1;
	
	private int ID;
	private String nom;
	private ArrayList<Carte> lesCartes; 
	
	public Joueur(String p_nom)
	{
		this.ID = idCourant;
		idCourant++;
		this.nom = p_nom;
		this.lesCartes = new ArrayList<Carte>();
	}
	
	public int getID()
	{
		return this.ID;
	}
	
	public String getNom()
	{
		return this.nom;
	}
	
	public ArrayList<Carte> getLesCartes()
	{
		return this.lesCartes;
	}
	
	public void addCarte(Carte p_laCarte)
	{
		this.lesCartes.add(p_laCarte);
	}
	
	public void enleverCarte(Carte laCarte)
	{
		this.lesCartes.remove(laCarte);
	}
	
}
