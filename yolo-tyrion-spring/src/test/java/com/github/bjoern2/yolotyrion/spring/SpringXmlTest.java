package com.github.bjoern2.yolotyrion.spring;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringXmlTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		TestTemplateRepo testRepo = (TestTemplateRepo)ctx.getBean(TestTemplateRepo.class);
		Assert.assertNotNull(testRepo);
		
		String hello = testRepo.test();
		Assert.assertEquals("Hello World!", hello);
		
		TestProperties props = (TestProperties)ctx.getBean(TestProperties.class);
		Assert.assertNotNull(props);
		
		String hello2 = props.hello();
		Assert.assertEquals("Hello", hello2);
		
	}
	
}
