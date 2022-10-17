package fr.umfds.TP5_Sonar;

public class Ingredient {

	private String nom;
	private boolean vegetarien;
	public String getNom() {
		return nom;
	}
	public boolean isVegetarien() {
		return vegetarien;
	}
	public Ingredient(String nom, boolean vegetarien) {
		this.nom = nom;
		this.vegetarien = vegetarien;
	}
	
	public boolean equivaut(Ingredient i) {
		return nom.equals(i.getNom());
	}
	
}
