package com.github.bjoern2.yolotyrion.generator;

import org.junit.Test;

import com.github.bjoern2.yolotyrion.TemplateRepositoryProxyFactory;
import com.github.bjoern2.yolotyrion.templates.velocity.VelocityTemplates;

public class VelocityGeneratorTest {

	@Test
	public void testGenerator() {
		TemplateRepositoryProxyFactory factory = new TemplateRepositoryProxyFactory();
		
		VelocityTemplates proxy = factory.generateProxy(VelocityTemplates.class);
		
		String result = proxy.confirmationEMail("Max", "Mustermann", false);
		System.out.println(result);
		
//		Assert.assertEquals("String must be replaced", "Hello Björn Schmitz!", result);
	}
	
}
