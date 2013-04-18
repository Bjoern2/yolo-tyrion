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
