/**
 * 
 */
package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.iPizzaDao;
import fr.pizzeria.model.Pizza;

/**
 * @author keylan
 *
 */
public class SupprimerPizzaOptionMenu extends OptionMenu {

	/** dao */
	private iPizzaDao dao;
	/** listerLesPizzas */
	private ListerLesPizzasOptionMenu listerLesPizzas;

	/** scan */
	private Scanner scan;

	/**
	 * @param dao
	 */
	public SupprimerPizzaOptionMenu(iPizzaDao dao) {
		this.dao = dao;
		this.listerLesPizzas = new ListerLesPizzasOptionMenu(this.dao);
		this.scan = new Scanner(System.in);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.console.OptionMenu#execute()
	 */
	public boolean execute() {
		String buffer = "";
		System.out.println("Supprimer une pizza");
		listerLesPizzas.execute();

		/*
		 * On vérifie que l'utilisateur choisi une pizza qui existe
		 */
		Pizza pizzaASupprimer;
		while ((pizzaASupprimer = dao.getPizzaByCode(buffer.trim().toUpperCase())) == null) {

			if (buffer.equals("99")) {
				return true;
			}

			System.out.print("Merci d'entrer un code pizza valide ou de saisir le 99 pour abandonner : ");
			buffer = scan.next();
		}

		System.out.println("Supprimer la pizza : " + pizzaASupprimer.getCode() + " -> " + pizzaASupprimer.getNom()
				+ " (" + pizzaASupprimer.getPrix() + " €)");

		System.out.print("Confirmer la suppression ? (o/n) : ");
		if (scan.next().equals("o")) {
			if (dao.deletePizza(pizzaASupprimer.getCode())) {
				System.out.println("Pizza supprimée");
			} else {
				System.out.println("Pizza non supprimée");
			}
		} else {
			System.out.println("Pizza non supprimée");
		}
		return true;
	}

	@Override
	String getLibelle() {
		// TODO Auto-generated method stub
		return "Supprimer une pizza";
	}

}
