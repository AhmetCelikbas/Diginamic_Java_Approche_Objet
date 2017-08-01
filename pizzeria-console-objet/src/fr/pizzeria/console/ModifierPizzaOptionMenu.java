/**
 * 
 */
package fr.pizzeria.console;

import java.util.Scanner;
import fr.pizzeria.dao.iPizzaDao;
import fr.pizzeria.model.Pizza;

/**
 * @author keylan ModifierPizzaOptionMenu : mettre a jour une pizza
 */
class ModifierPizzaOptionMenu extends OptionMenu {

	/** dao */
	private iPizzaDao dao;
	/** listerLesPizzasOptionMenu */
	private ListerLesPizzasOptionMenu listerLesPizzasOptionMenu;

	/** scan */
	private Scanner scan;

	/**
	 * @param dao
	 */
	public ModifierPizzaOptionMenu(iPizzaDao dao) {
		this.dao = dao;
		listerLesPizzasOptionMenu = new ListerLesPizzasOptionMenu(this.dao);
		this.scan = new Scanner(System.in);
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.console.OptionMenu#execute()
	 */
	protected boolean execute() {
		String buffer = "";
		listerLesPizzasOptionMenu.execute();

		/*
		 * On vérifie que l'utilisateur choisi une pizza qui existe
		 */
		Pizza pizzaAMettreAJour;
		while ((pizzaAMettreAJour = dao.getPizzaByCode(buffer.trim().toUpperCase())) == null) {

			if (buffer.equals("99")) {
				return true;
			}

			System.out.print("Merci d'entrer un code pizza valide ou de saisir le 99 pour abandonner : ");
			buffer = scan.next();
		}

		String nouveauCode; // code de la nouvelle pizza
		String nouveauNom; // nom de la nouvelle pizza
		String nouveauPrix; // prix de la novuelle pizza

		/*
		 * Demande du code
		 */
		System.out.print("Veuillez saisir le nouveau code : ");
		nouveauCode = scan.next();

		/*
		 * Demande du nom
		 */
		System.out.print("Veuillez saisir le nom : ");
		nouveauNom = scan.next();

		/*
		 * Demande du prix
		 */
		System.out.print("Veuillez saisir le prix : ");
		nouveauPrix = scan.next();
		nouveauPrix = nouveauPrix.replace(',', '.'); // Remplacer la virgule par un point si il en à une

		/*
		 * Verifier le prix
		 */
		while (!Outils.verifierPrix(nouveauPrix)) {
			System.out.println("Saisie incorrecte.");
			System.out.print("Veuillez saisir le prix à nouveau : ");
			nouveauPrix = scan.next();
		}

		Pizza nouvellePizza = new Pizza(nouveauCode, nouveauNom, Double.parseDouble(nouveauPrix));

		System.out.println("Ancienne pizza : " + pizzaAMettreAJour.getCode() + " -> " + pizzaAMettreAJour.getNom()
				+ " (" + pizzaAMettreAJour.getPrix() + " €)");
		System.out.println("Nouvelle pizza : " + nouvellePizza.getCode() + " -> " + nouvellePizza.getNom() + " ("
				+ nouvellePizza.getPrix() + " €)");

		System.out.print("Confirmer la mise à jour ? (o/n) : ");
		if (scan.next().equals("o")) {
			if (dao.updatePizza(pizzaAMettreAJour.getCode(), nouvellePizza)) {
				System.out.println("Pizza mis à jour.");
			} else {
				System.out.println("Pizza non mis à jour.");
			}
		} else {
			System.out.println("Pizza non mis à jour.");
		}
		return true;
	}

	@Override
	String getLibelle() {
		// TODO Auto-generated method stub
		return "Modifier Pizza";
	}
}
