package com.github.bjoern2.yolotyrion.utils;

import java.lang.reflect.Method;

public class ReflectUtils {

	public static boolean isFromInterface(Method m, Class<?> interfaceClazz) {
		try {
			interfaceClazz.getMethod(m.getName(), m.getParameterTypes());
			return true;
		} catch (NoSuchMethodException e) {
			return false;
		}
	} 
	
}
