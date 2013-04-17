package com.github.bjoern2.yolotyrion.templates.none;

import com.github.bjoern2.yolotyrion.annotations.Param;
import com.github.bjoern2.yolotyrion.annotations.Template;

public interface OnlyResources {

	@Template(filename = "helloWorld.txt")
	String helloWorld(@Param("yourName") String yourName);
	
}
