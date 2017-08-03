package fr.pizzeria.ihm;

import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;

import fr.pizzeria.dao.IPizzaDao;

public class Menu {

	private IPizzaDao dao;
	private Scanner scan;
	protected OptionMenu[] actions = new OptionMenu[4];

	protected Menu(IPizzaDao dao, Scanner scan) {
		this.dao = dao;
		this.scan = scan;

		actions[0] = new ListerLesPizzasOptionMenu(this.dao, this.scan);
		actions[1] = new NouvellePizzaOptionMenu(this.dao, this.scan);
		actions[2] = new ModifierPizzaOptionMenu(this.dao, this.scan);
		actions[3] = new SupprimerPizzaOptionMenu(this.dao, this.scan);
	}

	/**
	 * Method Affiche le menu principal
	 */
	protected void afficher() {
		System.out.println("***** Pizzeria Administration *****");

		for (int i = 0; i < actions.length; i++) {
			System.out.println("  " + (i + 1) + ". " + actions[i].getLibelle());
		}

		System.out.println("  99. Sortir");
		System.out.println();
	}

	/**
	 * Vérifie que le menu choisi par l'utilisateur est conforme.
	 * 
	 * @return
	 */
	protected boolean verifierMenuChoisi(String buffer) {

		/*
		 * Si l'utilisateur entre autre chose que des chiffres/nombres
		 */
		if (!NumberUtils.isCreatable(buffer)) {
			return false;
		}
		
		/*
		 * Si le numéro du menu choisi n'existe pas.
		 */
		if ((NumberUtils.createInteger(buffer) < 1) || (NumberUtils.createInteger(buffer) > actions.length && NumberUtils.createInteger(buffer) < 99)
				|| NumberUtils.createInteger(buffer) > 99) {
			return false;
		}

		return true; // L'utilisateur à choisi un menu existant.
	}

}
