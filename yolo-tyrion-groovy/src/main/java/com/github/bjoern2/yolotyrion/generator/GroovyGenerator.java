package com.github.bjoern2.yolotyrion.generator;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GroovyGenerator implements Generator {

	@Override
	public String generate(String template, Map<String, Object> paramsMap, List<Object> paramsList) {
		final Binding binding = new Binding();
		binding.setVariable("paramsMap", paramsMap);
		binding.setVariable("paramsList", paramsList);
		
		for (Entry<String, Object> entry : paramsMap.entrySet()) {
			binding.setVariable(entry.getKey(), entry.getValue());
		}
		
		final GroovyShell shell = new GroovyShell(binding);

		final Object value = shell.evaluate(template);
		return "" + value;
	}

}
