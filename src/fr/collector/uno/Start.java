package fr.collector.uno;

import java.util.ArrayList;
import java.util.Scanner;

import fr.collector.uno.cartes.Carte;
import fr.collector.uno.cartes.CarteNumero;
import fr.collector.uno.cartes.CarteSpeciale;
import fr.collector.uno.cartes.ECouleur;
import fr.collector.uno.jeu.Joueur;
import fr.collector.uno.jeu.Partie;

public class Start {

	static Scanner scanner;
	static Partie laPartie;
	
	static ArrayList<Carte> lesCartes = new ArrayList<Carte>();
	
	
	public static void main(String[] args) {
		
		scanner = new Scanner(System.in);
				
		creerLesCartes();

		laPartie = new Partie();
				
		creerJoueurs(2);
		laPartie.lancerManche();
		
		
		for(Joueur j : laPartie.getJoueurs())
		{
			System.out.println(j.getNom());

			for(Carte c : j.getLesCartes())
			{
				System.out.println(c.getNom() + " - " + c.getCouleur());
			}
		}		
	}
	
	public static Partie getLaPartie()
	{
		return laPartie;
	} 
	
	public static ArrayList<Carte> getLesCartes()
	{
		return lesCartes;
	}
	
	private static void creerLesCartes()
	{
		
		lesCartes.add(new CarteNumero(0, ECouleur.BLEU.toString()));
		lesCartes.add(new CarteNumero(0, ECouleur.ROUGE.toString()));
		lesCartes.add(new CarteNumero(0, ECouleur.JAUNE.toString()));
		lesCartes.add(new CarteNumero(0, ECouleur.VERT.toString()));
		
		int i = 0;
				
		while(i != 2)
		{
			for(int j = 1; j <= 9; j++)
			{
				lesCartes.add(new CarteNumero(j, ECouleur.BLEU.toString()));
				lesCartes.add(new CarteNumero(j, ECouleur.ROUGE.toString()));
				lesCartes.add(new CarteNumero(j, ECouleur.JAUNE.toString()));
				lesCartes.add(new CarteNumero(j, ECouleur.VERT.toString()));
			}
			
			for(int j = 0; j < 3; j++)
			{
				String nom = ((j == 0) ? "+2" : ((j== 1) ? "Inversion" : "Passe ton tour" ) );
				
				lesCartes.add(new CarteSpeciale(nom, ECouleur.BLEU.toString()));
				lesCartes.add(new CarteSpeciale(nom, ECouleur.ROUGE.toString()));
				lesCartes.add(new CarteSpeciale(nom, ECouleur.JAUNE.toString()));
				lesCartes.add(new CarteSpeciale(nom, ECouleur.VERT.toString()));		
			}
					
			i++;
		}
		
		lesCartes.add(new CarteSpeciale("+2?", ECouleur.BLEU.toString()));
		lesCartes.add(new CarteSpeciale("+2?", ECouleur.ROUGE.toString()));
		lesCartes.add(new CarteSpeciale("+2?", ECouleur.JAUNE.toString()));
		lesCartes.add(new CarteSpeciale("+2?", ECouleur.VERT.toString()));
			
		i = 0;
		
		while(i != 2)
		{
			String nom = (i == 0 ? "Changement de couleur" : "+4");
			
			for(int j = 0; j < 4; j++)
			{
				lesCartes.add(new CarteSpeciale(nom, ECouleur.NOIR.toString()));
			}
			
			i++;			
		}
		
		lesCartes.add(new CarteSpeciale("+4?", ECouleur.NOIR.toString()));
		lesCartes.add(new CarteSpeciale("+4?", ECouleur.NOIR.toString()));

		lesCartes.add(new CarteSpeciale("Echan -> ge de jeu", ECouleur.NOIR.toString()));		
		lesCartes.add(new CarteSpeciale("Echange de jeu", ECouleur.NOIR.toString()));		
		lesCartes.add(new CarteSpeciale("+1 Downpour", ECouleur.BLANC.toString()));		
		lesCartes.add(new CarteSpeciale("+2 Downpour", ECouleur.BLANC.toString()));		

		for(int j = 0; j < 4; j++)
		{
			lesCartes.add(new CarteSpeciale("Boomerang", ECouleur.BLANC.toString()));		
		}		
	}

	private static void creerJoueurs(int nbr)
	{
		for(int i = 0; i < nbr; i++)
		{
			String nom;
			System.out.print("Veuillez entrer le nom du joueur " + (i+1) + ": ");
			nom = scanner.next();
			laPartie.addJoueur(new Joueur(nom));
		}
	}
}
