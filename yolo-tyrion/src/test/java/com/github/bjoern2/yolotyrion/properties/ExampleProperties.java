package com.github.bjoern2.yolotyrion.properties;

import com.github.bjoern2.yolotyrion.interfaces.PropertyRepository;

public interface ExampleProperties extends PropertyRepository {

	String hello_world();
	
	int my_int();
	
	double my_double();
	
	long my_long();
	
	String greetings(String name, int age);
	
}
