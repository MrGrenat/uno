package fr.collector.uno.cartes;

public enum ECouleur {

	BLEU("Bleu"),
	ROUGE("Rouge"),
	JAUNE("Jaune"),
	VERT("Vert"),
	NOIR("Noir"),
	BLANC("Blanc");
	
	String couleur;
	
	ECouleur(String p_couleur)
	{
		this.couleur = p_couleur;
	}
	
	public String toString()
	{
		return this.couleur;
	}
}
