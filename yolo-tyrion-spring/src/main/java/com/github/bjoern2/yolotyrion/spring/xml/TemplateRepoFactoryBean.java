package com.github.bjoern2.yolotyrion.spring.xml;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.springframework.beans.factory.FactoryBean;

import com.github.bjoern2.yolotyrion.interfaces.TemplateRepository;

public class TemplateRepoFactoryBean implements FactoryBean<TemplateRepository> {

	private Class<?> repositoryInterface;
	private InvocationHandler handler;
	
	@Override
	public TemplateRepository getObject() throws Exception {
		return (TemplateRepository)Proxy.newProxyInstance(repositoryInterface.getClassLoader(), new Class<?>[] {repositoryInterface}, getHandler());
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
