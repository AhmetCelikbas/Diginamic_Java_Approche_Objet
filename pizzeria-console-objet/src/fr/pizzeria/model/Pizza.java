package fr.pizzeria.model;

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
	private String code;
	/** nom */
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
		return "n°" + (this.getId() + 1) + " : " + this.getCode() + " -> " + this.getNom() + " -> "
				+ this.getCategorie() + " (" + this.getPrix() + " €)";
	}

}
