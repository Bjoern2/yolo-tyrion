/*
 * Copyright 2013 Björn Schmitz
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 		http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
