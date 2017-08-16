/**
 * 
 */
package fr.pizzeria.model;

/**
 * @author keylan
 *
 */
public enum CategoriePizza {
	/** INDEFINIE */
	INDEFINIE("Indefinie"), 
	/** VIANDE */
	VIANDE("Viande"), 
	/** POISSON */
	POISSON("Poisson"), 
	/** SANS_VIANDE */
	SANS_VIANDE("Sans Viande");
	
	/** categoriePizza */
	private final String categoriePizza;
		
	/**
	 * @param categoriePizza
	 */
	CategoriePizza(String categoriePizza) {
		this.categoriePizza = categoriePizza;
	}
	
	/** Method
	 * @param categorie
	 * @return
	 */
	public static CategoriePizza fromString(String categorie) {
		for(CategoriePizza value:CategoriePizza.values()) {
			if(value.categoriePizza.equalsIgnoreCase(categorie)) {
				return value;
			}
		}
		return null;
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	public String toString() {
		return categoriePizza;
	}
}
