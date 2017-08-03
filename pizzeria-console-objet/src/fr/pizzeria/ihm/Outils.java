/**
 * 
 */
package fr.pizzeria.ihm;

/**
 * @author keylan Outils : methodes outils
 */
public class Outils {

	public static final String regexScanNombre = "[0-9]*";
	public static final String regexScanDecimal = "[0-9]+(.[0-9]*)";

	protected static boolean verifierPrix(String prix) {
		if (!prix.matches(regexScanDecimal)) {
			if (!prix.matches(regexScanNombre)) {
				return false;
			} else {
				return true;
			}
		} else {
			return true;
		}

	}
	
}
