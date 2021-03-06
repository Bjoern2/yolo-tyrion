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

import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import com.github.bjoern2.yolotyrion.annotations.Properties;
import com.github.bjoern2.yolotyrion.annotations.Property;

/**
 * I'm the implementation of a TemplateRepository interface.
 */
public class PropertyRepositoryInvocationHandler implements InvocationHandler {
	
	
	private final Map<String, ResourceBundle> resourceBundles = new HashMap<String, ResourceBundle>();
	
	public PropertyRepositoryInvocationHandler() {
		super();
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		final String filename;
		final Properties propertiesAnnotation = method.getDeclaringClass().getAnnotation(Properties.class);
		if (propertiesAnnotation != null) {
			filename = propertiesAnnotation.filename();
		} else {
			filename = method.getDeclaringClass().getSimpleName();
		}
		
		final String propertyName;
		final Property propertyAnnotation = method.getAnnotation(Property.class);
		if (propertyAnnotation != null) {
			propertyName = propertyAnnotation.name();
		} else {
			propertyName = method.getName();
		}
		
		String baseName = method.getDeclaringClass().getPackage().getName() + "." + filename;
		ResourceBundle rb = getResourceBundle(baseName);
		
		final Class<?> returnType = method.getReturnType();
		if (returnType.equals(String.class)) {
			final String value = rb.getString(propertyName);
			if ((args != null) && (args.length > 0)) {
				return MessageFormat.format(value, args);
			} else {
				return value;
			}
		} else if (returnType.equals(Double.class)) {
			final String value = rb.getString(propertyName);
			return new Double(value);
		} else if (returnType.equals(double.class)) {
			final String value = rb.getString(propertyName);
			return new Double(value).doubleValue();
		} else if (returnType.equals(Integer.class)) {
			final String value = rb.getString(propertyName);
			return new Integer(value);
		} else if (returnType.equals(int.class)) {
			final String value = rb.getString(propertyName);
			return new Integer(value).intValue();
		} else if (returnType.equals(Long.class)) {
			final String value = rb.getString(propertyName);
			return new Long(value);
		} else if (returnType.equals(long.class)) {
			final String value = rb.getString(propertyName);
			return new Long(value).longValue();
		} else if (returnType.equals(Float.class)) {
			final String value = rb.getString(propertyName);
			return new Float(value);
		} else if (returnType.equals(float.class)) {
			final String value = rb.getString(propertyName);
			return new Float(value).floatValue();
		} else if (returnType.equals(File.class)) {
			final String value = rb.getString(propertyName);
			return new File(value);
		} else {
			return rb.getObject(propertyName);
		}

	}
	
	private ResourceBundle getResourceBundle(String baseName) {
		if (!resourceBundles.containsKey(baseName)) {
			ResourceBundle rb = ResourceBundle.getBundle(baseName);
			resourceBundles.put(baseName, rb);
		}
		return resourceBundles.get(baseName);
	}

}
