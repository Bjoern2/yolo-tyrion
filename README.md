**Yolo Tyrion**
===============
Hi! I'm Yolo Tyrion!
I'm a template generator and resource repository framework for Java.

You can declare your resources/templates/properties as methods in interfaces.
I do the rest for you!

[![Build Status](https://buildhive.cloudbees.com/job/Bjoern2/job/yolo-tyrion/badge/icon)](https://buildhive.cloudbees.com/job/Bjoern2/job/yolo-tyrion/)

## License:
Apache License, Version 2.0: http://www.apache.org/licenses/LICENSE-2.0

## Continous integration:
Jenkins by Cloudbees/Buildhive: https://buildhive.cloudbees.com/job/Bjoern2/job/yolo-tyrion/

## Example:

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


## Why and when is yolo-tyrion a solution for you?
==========
Sometimes you've really, really big String statements in Java. E.g. SQL/HQL/JPQL queries...
In the cases it's better to move the big strings into text files. But it's too complicated to read the string out of a file. And if you have values which you must insert into the string... O_o

See this:

### The ugly way:
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
#### The problems:
* SQL is not easy to read.
* Autoformat of your IDE will destroy the format of your statement.
* You can not copy the sql to any command shell. (e.g. phpMyAdmin)
* If you forget a blank space or "\n" at the end of a row the statement creates an error. (e.g. "l.email,FROMlogin")
* You'll get a big file/method/class.


### The better/cleaner way:

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

#### The problems I solve:
* SQL is now easy to read.
* No problems with autoformat.
* You can copy the sql and paste it somewhere you want.
* No escaping symbols like "\n" "\""...
* The repository class is smaller.


## Download
Current version: 0.0.1-SNAPSHOT

### Maven
Add the repository to your pom.xml:
```xml
<repositories>
	<repository>
		<id>com.github.bjoern2</id>
		<url>https://raw.github.com/Bjoern2/mvn-repo/master/snapshots/</url>
	</repository>
</repositories>
```

Then add the main library:
```xml
<dependency>
	<groupId>com.github.bjoern2</groupId>
	<artifactId>yolo-tyrion</artifactId>
	<version>0.0.1-SNAPSHOT</version>
</dependency>
```

If you need Velocity or Groovy support add one of this dependencies:
```xml
<dependency>
	<groupId>com.github.bjoern2</groupId>
	<artifactId>yolo-tyrion-velocity</artifactId>
	<version>0.0.1-SNAPSHOT</version>
</dependency>

<dependency>
	<groupId>com.github.bjoern2</groupId>
	<artifactId>yolo-tyrion-groovy</artifactId>
	<version>0.0.1-SNAPSHOT</version>
</dependency>
```

[![githalytics.com alpha](https://cruel-carlota.pagodabox.com/32bac0b37e0acee1aad83042c5dc6b68 "githalytics.com")](http://githalytics.com/Bjoern2/yolo-tyrion)
