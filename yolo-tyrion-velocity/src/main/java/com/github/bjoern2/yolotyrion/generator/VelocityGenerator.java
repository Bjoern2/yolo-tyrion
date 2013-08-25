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

import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

/**
 * Generator implementation for Apache Velocity.
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
