package com.github.bjoern2.yolotyrion;

import org.junit.Assert;
import org.junit.Test;

import com.github.bjoern2.yolotyrion.properties.Example2Properties;
import com.github.bjoern2.yolotyrion.properties.ExampleProperties;

public class PropertyRepositoryTest {

	@Test
	public void test1() {
		ExampleProperties p = YoloTyrion.create(ExampleProperties.class);
		String t = p.hello_world();
		Assert.assertEquals("Hallo Welt", t);
	}
	
	@Test
	public void test2() {
		Example2Properties p = YoloTyrion.create(Example2Properties.class);
		String t = p.helloWorld();
		Assert.assertEquals("Hallo Welt", t);
	}
	
}
