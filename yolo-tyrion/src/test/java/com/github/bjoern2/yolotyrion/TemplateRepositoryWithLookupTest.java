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
package com.github.bjoern2.yolotyrion;

import com.github.bjoern2.yolotyrion.generator.SimpleGenerator;
import com.github.bjoern2.yolotyrion.templates.simple.Simple2Templates;

public class TemplateRepositoryWithLookupTest {

	public void testHelloWorld() {
		Simple2Templates templates = YoloTyrion.create(Simple2Templates.class);
		String value = templates.getString("helloWorld2.txt", new SimpleGenerator(), "Björn", "Schmitz");
	}
	
}
