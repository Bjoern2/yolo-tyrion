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
