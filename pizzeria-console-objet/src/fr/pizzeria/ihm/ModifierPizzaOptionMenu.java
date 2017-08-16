/**
 * 
 */
package fr.pizzeria.ihm;

import java.util.Scanner;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

/**
 * @author keylan ModifierPizzaOptionMenu : mettre a jour une pizza
 */
class ModifierPizzaOptionMenu extends OptionMenu {
	
	/** listerLesPizzasOptionMenu */
	private ListerLesPizzasOptionMenu listerLesPizzasOptionMenu;

	/**
	 * @param dao
	 */
	public ModifierPizzaOptionMenu(IPizzaDao dao, Scanner scan) {
		super(dao, scan);
		listerLesPizzasOptionMenu = new ListerLesPizzasOptionMenu(dao, scan);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.console.OptionMenu#execute()
	 */
	protected boolean execute() throws UpdatePizzaException {
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

		
		if ((nouveauCode.trim().length() < 3) || (nouveauCode.trim().length() > 4) ) {
			throw new UpdatePizzaException(UpdatePizzaException.EXCEP_TAILLE_CODE_PIZZA); 
		}
		
		
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
				throw new UpdatePizzaException(UpdatePizzaException.EXCEP_PIZZA_NON_MIS_A_JOUR);
			}
		} else {
			throw new UpdatePizzaException(UpdatePizzaException.EXCEP_PIZZA_NON_MIS_A_JOUR);
		}
		return true;
	}

	@Override
	String getLibelle() {
		// TODO Auto-generated method stub
		return "Modifier Pizza";
	}
}
