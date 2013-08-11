package com.github.bjoern2.yolotyrion.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAnnotationsTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_annotations.xml");
		
//		TestService service = ctx.getBean(TestService.class);
//		
//		
//		String hello = service.test();
//		Assert.assertEquals("Hello World!", hello);
	}
	
}
