package com.github.bjoern2.yolotyrion.properties;

import com.github.bjoern2.yolotyrion.annotations.Properties;
import com.github.bjoern2.yolotyrion.annotations.Property;
import com.github.bjoern2.yolotyrion.interfaces.PropertyRepository;

@Properties(filename = "ExampleProperties")
public interface Example2Properties extends PropertyRepository{

	@Property(name = "hello_world")
	String helloWorld();
	
	int my_int();
	
}
