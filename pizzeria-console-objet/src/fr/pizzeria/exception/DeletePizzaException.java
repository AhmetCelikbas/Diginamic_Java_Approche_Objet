/**
 * 
 */
package fr.pizzeria.exception;

/**
 * @author keylan
 *
 */
public class DeletePizzaException extends StockageException {

	/** serialVersionUID */
	private static final long serialVersionUID = 2769821308584269270L;

	
	public static final String EXCEP_PIZZA_NON_SUPPRIMEE = "Pizza non supprimée";
	
	/**
	 * Ctor
	 * 
	 * @param msg
	 */
	public DeletePizzaException(String msg) {
		super(msg);
	}
}
