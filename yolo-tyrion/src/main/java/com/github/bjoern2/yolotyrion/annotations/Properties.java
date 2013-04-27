package com.github.bjoern2.yolotyrion.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Properties {
	
	/**
	 * The filename of your resource file. <br/>
	 * I search the file in the same package as your interface.
	 * @return Filename without a path
	 */
	String filename();
	
}
