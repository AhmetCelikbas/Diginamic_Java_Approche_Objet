package fr.pizzeria.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Class Pizza
 * 
 * @author keylan
 *
 */
public class Pizza {

	/** lastId */
	private static int lastId = 1;
	/** id */
	private int id;
	/** code */
	@ToString(uppercase = true)
	private String code;
	/** nom */
	@ToString
	private String nom;
	/** prix */
	private double prix;
	/** categorie */
	private CategoriePizza categorie;

	/**
	 * Constructeur Pizza lastId auto-incrémenté
	 * 
	 * @param code
	 * @param nom
	 * @param prix
	 */
	public Pizza(String code, String nom, double prix, CategoriePizza categorie) {
		this.id = Pizza.lastId;
		Pizza.lastId++;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
	}

	public Pizza(String code, String nom, double prix) {
		this.id = Pizza.lastId;
		Pizza.lastId++;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
	}

	/**
	 * Getter
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter
	 * 
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Setter
	 * 
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Getter
	 * 
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter
	 * 
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter
	 * 
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * Setter
	 * 
	 * @param prix
	 *            the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

	/**
	 * Getter
	 * 
	 * @return the categorie
	 */
	public CategoriePizza getCategorie() {
		return categorie;
	}

	/**
	 * Setter
	 * 
	 * @param categorie
	 *            the categorie to set
	 */
	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		try {
			for (Field field : this.getClass().getDeclaredFields()) {
				field.setAccessible(true);
				if (field.getAnnotation(ToString.class) != null) {
					for (Annotation annotation : field.getDeclaredAnnotations()) {
						if (annotation instanceof ToString) {
							ToString toString = (ToString) annotation;
							if (toString.uppercase()) {
								return "n°" + (this.getId() + 1) + " : " + this.getCode() + " -> " + this.getNom()
										+ " -> " + this.getCategorie() + " (" + this.getPrix() + " €)";
							} else {
								return null;
							}
						}

					}

				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

}
