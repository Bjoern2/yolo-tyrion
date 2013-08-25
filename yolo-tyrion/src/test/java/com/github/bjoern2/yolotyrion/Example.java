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

import com.github.bjoern2.yolotyrion.templates.simple.SimpleTemplates;

public class Example {

	public static void main(String[] args) {
		TemplateRepositoryProxyFactory factory = new TemplateRepositoryProxyFactory();
		
		// Create a proxy of your interface.
		SimpleTemplates proxy = factory.generateProxy(SimpleTemplates.class);
		
		// I put your values into the template.
		String result = proxy.helloWorld("Björn", "Schmitz");
		
		// Hey see it!
		System.out.println(result);
	}

}
