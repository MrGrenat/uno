package fr.collector.uno.cartes;

public class CarteNumero extends Carte {

	public CarteNumero(int p_numero, String p_couleur)
	{
		super.nom = String.valueOf(p_numero); 
		super.couleur = p_couleur;
	}
}
