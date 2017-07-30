package fr.pizzeria.console;

import java.util.Scanner;
import fr.pizzeria.model.Pizza;

/**
 * 
 * @author AhmetCelikbas
 * @version 1.0
 */
public class PizzeriaAdminConsoleApp {

	/*
	 * Constantes
	 */
	public static final String regexScanNombre = "[0-9]*";
	public static final String regexScanDecimal = "[0-9]+(.[0-9]*)";
	
	/*
	 * Déclarations
	 */
	private static Scanner scan;
	
	
	/*
	 * Variables
	 */
	private static int menuChoisi = 0;
	private static String buffer;
	private static Pizza[] tableauPizzas = new Pizza[8];
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Instanciations
		 */
		scan = new Scanner(System.in);			// Instancie la classe Scanner pour capturer les informations renseignées par le clavier.
		/*
		 * Pizzas
		 */
		tableauPizzas[0] = new Pizza("PEP", "Pépéroni", 12.50);
		tableauPizzas[1] = new Pizza("MAR", "Margherita", 14.00);
//		tableauPizzas[2] = new Pizza("REIN", "La Reine", 11.50);
		tableauPizzas[2] = null;
		tableauPizzas[3] = new Pizza("FRO", "La 4 fromages", 12.00);
		tableauPizzas[4] = new Pizza("CAN", "La cannibale", 12.50);
		tableauPizzas[5] = new Pizza("SAV", "La savoyarde", 13.00);
		tableauPizzas[6] = new Pizza("ORI", "L’orientale", 13.50);
		tableauPizzas[7] = new Pizza("IND", "L’indienne", 14.00);
		
	
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
			
			
			/*
			 * Choisir le code à exécuter en fonction du menu choisi
			 */
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
		if(!buffer.matches(regexScanNombre)) {
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
		/*
		 * Parcourt le tableau des pizzas (tableauPizzas) et affiche le code, le nom et le prix
		 */
		for (int i = 0; i < tableauPizzas.length; i++) {
			/*
			 * On vérifie si la pizza existe
			 */
			if(tableauPizzas[i] == null) {
				System.out.println("n°" + (i+1) + " : Emplacement vide (pizza supprimée)");
			} else {
				System.out.println("n°" + (i+1) + " : " + tableauPizzas[i].getCode() + " -> " + tableauPizzas[i].getNom() + " (" + tableauPizzas[i].getPrix() + " €)");
			}
		}
	}
	
	/**
	 * Ajoute une nouvelle pizza
	 */
	private static void ajouterNouvellePizza() {
		
		String codeRenseigne;		// code de la nouvelle pizza
		String nomRenseigne;			// nom de la nouvelle pizza
		String prixRenseigne;		// prix de la novuelle pizza
		
		System.out.println("Ajout d’une nouvelle pizza");
		
		/*
		 * Demande du code
		 */
		System.out.print("Veuillez saisir le code : ");
		codeRenseigne = scan.next();
		
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
		prixRenseigne = prixRenseigne.replace(',', '.');		// Remplacer la virgule par un point si il en à une
		
		/*
		 * Verifier le prix
		 */
		while(!verifierPrix(prixRenseigne)) {
			System.out.println("Saisie incorrecte.");
			System.out.print("Veuillez saisir le prix à nouveau : ");
			prixRenseigne = scan.next();
		}
		
		/*
		 * Parcourir le tableau des pizzas pour chercher un emplacement libre
		 */
		boolean pizzaAjoutee = false;
		for (int i = 0; i < tableauPizzas.length; i++) {
			/*
			 * Si on trouve un emplacement libre dans le tableau, on ajoute la pizza dans cet emplacement
			 */
			if(tableauPizzas[i] == null && pizzaAjoutee == false) {
				tableauPizzas[i] = new Pizza(codeRenseigne, nomRenseigne, Double.parseDouble(prixRenseigne)); 		// Ajouter la nouvelle pizza	
				pizzaAjoutee = true;
				break;
			}
		}

		
		/*
		 * Si aucun emplacement libre n'a été trouvé, on ajoute la nouvelle pizza à la fin du tableau
		 */
		if(!pizzaAjoutee) {
			
			System.out.println("AJOUT PIZZA FIN TABLEAU");
			/*
			 * Agrandir le tableau des pizzas
			 */
			Pizza[] BufferTableauPizzas = new Pizza[tableauPizzas.length + 1];		// Créer un nouveau tableau avec une taille plus grande
			System.arraycopy(tableauPizzas, 0, BufferTableauPizzas, 0, tableauPizzas.length);		// Copier le tableau des pizzas dans le nouveau tableau de taille plus grande
			BufferTableauPizzas[tableauPizzas.length] = new Pizza(codeRenseigne, nomRenseigne, Double.parseDouble(prixRenseigne));		// Ajouter la nouvelle pizza à la fin du nouveau tableau
			tableauPizzas = BufferTableauPizzas;		// Redéfinir la référence du tableau des pizzas
		}
		/*
		 * On fini en beauté !
		 */
		System.out.println("Pizza ajoutée");		
	}
	
	/**
	 * Vérifie que le prix renseigné un nombre ou une décimale
	 * @param prix
	 * @return boolean
	 */
	private static boolean verifierPrix(String prix) {
		if(!prix.matches(regexScanDecimal)) {
			if(!prix.matches(regexScanNombre)) {
				return false;
			} else {
				return true;
			}
		} else {
			return true;
		}
		
	}
	
	
	/**
	 * Met à jour une pizza
	 */
	private static void mettreAJourPizza() {

	}
	
	
	/**
	 * Supprime une pizza
	 */
	private static void supprimerPizza() {
		System.out.println("Suppression d’une pizza");
	}
	
	
}
