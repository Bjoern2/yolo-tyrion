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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;


public class SimpleGenerator implements Generator {
	
	private String stringParamPrefix = ":";
	private String stringParamPostfix = "";
	private String numberParamPrefix = "?";
	private String numberParamPostfix = "";
	
	private Comparator<String> comparator;
	
	public SimpleGenerator() {
		comparator = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.length() - o1.length();
			}
		};
	}
	
	@Override
	public String generate(String template, Map<String, Object> paramsMap, List<Object> paramsList) {
		List<String> keys = new ArrayList<String>(paramsMap.keySet());
		Collections.sort(keys, comparator);
		
		String result = template;
		for (String key : keys) {
			final String k = stringParamPrefix + key + stringParamPostfix;
			final String v = "" + paramsMap.get(key);
			result = result.replace(k, v);
		}
		
		for (int i = paramsList.size() - 1; i >= 0; i--) {
			final String k = numberParamPrefix + (i + 1) + numberParamPostfix;
			final String v = "" + paramsList.get(i);
			result = result.replace(k, v);
		}
		return result;
	}

}
