package com.github.bjoern2.yolotyrion.templates.groovy;

import com.github.bjoern2.yolotyrion.annotations.Param;
import com.github.bjoern2.yolotyrion.annotations.Template;
import com.github.bjoern2.yolotyrion.generator.GroovyGenerator;

public interface GroovyTemplates {

	@Template(filename = "whatIsTheMeaningOfLifeTheUniverseAndEverything.groovy", generator = GroovyGenerator.class)
	String whatIsTheMeaningOfLifeTheUniverseAndEverything(@Param("answer") int answer);
	
}
