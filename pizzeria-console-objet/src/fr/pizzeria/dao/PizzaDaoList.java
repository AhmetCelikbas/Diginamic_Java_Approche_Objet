/**
 * 
 */
package fr.pizzeria.dao;

import java.util.ArrayList;
import fr.pizzeria.model.Pizza;

/**
 * @author keylan
 *
 */
public class PizzaDaoList implements IPizzaDao {

	/** arrayListPizzas */
	private static ArrayList<Pizza> arrayListPizzas = new ArrayList<Pizza>();
	
	/*
	 * Définition des pizzas !
	 */
	static {
		arrayListPizzas.add(new Pizza("PEP", "Pépéroni", 12.50));
		arrayListPizzas.add(new Pizza("MAR", "Margherita", 14.00));
		arrayListPizzas.add(new Pizza("REIN", "La Reine", 11.50));
		arrayListPizzas.add(new Pizza("FRO", "La 4 fromages", 12.00));
		arrayListPizzas.add(new Pizza("CAN", "La cannibale", 12.50));
		arrayListPizzas.add(new Pizza("SAV", "La savoyarde", 13.00));
		arrayListPizzas.add(new Pizza("ORI", "L’orientale", 13.50));
		arrayListPizzas.add(new Pizza("IND", "L’indienne", 14.00));
	}
	
	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.iPizzaDao#findAllPizzas()
	 */
	@Override
	public Pizza[] findAllPizzas() {
		Pizza[] tableauPizzas = new Pizza[arrayListPizzas.size()];
		return arrayListPizzas.toArray(tableauPizzas);
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.iPizzaDao#saveNewPizza(fr.pizzeria.model.Pizza)
	 */
	@Override
	public boolean saveNewPizza(Pizza pizza) {
		if(arrayListPizzas.add(new Pizza(pizza.getCode(), pizza.getNom(), pizza.getPrix()))) {
			return true;
		} else {
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.iPizzaDao#updatePizza(java.lang.String, fr.pizzeria.model.Pizza)
	 */
	@Override
	public boolean updatePizza(String codePizza, Pizza nouvellePizza) {
		for (Pizza pizza: arrayListPizzas) { // on parcourt le tableau de pizzas
			if(pizza != null) {
				if (pizza.getCode().equals(codePizza)) { // Si on trouve la pizza correspondant au code
					pizza.setCode(nouvellePizza.getCode());
					pizza.setNom(nouvellePizza.getNom());
					pizza.setPrix(nouvellePizza.getPrix());
					
					return true;
				}
			}
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.iPizzaDao#getPizzaByCode(java.lang.String)
	 */
	@Override
	public Pizza getPizzaByCode(String codePizza) {
		for (Pizza pizza: arrayListPizzas) { // on parcourt le tableau de pizzas
			if(pizza != null) {
				if (pizza.getCode().equals(codePizza)) { // Si on trouve la pizza correspondant au code
					return pizza; // on retourne la pizza
				}
			}
		}
		return null; // Si aucune pizza ne correspond au code de la pizza, on retourne null
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.iPizzaDao#deletePizza(java.lang.String)
	 */
	@Override
	public boolean deletePizza(String codePizza) {
		for (Pizza pizza: arrayListPizzas) { // on parcourt le tableau de pizzas
			if(pizza != null) {
				if (pizza.getCode().equals(codePizza)) { // Si on trouve la pizza correspondant au code
					arrayListPizzas.remove(pizza);
					return true;
				}
			}
		}
		return false;
	}

}
