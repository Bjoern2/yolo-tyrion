package com.github.bjoern2.yolotyrion;

import com.github.bjoern2.yolotyrion.generator.SimpleGenerator;
import com.github.bjoern2.yolotyrion.templates.simple.Simple2Templates;

public class TemplateRepositoryWithLookupTest {

	public void testHelloWorld() {
		Simple2Templates templates = YoloTyrion.create(Simple2Templates.class);
		String value = templates.getString("helloWorld2.txt", new SimpleGenerator(), "Björn", "Schmitz");
	}
	
}
