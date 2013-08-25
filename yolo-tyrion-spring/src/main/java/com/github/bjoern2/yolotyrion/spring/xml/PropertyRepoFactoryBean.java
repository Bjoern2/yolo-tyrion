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
package com.github.bjoern2.yolotyrion.spring.xml;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.springframework.beans.factory.FactoryBean;

import com.github.bjoern2.yolotyrion.interfaces.PropertyRepository;

public class PropertyRepoFactoryBean implements FactoryBean<PropertyRepository> {

	private Class<?> repositoryInterface;
	private InvocationHandler handler;
	
	@Override
	public PropertyRepository getObject() throws Exception {
		return (PropertyRepository)Proxy.newProxyInstance(repositoryInterface.getClassLoader(), new Class<?>[] {repositoryInterface}, getHandler());
	}

	@Override
	public Class<?> getObjectType() {
		return repositoryInterface;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	public Class<?> getRepositoryInterface() {
		return repositoryInterface;
	}

	public void setRepositoryInterface(Class<?> repositoryInterface) {
		this.repositoryInterface = repositoryInterface;
	}

	public InvocationHandler getHandler() {
		return handler;
	}

	public void setHandler(InvocationHandler handler) {
		this.handler = handler;
	}

}
