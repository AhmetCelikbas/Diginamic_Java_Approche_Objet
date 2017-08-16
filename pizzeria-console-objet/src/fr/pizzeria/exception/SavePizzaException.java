/**
 * 
 */
package fr.pizzeria.exception;

/**
 * @author keylan
 *
 */
public class SavePizzaException extends StockageException {

	/** serialVersionUID */
	private static final long serialVersionUID = -7742084499561652364L;
	
	
	public static final String EXCEP_PIZZA_NON_AJOUTEE = "Pizza non ajoutée :( !!!";
	
	/**
	 * Ctor
	 * 
	 * @param msg
	 */
	public SavePizzaException(String msg) {
		super(msg);
	}

}
