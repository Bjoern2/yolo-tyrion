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

import com.github.bjoern2.yolotyrion.interfaces.PropertyRepository;
import com.github.bjoern2.yolotyrion.interfaces.TemplateRepository;
import com.github.bjoern2.yolotyrion.interfaces.TemplateRepositoryWithLookup;

/**
 * Main class of Yolo Tyrion. <br>
 * Creates new repositories.
 */
public class YoloTyrion {

	private static TemplateRepositoryProxyFactory templateRepositoryProxyFactory;
	private static PropertyRepositoryProxyFactory propertyRepositoryProxyFactory;
	
	public static <X> X create(Class<X> clazz) {
		Class<?>[] interfaces = clazz.getInterfaces();
		for (Class<?> interfaze : interfaces) {
			if (interfaze.equals(TemplateRepository.class) || interfaze.equals(TemplateRepositoryWithLookup.class)) {
				return getTemplateRepositoryProxyFactory().generateProxy(clazz);
			} else if (interfaze.equals(PropertyRepository.class)) {
				return getPropertyRepositoryProxyFactory().generateProxy(clazz);
			}
		}
		throw new RuntimeException("Cannot find any interface.");
		
		
	}
	
	private static TemplateRepositoryProxyFactory getTemplateRepositoryProxyFactory() {
		if (templateRepositoryProxyFactory == null) {
			templateRepositoryProxyFactory = new TemplateRepositoryProxyFactory();
		}
		return templateRepositoryProxyFactory;
	}

	public static PropertyRepositoryProxyFactory getPropertyRepositoryProxyFactory() {
		if (propertyRepositoryProxyFactory == null) {
			propertyRepositoryProxyFactory = new PropertyRepositoryProxyFactory();
		}
		return propertyRepositoryProxyFactory;
	}
	
}
