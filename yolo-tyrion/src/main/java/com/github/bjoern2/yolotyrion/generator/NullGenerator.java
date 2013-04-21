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

import java.util.List;
import java.util.Map;

/**
 * The generator does nothing. It returns just the given template.
 */
public class NullGenerator implements Generator {

	/**
	 * I do nothing. I return just the given template.
	 */
	@Override
	public String generate(String template, Map<String, Object> params, List<Object> paramsList) {
		return template;
	}

}
