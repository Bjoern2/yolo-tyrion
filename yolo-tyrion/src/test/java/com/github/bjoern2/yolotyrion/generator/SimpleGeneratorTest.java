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
package com.github.bjoern2.yolotyrion.generator;

import org.junit.Assert;
import org.junit.Test;

import com.github.bjoern2.yolotyrion.YoloTyrion;
import com.github.bjoern2.yolotyrion.templates.simple.Simple2Templates;
import com.github.bjoern2.yolotyrion.templates.simple.SimpleTemplates;

public class SimpleGeneratorTest {

	@Test
	public void testGenerator1() {
		SimpleTemplates proxy = YoloTyrion.create(SimpleTemplates.class);
		
		String result = proxy.helloWorld("Björn", "Schmitz");
		Assert.assertEquals("String must be replaced", "Hello Björn Schmitz!", result);
	}
	
	@Test
	public void testGenerator2() {
		Simple2Templates proxy = YoloTyrion.create(Simple2Templates.class);
		String result = proxy.getString("helloWorld2.txt", new SimpleGenerator(), "Björn", "Schmitz");
		Assert.assertEquals("String must be replaced", "Hello Björn Schmitz!", result);
	}
	
}
