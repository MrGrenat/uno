package fr.collector.uno.jeu;

import java.util.ArrayList;
import java.util.Random;

import fr.collector.uno.Start;
import fr.collector.uno.cartes.Carte;

public class Partie {

	private Joueur joueurActuel;
	private Carte derniereCarteJouee;
	
	private ArrayList<Joueur> lesJoueurs;
	public ArrayList<Carte> laPioche;
	private ArrayList<Carte> lesCartesJouees;
	
	public Partie()
	{
		this.lesJoueurs = new ArrayList<Joueur>();
		this.laPioche = new ArrayList<Carte>();
		this.lesCartesJouees = new ArrayList<Carte>();		
	}
	
	public Joueur getJoueurActuel()
	{
		return this.joueurActuel;
	}
	
	public Carte getDerniereCarteJouee()
	{
		return this.derniereCarteJouee;
	}
	
	public void addJoueur(Joueur leJoueur)
	{
		this.lesJoueurs.add(leJoueur);
	}
	
	public void removeJoueur(Joueur leJoueur)
	{
		this.lesJoueurs.remove(leJoueur);
	}
	
	public ArrayList<Joueur> getJoueurs()
	{
		return this.lesJoueurs;
	}
	
	public void jouer()
	{		
		
	}
	
	public void genererPioche()
	{
		ArrayList<Carte> cartes = new ArrayList<Carte>(Start.getLesCartes());
			
		while(cartes.size() != 0)
		{
			int rand = new Random().nextInt(cartes.size());
			
			laPioche.add(cartes.get(rand));
			cartes.remove(rand);			
		}
	}
	
	public void donnerCartes()
	{
		int i = 0;
		while(i != 7)
		{
			for(Joueur unJoueur : lesJoueurs)
			{
				unJoueur.addCarte(laPioche.get(0));
				laPioche.remove(0);
			}
			
			i++;
		}
		
	}
	
	public void choisirCarteDebut()
	{
		boolean choisi = false;
		int i = 0;
		
		while(!choisi)
		{			
			if(!laPioche.get(i).getCouleur().equals("Noir") && !laPioche.get(i).getCouleur().equals("Blanc"))
			{
				lesCartesJouees.add(laPioche.get(i));
				derniereCarteJouee = laPioche.get(i);
				laPioche.remove(i);
				choisi = true;
			}
			else
				i++;			
		}
	}
	
	public void lancerManche()
	{
		if(lesJoueurs.size() >= 2)
		{
			genererPioche();
			donnerCartes();		
			choisirCarteDebut();

		}
		else 
		{
			System.out.println("Il faut être 2 joueurs pour jouer !");
		}
		
	}
}
