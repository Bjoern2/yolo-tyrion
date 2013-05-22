package com.github.bjoern2.yolotyrion.interfaces;

import com.github.bjoern2.yolotyrion.generator.Generator;

public interface TemplateRepositoryWithLookup extends TemplateRepository {

	String getString(String filename);
	
	String getString(String filename, Object... params);
	
	String getString(String filename, Generator generator, Object... params);
	
}
