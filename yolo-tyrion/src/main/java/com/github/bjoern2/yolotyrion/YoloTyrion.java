package com.github.bjoern2.yolotyrion;

import com.github.bjoern2.yolotyrion.interfaces.PropertyRepository;
import com.github.bjoern2.yolotyrion.interfaces.TemplateRepository;
import com.github.bjoern2.yolotyrion.interfaces.TemplateRepositoryWithLookup;

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
