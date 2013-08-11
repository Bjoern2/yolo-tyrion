package com.github.bjoern2.yolotyrion.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

	@Autowired
	private TestTemplateRepo testRepo;
	
	@Autowired
	private TestProperties testProperties;
	
	public String testTemplate() {
		return testRepo.test();
	}
	
	public String testProperty() {
		return testProperties.hello();
	}
	
}
