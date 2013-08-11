package com.github.bjoern2.yolotyrion.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TestService {

	@Autowired
//	@Qualifier("testRepo")
	private TestRepo testRepo;
	
	public String test() {
		return testRepo.test();
	}
	
}
