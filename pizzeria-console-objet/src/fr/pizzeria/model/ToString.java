/**
 * 
 */
package fr.pizzeria.model;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
/**
 * @author keylan
 *
 */
public @interface ToString {
	/** Method
	 * @return
	 */
	boolean uppercase() default false;
}
