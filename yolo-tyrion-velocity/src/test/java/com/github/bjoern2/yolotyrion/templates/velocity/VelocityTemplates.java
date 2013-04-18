package com.github.bjoern2.yolotyrion.templates.velocity;

import com.github.bjoern2.yolotyrion.annotations.Param;
import com.github.bjoern2.yolotyrion.annotations.Template;
import com.github.bjoern2.yolotyrion.generator.VelocityGenerator;

public interface VelocityTemplates {

	@Template(filename = "confirmationEMail.vm", generator = VelocityGenerator.class)
	String confirmationEMail(@Param("firstname") String firstname, @Param("lastname") String lastname, @Param("successful") boolean successful);
	
}
