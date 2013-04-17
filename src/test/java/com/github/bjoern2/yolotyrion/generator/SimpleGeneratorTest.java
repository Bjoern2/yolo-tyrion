package com.github.bjoern2.yolotyrion.generator;

import org.junit.Assert;
import org.junit.Test;

import com.github.bjoern2.yolotyrion.TemplateRepositoryProxyFactory;
import com.github.bjoern2.yolotyrion.templates.simple.SimpleTemplates;

public class SimpleGeneratorTest {

	@Test
	public void testGenerator() {
		TemplateRepositoryProxyFactory factory = new TemplateRepositoryProxyFactory();
		
		SimpleTemplates proxy = factory.generateProxy(SimpleTemplates.class);
		
		String result = proxy.helloWorld("Björn", "Schmitz");
		Assert.assertEquals("String must be replaced", "Hello Björn Schmitz!", result);
	}
	
}
