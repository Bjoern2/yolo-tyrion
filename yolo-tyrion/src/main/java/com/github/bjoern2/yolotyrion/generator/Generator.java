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
