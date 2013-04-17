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


# Why and when is yolo-tyrion a solution for you?
==========
Sometime you've really, really big String statements in Java. E.g. SQL/HQL/JPQL queries...
Sometimes it's better to move the big String into a text file. But it's too complicated to read the string out of the file. And if you have values which you must insert into the String goes everthing the ugly way...
See this:

## The ugly way:
Any java file:
```java
public class UglyClass {

	[...]

	public List<Bean> theUglyWay() {
		String sql = "SELECT \n" + 
			" l.username, \n" + 
			" l.email, \n" + 
			"FROM \n" + 
			" login l \n" +
			"WHERE \n" + 
			" l.active = true \n";
		Query query = entityManager.createNativeQuery(sql);
		[...]
	}
}
```
### The problems:
* SQL is not easy to read.
* Autoformat of your IDE will destroy the format of your statement.
* You can not copy the sql to any command shell. (e.g. phpMyAdmin)
* If you forget a blank space of "\n" at the end of a row the statement creates errors. (e.g. "l.email,FROMlogin")


## The better/cleaner way:

BetterClass.java
```java
public class BetterClass {

	private TemplateRepositoryProxyFactory factory;
	private SqlStatements statements;
	[...]

	public BetterClass() {
		factory = new TemplateRepositoryProxyFactory();
		statements = factory.generateProxy(SqlStatements.class);
	}

	public List<Bean> theGoodWay() {
		String sql = statements.theGoodSql();
		Query query = entityManager.createNativeQuery(sql);
		[...]
	}
}
```

SqlStatements.java:
```java
public interface SqlStatements {
	@Template(filename = "theGoodSql.sql")
	String theGoodSql();
}
```

theGoogSql.sql:
```
SELECT 
	l.username,
	l.email,
FROM
	login l
WHERE 
	l.active = true
```

