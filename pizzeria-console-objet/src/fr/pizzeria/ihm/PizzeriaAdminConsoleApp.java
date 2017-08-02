package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoList;
import fr.pizzeria.dao.PizzaDaoTableau;
import fr.pizzeria.dao.iPizzaDao;

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
	private static Scanner scan;
	/** buffer */
	private static String buffer;
	/** menu */
	private static Menu menu;
	/** dao */
	private static iPizzaDao dao;
	/** listerLesPizzas */
	private static ListerLesPizzasOptionMenu listerLesPizzas;
	/** nouvellePizzaOptionMenu */
	private static NouvellePizzaOptionMenu nouvellePizzaOptionMenu;
	/** modifierPizzaOptionMenu */
	private static ModifierPizzaOptionMenu modifierPizzaOptionMenu;
	/** supprimerPizzaOptionMenu */
	private static SupprimerPizzaOptionMenu supprimerPizzaOptionMenu;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Instanciations
		 */
		scan = new Scanner(System.in); // Instancie la classe Scanner pour capturer les informations renseignées par le
										// clavier.
		menu = new Menu();
		// dao = new PizzaDaoTableau();
		dao = new PizzaDaoList();
		listerLesPizzas = new ListerLesPizzasOptionMenu(dao);
		nouvellePizzaOptionMenu = new NouvellePizzaOptionMenu(dao);
		modifierPizzaOptionMenu = new ModifierPizzaOptionMenu(dao);
		supprimerPizzaOptionMenu = new SupprimerPizzaOptionMenu(dao);

		while (true) {
			/*
			 * Menu principal
			 */
			menu.afficherMenuPrincipal();
			System.out.print("Choisir un menu : ");
			buffer = scan.next(); // Attente du choix du menu par l'utilisateur

			/*
			 * On vérifie que l'utilisateur a choisi un menu qui existe
			 */
			while (!Outils.verifierMenuChoisi(buffer)) {
				System.out.println("Menu non reconnu.");
				System.out.print("Choisir un menu : ");
				buffer = scan.next(); // On redemande à l'utilisateur de choisir un menu si son précédent choix n'a
										// pas été reconnu
			}

			/*
			 * Si l'utilisateur souhaite sortir
			 */
			if (Integer.parseInt(buffer) == 99) {
				scan.close(); // Fermer le scanner
				System.out.println("Aurevoir :(");
				return;
			}

			System.out.print("\n\n");

			/*
			 * Choisir le code à exécuter en fonction du menu choisi
			 */
			switch (Integer.parseInt(buffer)) {
			case 1:
				listerLesPizzas.execute();
				break;
			case 2:
				nouvellePizzaOptionMenu.execute();
				break;
			case 3:
				modifierPizzaOptionMenu.execute();
				break;
			case 4:
				supprimerPizzaOptionMenu.execute();
				break;
			default:
				break;
			}

			System.out.print("\n\n");

		}
	}
}
