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
package com.github.bjoern2.yolotyrion;

import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;

import com.github.bjoern2.yolotyrion.annotations.Param;
import com.github.bjoern2.yolotyrion.annotations.Template;
import com.github.bjoern2.yolotyrion.generator.Generator;
import com.github.bjoern2.yolotyrion.utils.IOUtils;

/**
 * I'm the implementation of a TemplateRepository interface.
 */
public class TemplateRepositoryInvocationHandler implements InvocationHandler {
	
	public TemplateRepositoryInvocationHandler() {
		super();
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// First: Find the template file:
		Template t = method.getAnnotation(Template.class);
		if (t == null) {
			throw new NoSuchFieldException("Cannot find the \"@Template\" annotation.");
		}
		
		final String filename = t.filename();
		final Class<? extends Generator> generatorClass = t.generator();
		
		// Try to find the template file:
		final InputStream in = proxy.getClass().getInterfaces()[0].getResourceAsStream(filename);
		if (in == null) {
			throw new MissingResourceException("Cannot find the template file \"" + filename + "\".", method.getClass().getName(), filename);
		}
		final String template = IOUtils.toString(in);

		// Collect params:
		final List<Object> paramsList = new ArrayList<Object>();
		final Map<String, Object> paramsMap = new HashMap<String, Object>();
		
		if ((args != null) && (args.length > 0)) {
			final Annotation[][] paramAnnotations = method.getParameterAnnotations();
			for (int i = 0; i < args.length; i++) {
				paramsList.add(args[i]);
				final Annotation[] argAnnotations = paramAnnotations[i];
				if (argAnnotations != null) {
					for (Annotation argAnnotation : argAnnotations) {
						if (argAnnotation instanceof Param) {
							final Param paramAnnotation = (Param)argAnnotation;
							paramsMap.put(paramAnnotation.value(), args[i]);
						}
					}
				}
			}
		}
		
		// Instantiate generator and create the output
		Generator g = generatorClass.newInstance();
		return g.generate(template, paramsMap, paramsList);
	}

}
