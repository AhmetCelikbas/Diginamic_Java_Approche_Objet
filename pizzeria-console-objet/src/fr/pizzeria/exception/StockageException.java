/**
 * 
 */
package fr.pizzeria.exception;

/**
 * @author keylan
 *
 */
public class StockageException extends Exception {

	/** serialVersionUID */
	private static final long serialVersionUID = -1030966979133115038L;
	
	
	/* Messages d'exception */
	/** EXCEP_TAILLE_CODE_PIZZA */
	public static final String EXCEP_TAILLE_CODE_PIZZA = "Code pizza trop court ou trop long. (Min. 3 caractères, Max. 4 caractères).";
	/** EXCEP_PRIX_INCORRECT */
	public static final String EXCEP_PRIX_INCORRECT = "Prix incorect";
	
	/**
	 * Ctor
	 * 
	 * @param msg
	 */
	public StockageException(String msg) {
		super(msg);
	}
}
