/**
 * 
 */
package fr.pizzeria.exception;

/**
 * @author keylan
 *
 */
public class SavePizzaException extends Exception {

	/** serialVersionUID */
	private static final long serialVersionUID = -7742084499561652364L;
	
	public static final String 
			EXCEP_TAILLE_CODE_PIZZA = "Code pizza trop court ou trop long. (Min. 3 caractères, Max. 4 caractères).",
			EXCEP__PRIX_INCORRECT = "Prix incorect";

	/**
	 * Ctor
	 * 
	 * @param msg
	 */
	public SavePizzaException(String msg) {
		super(msg);
	}

}
