package com.github.bjoern2.yolotyrion.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;


public class SimpleGenerator implements Generator {
	
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
			result = result.replace(":" + key, "" + paramsMap.get(key));
		}
		
		for (int i = paramsList.size() - 1; i >= 0; i--) {
			result = result.replace("?" + (i + 1), "" + paramsList.get(i));
		}
		return result;
	}

}
