/**
 * 
 */
package fr.pizzeria.ihm;

import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.Pizza;

/**
 * @author keylan NouvellePizzaOptionMenu : Créé une nouvelle pizza
 */
class NouvellePizzaOptionMenu extends OptionMenu {

	/**
	 * Constructor
	 */
	public NouvellePizzaOptionMenu(IPizzaDao dao, Scanner scan) {
		super(dao, scan);
	}

	/**
	 * Method
	 * 
	 * @return
	 * 
	 */
	protected boolean execute() throws SavePizzaException {
		String codeRenseigne;
		String nomRenseigne;
		String prixRenseigne;

		System.out.println("Ajout d’une nouvelle pizza");

		/*
		 * Demande du code
		 */
		System.out.print("Veuillez saisir le code : ");
		codeRenseigne = scan.next();

		if ((codeRenseigne.trim().length() < 3) || (codeRenseigne.trim().length() > 4) ) {
			throw new SavePizzaException(SavePizzaException.EXCEP_TAILLE_CODE_PIZZA); 
		}
		while (dao.getPizzaByCode(codeRenseigne.trim().toUpperCase()) != null) {
			System.out.println("Code déjà utilisé par une Pizza.");
			System.out.print("Veuillez saisir un autre code : ");
			codeRenseigne = scan.next();
			if (codeRenseigne.trim().isEmpty()) {
				throw new SavePizzaException(SavePizzaException.EXCEP_TAILLE_CODE_PIZZA);
			}
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

		/*
		 * Verifier le prix
		 */
		while (!Outils.verifierPrix(prixRenseigne)) {
			System.out.println("Saisie incorrecte.");
			System.out.print("Veuillez saisir le prix à nouveau : ");
			prixRenseigne = scan.next();
		}

		/*
		 * On vérifie si le prix renseigné peut-être converti
		 */
		if (!NumberUtils.isCreatable(prixRenseigne)) {
			throw new SavePizzaException(SavePizzaException.EXCEP__PRIX_INCORRECT);
		}

		/*
		 * Si l'ajout réussi
		 */
		if (dao.saveNewPizza(new Pizza(codeRenseigne, nomRenseigne, NumberUtils.createDouble(prixRenseigne)))) {
			/*
			 * On fini en beauté !
			 */
			System.out.println("Pizza ajoutée");
		} else {
			throw new SavePizzaException("Pizza non ajoutée :( !!!");
		}
		return true;
	}

	@Override
	String getLibelle() {
		// TODO Auto-generated method stub
		return "Ajouter une nouvelle pizza";
	}
}
