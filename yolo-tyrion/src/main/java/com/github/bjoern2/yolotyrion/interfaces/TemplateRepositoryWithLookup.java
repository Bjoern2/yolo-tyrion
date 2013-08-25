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
package com.github.bjoern2.yolotyrion.interfaces;

import com.github.bjoern2.yolotyrion.generator.Generator;

public interface TemplateRepositoryWithLookup extends TemplateRepository {

	String getString(String filename);
	
	String getString(String filename, Object... params);
	
	String getString(String filename, Generator generator, Object... params);
	
}
