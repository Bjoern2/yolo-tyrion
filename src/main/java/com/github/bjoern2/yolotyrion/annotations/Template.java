package com.github.bjoern2.yolotyrion.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.github.bjoern2.yolotyrion.generator.Generator;
import com.github.bjoern2.yolotyrion.generator.NullGenerator;

/**
 * Declare a method with {@link Template} if the method should return the content of a resource/template file.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Template {

	/**
	 * The filename of your template. <br/>
	 * I search the file in the same package as your interface.
	 * @return Filename without a path
	 */
	String filename();
	
	/**
	 * The generator you wish to use. If you don't use a generator use {@link NullGenerator}.
	 * @return Your generator class or {@link NullGenerator}
	 */
	Class<? extends Generator> generator() default NullGenerator.class;
	
}
