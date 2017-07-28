package fr.pizzeria.console;

import java.util.Scanner;

/**
 * 
 * @author AhmetCelikbas
 * @version 1.0
 */
public class PizzeriaAdminConsoleApp {

	/*
	 * Constantes
	 */
	public static final String regexScan = "[0-9]*";
	
	/*
	 * Déclarations
	 */
	private static Scanner scan;
	
	
	/*
	 * Variables
	 */
	private static int menuChoisi = 0;
	private static String buffer;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Instanciations
		 */
		scan = new Scanner(System.in);			// Instancie la classe Scanner pour capturer les informations renseignées par le clavier.
		
		
	
		while(true) {
			/*
			 * Menu principal
			 */
			afficherMenuPrincipal();
			System.out.print("Choisir un menu : ");
			buffer = scan.next();		// Attente du choix du menu par l'utilisateur
			
			/*
			 * On vérifie que l'utilisateur a choisi un menu qui existe
			 */
			while(!verifierMenuChoisi()) {
				System.out.println("Menu non reconnu.");
				System.out.print("Choisir un menu : ");
				buffer = scan.next();		// On redemande à l'utilisateur de choisir un menu si son précédent choix n'a pas été reconnu
			}
						
			/*
			 * Si l'utilisateur souhaite sortir
			 */
			if(menuChoisi == 99) {
				scan.close(); // Fermer le scanner
				System.out.println("Aurevoir :(");
				return;
			}
	
			System.out.print("\n\n");
			
			switch(menuChoisi) {
			case 1:
				listerLesPizzas();
				break;
			case 2:
				ajouterNouvellePizza();
				break;
			case 3:
				mettreAJourPizza();
				break;
			case 4:
				supprimerPizza();
				break;
			default:
		
				break;
			}
			
			System.out.print("\n\n");
			
		}
	}
	
	/**
	 * Vérifie que le menu entré par l'utilisateur est conforme.
	 * @return
	 */
	private static boolean verifierMenuChoisi() {
		/*
		 * Si l'utilisateur entre autre chose que des chiffres/nombres
		 */
		if(!buffer.matches(regexScan)) {
			return false;
		}
		
		menuChoisi = Integer.parseInt(buffer); 		// Conversion du menu en entier.
		/*
		 * Si le numéro du menu choisi n'existe pas.
		 */
		if((menuChoisi < 1) || (menuChoisi > 4 && menuChoisi < 99) || menuChoisi > 99) {
			return false;
		}
		
		return true; // L'utilisateur à choisi un menu existant.
	}
	
	
	/**
	 * Affiche le menu
	 */
	private static void afficherMenuPrincipal() {
		System.out.println("***** Pizzeria Administration *****");
		System.out.println("  1. Lister les pizzas");
		System.out.println("  2. Ajouter une nouvelle pizza");
		System.out.println("  3. Mettre à jour une pizza");
		System.out.println("  4. Supprimer une pizza");
		System.out.println("  99. Sortir");
		System.out.println();
		
	}
	
	
	/**
	 * Liste les pizzas
	 */
	private static void listerLesPizzas() {
		System.out.println("Liste des pizzas");
	}

	/**
	 * Ajoute une nouvelle pizza
	 */
	private static void ajouterNouvellePizza() {
		System.out.println("Ajout d’une nouvelle pizza");
	}
	
	/**
	 * Met à jour une pizza
	 */
	private static void mettreAJourPizza() {
		System.out.println("Mise à jour d’une pizza");
	}
	
	
	/**
	 * Supprime une pizza
	 */
	private static void supprimerPizza() {
		System.out.println("Suppression d’une pizza");
	}
	
	
}
