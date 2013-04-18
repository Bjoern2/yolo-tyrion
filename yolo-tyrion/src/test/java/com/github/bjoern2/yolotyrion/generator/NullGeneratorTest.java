package com.github.bjoern2.yolotyrion.generator;

import org.junit.Assert;
import org.junit.Test;

import com.github.bjoern2.yolotyrion.TemplateRepositoryProxyFactory;
import com.github.bjoern2.yolotyrion.templates.none.OnlyResources;

public class NullGeneratorTest {

	@Test
	public void testGenerator() {
		TemplateRepositoryProxyFactory factory = new TemplateRepositoryProxyFactory();
		OnlyResources proxy = factory.generateProxy(OnlyResources.class);
		Assert.assertEquals("Result is wrong.", "Hello World!", proxy.helloWorld("Björn"));
	}
	
}
