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

public class SpringAnnotationsTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_annotations.xml");
		
		TestService service = ctx.getBean(TestService.class);
		String hello = service.testTemplate();
		Assert.assertEquals("Hello World!", hello);
		
		String hello2 = service.testProperty();
		Assert.assertEquals("Hello", hello2);
	}
	
}
