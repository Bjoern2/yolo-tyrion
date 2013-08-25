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

import java.beans.Introspector;
import java.util.Set;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.parsing.BeanComponentDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.util.ClassUtils;
import org.w3c.dom.Element;

import com.github.bjoern2.yolotyrion.PropertyRepositoryInvocationHandler;
import com.github.bjoern2.yolotyrion.TemplateRepositoryInvocationHandler;
import com.github.bjoern2.yolotyrion.interfaces.PropertyRepository;
import com.github.bjoern2.yolotyrion.interfaces.TemplateRepository;

public class RepositorySingleBeanDefinitionParser implements BeanDefinitionParser {

	@Override
	public BeanDefinition parse(Element element, ParserContext parserContext) {
		// Scan classpath:
		String basePackage = element.getAttribute("basePackage");
		
		// Scan for TemplateRepositories
		ClassPathScanningCandidateComponentProvider provider = generateScanner(TemplateRepository.class);
		Set<BeanDefinition> candidates = provider.findCandidateComponents(basePackage);
		for (BeanDefinition candidate : candidates) {
			BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(TemplateRepoFactoryBean.class);
			builder.addPropertyValue("repositoryInterface", candidate.getBeanClassName());
			builder.addPropertyValue("handler", new TemplateRepositoryInvocationHandler());
			AbstractBeanDefinition def = builder.getRawBeanDefinition();
			
			String beanName = buildDefaultBeanName(def);
			registerBean(def, beanName, parserContext);
		}
		
		// Scan for PropertyRepositories
		provider = generateScanner(PropertyRepository.class);
		candidates = provider.findCandidateComponents(basePackage);
		for (BeanDefinition candidate : candidates) {
			BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(PropertyRepoFactoryBean.class);
			builder.addPropertyValue("repositoryInterface", candidate.getBeanClassName());
			builder.addPropertyValue("handler", new PropertyRepositoryInvocationHandler());
			AbstractBeanDefinition def = builder.getRawBeanDefinition();
			
			String beanName = buildDefaultBeanName(def);
			registerBean(def, beanName, parserContext);
		}
		
		return null;
	}
	
	protected ClassPathScanningCandidateComponentProvider generateScanner(Class<?> interfaze) {
		ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false) {
			@Override
			protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
				return true;
			}
		};
		provider.addIncludeFilter(new AssignableTypeFilter(interfaze));
		return provider;
	}
	
	protected String buildDefaultBeanName(BeanDefinition definition) {
//		BeanDefinitionReaderUtils.generateBeanName(beanDefinition, registry)
		String shortClassName = ClassUtils.getShortName(definition.getBeanClassName());
		return Introspector.decapitalize(shortClassName);
	}

	
	protected void registerBean(BeanDefinition def, String name, ParserContext parserContext) {
		BeanDefinitionHolder holder = new BeanDefinitionHolder(def, name);
		BeanComponentDefinition component = new BeanComponentDefinition(holder);
		parserContext.registerBeanComponent(component);
	}

}
