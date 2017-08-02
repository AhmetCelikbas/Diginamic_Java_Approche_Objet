/**
 * 
 */
package fr.pizzeria.ihm;

import fr.pizzeria.dao.IPizzaDao;

/**
 * @author keylan ListerLesPizzas : Affiche la liste des pizzas
 */
class ListerLesPizzasOptionMenu extends OptionMenu {

	/** dao */
	IPizzaDao dao;

	/**
	 * Constructor
	 */
	public ListerLesPizzasOptionMenu(IPizzaDao dao) {
		this.dao = dao;
	}

	/**
	 * Method Affiche la liste des pizzas
	 * 
	 * @return
	 */
	protected boolean execute() {
		System.out.println("Liste des pizzas");
		for (int i = 0; i < dao.findAllPizzas().length; i++) { // Parcourt le tableau des pizzas (tableauPizzas) et
																// affiche le code, le nom et le prix
			if (dao.findAllPizzas()[i] == null) { // On vérifie si la pizza existe
				System.out.println("n°" + (i + 1) + " : Emplacement vide (pizza supprimée)");
			} else { // Si elle existe
				System.out.println("n°" + (i + 1) + " : " + dao.findAllPizzas()[i].getCode() + " -> "
						+ dao.findAllPizzas()[i].getNom() + " (" + dao.findAllPizzas()[i].getPrix() + " €)");
			}
		}
		return true;
	}

	@Override
	String getLibelle() {
		// TODO Auto-generated method stub
		return "Lister les pizzas";
	}
}
