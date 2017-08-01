/**
 * 
 */
package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

/**
 * @author keylan Data Access Object : TABLEAU
 */
public class PizzaDaoTableau implements iPizzaDao {
	/** tableauPizzas */
	private static Pizza[] tableauPizzas = new Pizza[8];

	/*
	 * Définition des pizzas !
	 */
	static {
		tableauPizzas[0] = new Pizza("PEP", "Pépéroni", 12.50);
		tableauPizzas[1] = new Pizza("MAR", "Margherita", 14.00);
		tableauPizzas[2] = new Pizza("REIN", "La Reine", 11.50);
		tableauPizzas[3] = new Pizza("FRO", "La 4 fromages", 12.00);
		tableauPizzas[4] = new Pizza("CAN", "La cannibale", 12.50);
		tableauPizzas[5] = new Pizza("SAV", "La savoyarde", 13.00);
		tableauPizzas[6] = new Pizza("ORI", "L’orientale", 13.50);
		tableauPizzas[7] = new Pizza("IND", "L’indienne", 14.00);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.iPizzaDao#findAllPizzas()
	 */
	@Override
	public Pizza[] findAllPizzas() {
		return tableauPizzas; // retourner le tableau de pizzas
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.iPizzaDao#saveNewPizza(fr.pizzeria.model.Pizza)
	 */
	@Override
	public boolean saveNewPizza(Pizza pizza) {
		/*
		 * On cherche un emplacement libre dans le tableau
		 */
		for (int i = 0; i < tableauPizzas.length; i++) { // on parcourt le tableau de pizzas
			if (tableauPizzas[i] == null) { // Si on trouve un emplacement libre dans le tableau, on ajoute la pizza
											// dans cet emplacement
				tableauPizzas[i] = new Pizza(pizza.getCode(), pizza.getNom(), pizza.getPrix()); // Ajouter la nouvelle
																								// pizza
				return true; // on notifie l'ajout de la pizza en retourant un booleen positif
			}
		}

		/*
		 * Si aucun emplacement libre n'a été trouvé, on agrandi le tableau des pizzas
		 * puis on ajoute la nouvelle pizza à la fin du tableau
		 */
		Pizza[] BufferTableauPizzas = new Pizza[tableauPizzas.length + 1]; // Créer un nouveau tableau avec une taille
																			// plus grande
		System.arraycopy(tableauPizzas, 0, BufferTableauPizzas, 0, tableauPizzas.length); // Copier le tableau des
																							// pizzas dans le nouveau
																							// tableau de taille plus
																							// grande
		BufferTableauPizzas[tableauPizzas.length] = new Pizza(pizza.getCode(), pizza.getNom(), pizza.getPrix()); // Ajouter
																													// la
																													// nouvelle
																													// pizza
																													// à
																													// la
																													// fin
																													// du
																													// nouveau
																													// tableau
		tableauPizzas = BufferTableauPizzas; // on référence le tableau de pizzas sur le nouveau tableau de pizzas.
		return true; // on notifie l'ajout de la pizza en retourant un booleen positif
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.iPizzaDao#updatePizza(java.lang.String,
	 * fr.pizzeria.model.Pizza)
	 */
	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) {
		for (int i = 0; i < tableauPizzas.length; i++) { // on parcourt le tableau de pizzas
			if (tableauPizzas[i].getCode().equals(codePizza)) { // Si on trouve la pizza correspondant au code
				tableauPizzas[i].setCode(pizza.getCode()); // définir le code de la pizza
				tableauPizzas[i].setNom(pizza.getNom()); // définir le nom de la pizza
				tableauPizzas[i].setPrix(pizza.getPrix()); // définir le prix de la pizza
				return true; // on notifie la mise à jour de la pizza en retourant un booleen positif
			}
		}
		return false; // Si aucune pizza ne correspond au code de la pizza, on retourne un booleen
						// négatif
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.iPizzaDao#getPizzaByCode(java.lang.String)
	 */
	@Override
	public Pizza getPizzaByCode(String codePizza) {
		for (int i = 0; i < tableauPizzas.length; i++) { // on parcourt le tableau de pizzas
			if(tableauPizzas[i] == null) {
				return null;
			}
			if (tableauPizzas[i].getCode().equals(codePizza)) { // Si on trouve la pizza correspondant au code
				return tableauPizzas[i]; // on retourne la pizza
			}
		}
		return null; // Si aucune pizza ne correspond au code de la pizza, on retourne null
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.iPizzaDao#deletePizza(java.lang.String)
	 */
	@Override
	public boolean deletePizza(String codePizza) {
		for (int i = 0; i < tableauPizzas.length; i++) { // on parcourt le tableau de pizzas
			if (tableauPizzas[i].getCode().equals(codePizza)) { // Si on trouve la pizza correspondant au code
				tableauPizzas[i] = null; // On supprime la pizza
				return true; // on notifie la suppression de la pizza en retourant un booleen positif
			}
		}
		return false; // Si aucune pizza ne correspond au code de la pizza, on retourne un booleen
						// négatif
	}

}
