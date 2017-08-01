/**
 * 
 */
package fr.pizzeria.console;

/**
 * @author keylan
 * Outils : methodes outils
 */
public class Outils {

	public static final String regexScanNombre = "[0-9]*";
	public static final String regexScanDecimal = "[0-9]+(.[0-9]*)";
	
	protected static boolean verifierPrix(String prix) {
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
	 * Vérifie que le menu entré par l'utilisateur est conforme.
	 * @return
	 */
	protected static boolean verifierMenuChoisi(String buffer) {
		
		/*
		 * Si l'utilisateur entre autre chose que des chiffres/nombres
		 */
		if(!buffer.matches(regexScanNombre)) {
			return false;
		}
		
		/*
		 * Si le numéro du menu choisi n'existe pas.
		 */
		if((Integer.parseInt(buffer) < 1) || (Integer.parseInt(buffer) > 4 && Integer.parseInt(buffer) < 99) || Integer.parseInt(buffer) > 99) {
			return false;
		}
		
		return true; // L'utilisateur à choisi un menu existant.
	}
	
}
