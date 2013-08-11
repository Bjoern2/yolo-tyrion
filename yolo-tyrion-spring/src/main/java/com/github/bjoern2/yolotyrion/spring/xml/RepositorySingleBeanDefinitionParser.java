package com.github.bjoern2.yolotyrion.spring.xml;

import java.beans.Introspector;
import java.util.Set;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.parsing.BeanComponentDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.util.ClassUtils;
import org.w3c.dom.Element;

import com.github.bjoern2.yolotyrion.PropertyRepositoryProxyFactory;
import com.github.bjoern2.yolotyrion.TemplateRepositoryProxyFactory;
import com.github.bjoern2.yolotyrion.interfaces.TemplateRepository;

public class RepositorySingleBeanDefinitionParser implements BeanDefinitionParser {

	public final static String TEMPLATE_REPO_NAME = "templateRepositoryProxyFactory";
	public final static String PROPERTY_REPO_NAME = "propertyRepositoryProxyFactory";
	
	@Override
	public BeanDefinition parse(Element element, ParserContext parserContext) {
		
		// Register factories:
		RootBeanDefinition def1 = new RootBeanDefinition(TemplateRepositoryProxyFactory.class);
		registerBean(def1, TEMPLATE_REPO_NAME, parserContext);
		
		RootBeanDefinition def2 = new RootBeanDefinition(PropertyRepositoryProxyFactory.class);
		registerBean(def2, PROPERTY_REPO_NAME, parserContext);
		
		
		// Scan classpath:
		String basePackage = element.getAttribute("basePackage");
		ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false) {

			@Override
			protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
				return true;
			}
			
		};
		provider.addIncludeFilter(new AssignableTypeFilter(TemplateRepository.class));
		Set<BeanDefinition> candidates = provider.findCandidateComponents(basePackage);
		for (BeanDefinition candidate : candidates) {
//			GenericBeanDefinition def = new GenericBeanDefinition();
			RootBeanDefinition def = new RootBeanDefinition();
			def.setFactoryBeanName(TEMPLATE_REPO_NAME);
			def.setFactoryMethodName("generateProxy");
			def.setBeanClassName(candidate.getBeanClassName());
			ConstructorArgumentValues values = new ConstructorArgumentValues();
			values.addGenericArgumentValue(candidate.getBeanClassName());
			def.setConstructorArgumentValues(values);
			
			String beanName = buildDefaultBeanName(def);
			registerBean(def, beanName, parserContext);
		}
		return null;
	}
	
	protected String buildDefaultBeanName(BeanDefinition definition) {
		String shortClassName = ClassUtils.getShortName(definition.getBeanClassName());
		return Introspector.decapitalize(shortClassName);
	}

	
	protected void registerBean(BeanDefinition def, String name, ParserContext parserContext) {
		BeanDefinitionHolder holder = new BeanDefinitionHolder(def, name);
		BeanComponentDefinition component = new BeanComponentDefinition(holder);
		parserContext.registerBeanComponent(component);
	}

}
