package com.github.bjoern2.yolotyrion;

import org.junit.Assert;
import org.junit.Test;

import com.github.bjoern2.yolotyrion.properties.Example2Properties;
import com.github.bjoern2.yolotyrion.properties.ExampleProperties;

public class PropertyRepositoryTest {

	@Test
	public void testString1() {
		ExampleProperties p = YoloTyrion.create(ExampleProperties.class);
		String t = p.hello_world();
		Assert.assertEquals("Hallo Welt", t);
	}
	
	@Test
	public void testString2() {
		Example2Properties p = YoloTyrion.create(Example2Properties.class);
		String t = p.helloWorld();
		Assert.assertEquals("Hallo Welt", t);
	}
	
	@Test
	public void testInt() {
		ExampleProperties p = YoloTyrion.create(ExampleProperties.class);
		int val = p.my_int();
		Assert.assertEquals(2345, val);
	}
	
	@Test
	public void testDouble() {
		ExampleProperties p = YoloTyrion.create(ExampleProperties.class);
		double val = p.my_double();
		Assert.assertEquals(0.1234, val, 0.0001);
	}
	
	@Test
	public void testLong() {
		ExampleProperties p = YoloTyrion.create(ExampleProperties.class);
		long val = p.my_long();
		Assert.assertEquals(123456, val);
	}
	
	@Test
	public void testGreetings() {
		ExampleProperties p = YoloTyrion.create(ExampleProperties.class);
		String value = p.greetings("Björn", 29);
		Assert.assertEquals("Hello Björn. Your age is 29.", value);
	}
	
}
