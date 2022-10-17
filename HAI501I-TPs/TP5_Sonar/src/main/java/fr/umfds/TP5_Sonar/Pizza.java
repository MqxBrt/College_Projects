package fr.umfds.TP5_Sonar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pizza {
	private List<Ingredient> composition =new ArrayList<>();
	private String nom;
	private float prix;



	public boolean estRouge(){
		for (Ingredient i:composition){
			if (i.getNom().equals("sauce tomate")) return true;
		}
		return false;
	}

	public boolean estBlanche(){
		boolean sauceTomate=false;
		boolean creme=false;
		for (Ingredient i:composition){
			if (i.getNom().equals("sauce tomate")) sauceTomate=true;
			if (i.getNom().equals("crème fraîche")) creme=true;
		}
		return !sauceTomate&&creme;
	}

	public boolean  estVegetarienne(){
		boolean result=true;
		for (Ingredient i:composition){
			if (!i.isVegetarien()) return false;
		}
		return result;
	}

	public Pizza(String nom, float prix){
		this.nom=nom;
		this.prix=prix;
		composition = new ArrayList<>();
	}



	public void ajoutIngredient(Ingredient i){
		if (!composition.contains(i)){
			composition.add(i);
		}
	}

	public String getNom() {
		return nom;
	}

	public float getPrix() {
		return prix;
	}

	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (o.getClass() != this.getClass())
			return false;
		Pizza po= (Pizza)o;
		return nom.equals(po.getNom()) && po.getPrix()==prix;
	}
	
	public int hashCode() {
		return Objects.hash(composition, nom, prix);
	}

	public void veganize() {
		nom=nom+" vegan";
		for (Ingredient i:composition) {
			if (!i.isVegetarien()) {
				composition.remove(i);
			}
		}
	}
	
	public String formattedIngredients() {
		StringBuilder s= new StringBuilder();
		for (Ingredient ing:composition) {
			s.append(ing.getNom());
			s.append(" ");
		}
		return s.toString();
	}
	
	public Ingredient[] ingredients() {
		return composition.toArray(new Ingredient[0]);
	}
}
