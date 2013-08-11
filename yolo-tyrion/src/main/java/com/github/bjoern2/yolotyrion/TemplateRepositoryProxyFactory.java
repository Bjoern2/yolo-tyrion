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

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Proxy factory for template repositories.<br/>
 * Sample:
 * <pre>
 * {@code
 * TemplateRepositoryProxyFactory factory = new TemplateRepositoryProxyFactory();
 * MyTemplates templates = factory.generateProxy(MyTemplates.class);
 * String output = templates.helloWorld();
 * }
 * </pre>
 */
public class TemplateRepositoryProxyFactory {

	private InvocationHandler handler;
	
	/**
	 * Creates a proxy of your template repository.
	 * @param <X> The tnterface class type
	 * @param clazz The interface class.
	 * @return A proxy of a template repository.
	 */
	@SuppressWarnings("unchecked")
	public <X> X generateProxy(Class<X> clazz) {
		return (X)Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[] {clazz}, getHandler());
	}
	
	/**
	 * Creates a proxy of your property repository.
	 * @param <X> The interface class type
	 * @param clazz The interface classname
	 * @return A proxy of a template repository.
	 */
	@SuppressWarnings("unchecked")
	public <X> X generateProxy(String clazzName) {
		try {
			Class<X> clazz = (Class<X>)Class.forName(clazzName);
			return generateProxy(clazz);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	protected InvocationHandler getHandler() {
		if (handler == null) {
			handler = new TemplateRepositoryInvocationHandler();
		}
		return handler;
	}

	public void setHandler(InvocationHandler handler) {
		this.handler = handler;
	}
	
}
