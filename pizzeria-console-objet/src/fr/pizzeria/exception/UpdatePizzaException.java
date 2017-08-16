/**
 * 
 */
package fr.pizzeria.exception;

/**
 * @author keylan
 *
 */
public class UpdatePizzaException extends StockageException {

	/** serialVersionUID */
	private static final long serialVersionUID = -5682149591857278420L;

	
	public static final String EXCEP_PIZZA_NON_MIS_A_JOUR = "Pizza non mis à jour.";
	
	/**
	 * Ctor
	 * 
	 * @param msg
	 */
	public UpdatePizzaException(String msg) {
		super(msg);
	}
}
