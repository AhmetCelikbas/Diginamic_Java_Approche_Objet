package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

/**
 * @author keylan Interface pizza DAO
 */
public interface IPizzaDao {

	/**
	 * Method créé un tableau de pizzas
	 * 
	 * @return Pizza[] tableauPizzas
	 */
	Pizza[] findAllPizzas();

	/**
	 * Method Créé/Ajoute une nouvelle pizza
	 * 
	 * @param pizza
	 * @return boolean
	 */
	boolean saveNewPizza(Pizza pizza);

	/**
	 * Method Met à jour une pizza
	 * 
	 * @param codePizza
	 * @param pizza
	 * @return
	 */
	boolean updatePizza(String codePizza, Pizza pizza);

	/**
	 * Method Retourne les informations de la pizza correspondant au code fourni
	 * 
	 * @param codePizza
	 * @return Pizza
	 */
	Pizza getPizzaByCode(String codePizza);

	/**
	 * Method Supprime une pizza
	 * 
	 * @param codePizza
	 * @return
	 */
	boolean deletePizza(String codePizza);
}
