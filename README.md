# Spring MVC Cache Control

Spring MVC Cache Control is an extension to [Spring MVC][spring_mvc] that aims to simplify implementing HTTP/1.1 Cache-Control headers for annotated MVC controllers.

## Checkout and Build from Source

1. Clone the repository from GitHub:

		$ git clone git://github.com/foo4u/spring-mvc-cache-control

2. Navigate into the cloned repository directory:

		$ cd spring-mvc-cache-control

3. The project uses [Gradle][gradle] to build:

		$ ./gradlew build

## Eclipse

To generate Eclipse metadata (.classpath and .project files), use the following Gradle task:

	$ ./gradlew eclipse

Once complete, you may then import the projects into Eclipse as usual:

	File -> Import -> Existing projects into workspace

## JavaDoc

Use the following Gradle task to build the JavaDoc

	$ ./gradlew :docs:api

_Note: The result will be available in 'docs/build/api'._

[spring_mvc]: http://static.springsource.org/spring/docs/current/spring-framework-reference/html/mvc.html
[gradle]: http://gradle.org/
