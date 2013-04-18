package com.github.bjoern2.yolotyrion.generator;

import org.junit.Assert;
import org.junit.Test;

import com.github.bjoern2.yolotyrion.TemplateRepositoryProxyFactory;
import com.github.bjoern2.yolotyrion.templates.groovy.GroovyTemplates;

public class GroovyGeneratorTest {

	@Test
	public void testGenerator() {
		TemplateRepositoryProxyFactory factory = new TemplateRepositoryProxyFactory();
		
		GroovyTemplates proxy = factory.generateProxy(GroovyTemplates.class);
		
		String result = proxy.whatIsTheMeaningOfLifeTheUniverseAndEverything(42);
		Assert.assertEquals("String must be replaced", "The answer is 42", result);
	}
	
}
