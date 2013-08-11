package com.github.bjoern2.yolotyrion.spring;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		Object templateRepositoryProxyFactory = ctx.getBean("templateRepositoryProxyFactory");
		Assert.assertNotNull(templateRepositoryProxyFactory);
		
		TestRepo testRepo = (TestRepo)ctx.getBean(TestRepo.class);
		Assert.assertNotNull(testRepo);
		
		String hello = testRepo.test();
		Assert.assertEquals("Hello World!", hello);
	}
	
}
