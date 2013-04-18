package com.github.bjoern2.yolotyrion.generator;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

/**
 * I'm not implemented. Please try another one.
 */
public class VelocityGenerator implements Generator {

	private VelocityEngine engine;
	
	@Override
	public String generate(String template, Map<String, Object> params, List<Object> paramsList) {
		final VelocityContext context = new VelocityContext();
		context.internalPut("paramMap", params);
		context.put("paramsList", paramsList);
		for (Entry<String, Object> entry : params.entrySet()) {
			context.put(entry.getKey(), entry.getValue());
		}
		
		final StringReader reader = new StringReader(template);
		final StringWriter writer = new StringWriter();
		final boolean successful = getEngine().evaluate(context, writer, template, reader);
		if (!successful) {
			throw new RuntimeException("Error in template generator for Velocity.");
		}
		
		return writer.toString();
	}

	public VelocityEngine getEngine() {
		if (engine == null) {
			engine = new VelocityEngine();
		}
		return engine;
	}

	public void setEngine(VelocityEngine engine) {
		this.engine = engine;
	}

}
