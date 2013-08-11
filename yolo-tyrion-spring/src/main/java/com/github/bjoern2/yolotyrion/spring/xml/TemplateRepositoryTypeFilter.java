package com.github.bjoern2.yolotyrion.spring.xml;

import java.io.IOException;

import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import com.github.bjoern2.yolotyrion.interfaces.TemplateRepository;

public class TemplateRepositoryTypeFilter implements TypeFilter {

	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
		
		String[] interfaceNames = metadataReader.getClassMetadata().getInterfaceNames();
		for (String interfaceName : interfaceNames) {
			if (interfaceName.equals(TemplateRepository.class.getName())) {
				return true;
			}
		}
		return false;
	}

}
