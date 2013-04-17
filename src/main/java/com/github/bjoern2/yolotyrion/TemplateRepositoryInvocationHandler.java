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

import org.apache.commons.io.IOUtils;

import com.github.bjoern2.yolotyrion.annotations.Param;
import com.github.bjoern2.yolotyrion.annotations.Template;
import com.github.bjoern2.yolotyrion.generator.Generator;

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
		final String filename = t.filename();
		final Class<? extends Generator> generatorClass = t.generator();
		
		// Try to find the template file:
		final InputStream in = proxy.getClass().getInterfaces()[0].getResourceAsStream(filename);
		if (in == null) {
			throw new MissingResourceException("Cannot find the template file.", method.getClass().getName(), filename);
		}
		final String template = IOUtils.toString(in);

		// Collect params:
		final List<Object> paramsList = new ArrayList<Object>();
		final Map<String, Object> paramsMap = new HashMap<String, Object>();
		final Annotation[][] paramAnnotations = method.getParameterAnnotations();
		for (int i = 0; i < args.length; i++) {
			paramsList.add(args[i]);
			
			final Annotation[] argAnnotations = paramAnnotations[i];
			for (Annotation argAnnotation : argAnnotations) {
				if (argAnnotation instanceof Param) {
					final Param paramAnnotation = (Param)argAnnotation;
					paramsMap.put(paramAnnotation.value(), args[i]);
				}
			}
		}
		
		// Instanciate generator and create the output
		Generator g = generatorClass.newInstance();
		return g.generate(template, paramsMap, paramsList);
	}

}
