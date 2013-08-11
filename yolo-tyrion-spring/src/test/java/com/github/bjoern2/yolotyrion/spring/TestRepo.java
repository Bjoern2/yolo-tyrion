package com.github.bjoern2.yolotyrion.spring;

import com.github.bjoern2.yolotyrion.annotations.Template;
import com.github.bjoern2.yolotyrion.interfaces.TemplateRepository;

public interface TestRepo extends TemplateRepository {

	@Template(filename = "test.txt")
	String test();
	
}
