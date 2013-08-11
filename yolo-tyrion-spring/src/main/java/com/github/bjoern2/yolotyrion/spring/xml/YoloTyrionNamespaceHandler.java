package com.github.bjoern2.yolotyrion.spring.xml;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class YoloTyrionNamespaceHandler extends NamespaceHandlerSupport {

	@Override
	public void init() {
		registerBeanDefinitionParser("repository", new RepositorySingleBeanDefinitionParser());
	}

}
