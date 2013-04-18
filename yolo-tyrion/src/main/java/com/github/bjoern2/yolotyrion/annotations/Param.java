package com.github.bjoern2.yolotyrion.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Name of a parameter. Use this annotation in your parameter declaration of a method which is declared with {@link Template}.
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface Param {

	/**
	 * Your name for this parameter.
	 * @return Name of parameter.
	 */
	String value();
	
}
