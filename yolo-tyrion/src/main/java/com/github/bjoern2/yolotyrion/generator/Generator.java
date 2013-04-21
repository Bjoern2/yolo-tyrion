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

import com.github.bjoern2.yolotyrion.annotations.Param;

/**
 * A generator which builds an output with a template and parameters.
 */
public interface Generator {
	
	/**
	 * Builds an output with a template and parameters.
	 * @param template Filename of a template.
	 * @param paramsMap All arguments of the declared method, which are declared with @{@link Param}.
	 * @param paramsList All arguments of the declated method.
	 * @return The template filled with values.
	 */
	String generate(String template, Map<String, Object> paramsMap, List<Object> paramsList);
	
}
