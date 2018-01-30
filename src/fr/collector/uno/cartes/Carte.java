package fr.collector.uno.cartes;

public abstract class Carte {

	String nom;
	String couleur;
	
	
	public Carte renvoyerCarte() { 
		return this;
	}
	
	public String getNom()
	{
		return nom;
	}
	
	public String getCouleur()
	{
		return couleur;
	}
	
}
