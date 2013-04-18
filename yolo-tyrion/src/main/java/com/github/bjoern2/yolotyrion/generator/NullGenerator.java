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
