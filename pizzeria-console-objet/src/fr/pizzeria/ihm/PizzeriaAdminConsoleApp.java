package fr.pizzeria.ihm;

import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;

import fr.pizzeria.dao.PizzaDaoList;
import fr.pizzeria.dao.PizzaDaoTableau;
import fr.pizzeria.dao.IPizzaDao;

/**
 * 
 * @author AhmetCelikbas
 * @version 1.0
 */
public class PizzeriaAdminConsoleApp extends Outils {

	/*
	 * Variables
	 */
	/** scan */
	private static Scanner scan = new Scanner(System.in);
	/** buffer */
	private static String buffer = "0";
	/** dao */
	private static IPizzaDao dao = new PizzaDaoList();
	/** menu */
	private static Menu menu = new Menu(dao, scan);

	/**
	 * Point d'entrée de l'application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * On boucle tant que l'utilisateur ne souhaite pas quitter (99) ou que le menu
		 * choisi par l'utilisateur n'est pas reconnu
		 */
		while ((NumberUtils.createInteger(buffer) != 99) || (!menu.verifierMenuChoisi(buffer))) {
			menu.afficher(); // Menu principal
			System.out.print("Choisir un menu : ");
			buffer = scan.next(); // On demande à l'utilisateur de choisir un menu

			/*
			 * On vérifie que l'utilisateur a choisi un menu qui existe
			 */
			while (!menu.verifierMenuChoisi(buffer)) {
				if (!NumberUtils.isCreatable(buffer)) {
					System.out.println("Menu non reconnu.");
				}

				System.out.print("Choisir un menu : ");
				buffer = scan.next(); // On redemande à l'utilisateur de choisir un menu si son précédent choix n'a
										// pas été reconnu
			}

			/*
			 * Si l'utilisateur ne souhaite pas quitter, on exécute l'action correspondant
			 * au menu choisi
			 */
			if (NumberUtils.createInteger(buffer) != 99) {
				System.out.print("\n\n");
				menu.actions[Integer.parseInt(buffer) - 1].execute(); // décalage de 1 en moins pour correspondre au
																		// tableau
				System.out.print("\n\n");
			}

		}
		scan.close(); // Fermer le scanner
		System.out.println("Aurevoir :(");
	}
}
