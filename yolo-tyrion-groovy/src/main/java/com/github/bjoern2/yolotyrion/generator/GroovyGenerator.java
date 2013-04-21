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
