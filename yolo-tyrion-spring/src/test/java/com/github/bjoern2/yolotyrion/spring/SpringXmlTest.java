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
