**yolo-tyrion**
===========
Hi! I'm yolo-tyrion!
I'm a template generator and resource repository framework for Java.

You can declare your resources/templates as methods in interface. I'll do the rest!

**Example:**

SimpleTemplates.java
```java
package com.github.bjoern2.yolotyrion.templates.simple;

import com.github.bjoern2.yolotyrion.annotations.Param;
import com.github.bjoern2.yolotyrion.annotations.Template;
import com.github.bjoern2.yolotyrion.generator.SimpleGenerator;

public interface SimpleTemplates {

  @Template(filename = "helloWorld.txt", generator = SimpleGenerator.class)
  String helloWorld(@Param("firstname") String firstname, @Param("lastname") String lastname);
	
}
```

helloWorld.txt
```
Hello :firstname :lastname!
```

Example.java
```java
package com.github.bjoern2.yolotyrion;

import com.github.bjoern2.yolotyrion.templates.simple.SimpleTemplates;

public class Example {

  public static void main(String[] args) {
		TemplateRepositoryProxyFactory factory = new TemplateRepositoryProxyFactory();
		
		// Create a proxy of your interface.
		SimpleTemplates proxy = factory.generateProxy(SimpleTemplates.class);
		
		// I put your values into the template.
		String result = proxy.helloWorld("Björn", "Schmitz");
		
		// Hey see it!
		System.out.println(result);
	}

}
```

**That's it!**
