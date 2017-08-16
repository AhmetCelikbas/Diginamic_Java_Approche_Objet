package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;

public abstract class OptionMenu {

	/** scan */
	protected Scanner scan;
	/** dao */
	protected IPizzaDao dao;

	/**
	 * Ctor
	 * 
	 * @param dao
	 * @param scan
	 */
	public OptionMenu(IPizzaDao dao, Scanner scan) {
		this.dao = dao;
		this.scan = scan;
	}

	/**
	 * Method
	 * 
	 * @return String
	 */
	abstract String getLibelle();

	/**
	 * Method
	 * 
	 * @return boolean
	 * @throws SavePizzaException 
	 */
	abstract boolean execute() throws SavePizzaException, UpdatePizzaException, DeletePizzaException;

}
