package com.github.bjoern2.yolotyrion.templates.simple;

import com.github.bjoern2.yolotyrion.annotations.Param;
import com.github.bjoern2.yolotyrion.annotations.Template;
import com.github.bjoern2.yolotyrion.generator.SimpleGenerator;

public interface SimpleTemplates {

	@Template(filename = "helloWorld.txt", generator = SimpleGenerator.class)
	String helloWorld(@Param("firstname") String firstname, @Param("lastname") String lastname);
	
}
