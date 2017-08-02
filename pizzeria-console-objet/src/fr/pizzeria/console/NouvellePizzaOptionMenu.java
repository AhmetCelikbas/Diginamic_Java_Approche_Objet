/**
 * 
 */
package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.iPizzaDao;
import fr.pizzeria.model.Pizza;

/**
 * @author keylan NouvellePizzaOptionMenu : Créé une nouvelle pizza
 */
class NouvellePizzaOptionMenu extends OptionMenu {

	/** dao */
	private iPizzaDao dao;
	/** scan */
	private Scanner scan;

	/**
	 * Constructor
	 */
	public NouvellePizzaOptionMenu(iPizzaDao dao) {
		this.dao = dao;
		this.scan = new Scanner(System.in);
	}

	/**
	 * Method
	 * @return 
	 * 
	 */
	protected boolean execute() {
		String codeRenseigne;
		String nomRenseigne;
		String prixRenseigne;

		System.out.println("Ajout d’une nouvelle pizza");

		/*
		 * Demande du code
		 */
		System.out.print("Veuillez saisir le code : ");
		codeRenseigne = scan.next();

		while (dao.getPizzaByCode(codeRenseigne.trim().toUpperCase()) != null) {
			System.out.println("Code déjà utilisé par une Pizza.");
			System.out.print("Veuillez saisir un autre code : ");
			codeRenseigne = scan.next();
		}

		/*
		 * Demande du nom
		 */
		System.out.print("Veuillez saisir le nom (sans espace) : ");
		nomRenseigne = scan.next();

		/*
		 * Demande du prix
		 */
		System.out.print("Veuillez saisir le prix : ");
		prixRenseigne = scan.next();
		prixRenseigne = prixRenseigne.replace(',', '.'); // Remplacer la virgule par un point si il en à une

		/*
		 * Verifier le prix
		 */
		while (!Outils.verifierPrix(prixRenseigne)) {
			System.out.println("Saisie incorrecte.");
			System.out.print("Veuillez saisir le prix à nouveau : ");
			prixRenseigne = scan.next();
		}

		/*
		 * Si l'ajout réussi
		 */
		if (dao.saveNewPizza(new Pizza(codeRenseigne, nomRenseigne, Double.parseDouble(prixRenseigne)))) {
			/*
			 * On fini en beauté !
			 */
			System.out.println("Pizza ajoutée");
		} else {
			/*
			 * On fini en beauté !
			 */
			System.out.println("Pizza non ajoutée :( !!!");
		}
		return true;
	}

	@Override
	String getLibelle() {
		// TODO Auto-generated method stub
		return "Ajouter une nouvelle pizza";
	}
}
