# Spring MVC Cache Control ![Build Status] [status]

Spring MVC Cache Control is an extension to [Spring MVC][spring_mvc] that aims to simplify implementing HTTP/1.1 Cache-Control headers for annotated MVC controllers.

## Usage

### Add Spring MVC Cache Control as a dependency to your project.

#### Maven Projects

``` 
<dependency>
    <groupId>net.rossillo.mvc.cache</groupId>
    <artifactId>spring-mvc-cache-control</artifactId>
    <version>1.1.0-RELEASE</version>
    <scope>compile</scope>
</dependency>
```

#### Gradle Projects

```
compile 'net.rossillo.mvc.cache:spring-mvc-cache-control:1.1.0-RELEASE'
```

### Configuration

Simply include `net.rossillo.spring.web.mvc.CacheControlHandlerInterceptor` in your Spring MVC `-servlet.xml` file:

```
<mvc:interceptors>
    <bean class="net.rossillo.spring.web.mvc.CacheControlHandlerInterceptor" />
</mvc:interceptors>
````

### Annotate Your Controllers

Use the `@CacheControl` annoation on either (or both) type level `@Controller`s or method level `@RequestMapping`s. The handler interceptor will read the annotations and generate HTTP/1.1 complaint cache-control headers. For example:

```
@Controller
public final class DemoController {

	/**
	 * Public home page, cacheable for 5 minutes.
	 */
	@CacheControl(maxAge = 300)
	@RequestMapping({"/", "/home.do"})
	public String handleHomePageRequest(Model model) {
		...
	}
}
```

See our [spring-mvc-cache-control-demo][demo] project for full details.


## Building from Source

1. Clone the repository from GitHub:

		$ git clone git://github.com/foo4u/spring-mvc-cache-control

2. Navigate into the cloned repository directory:

		$ cd spring-mvc-cache-control

3. The project uses [Gradle][gradle] to build:

		$ ./gradlew build

## IDE Integration

### IntelliJ IDEA

IDEA 13+ natively support Gralde projects. Simply choose to import an existing project and select
the build.gradle file. Tick the checkbox to use the Gradle wrapper.

### Eclipse

To generate Eclipse metadata (.classpath and .project files), use the following Gradle task:

	$ ./gradlew eclipse

Once complete, you may then import the projects into Eclipse as usual:

	File -> Import -> Existing projects into workspace

## JavaDoc

Use the following Gradle task to build the JavaDoc

	$ ./gradlew javadoc
	
_Note: The result will be available in 'spring-mvc-cache-control/build/docs/javadoc'._
	
## Contributing

Contributions are always welcome. Fork the repository, create a topic branch and send a pull request.


[spring_mvc]: http://static.springsource.org/spring/docs/current/spring-framework-reference/html/mvc.html
[gradle]: http://gradle.org/
[demo]: https://github.com/foo4u/spring-mvc-cache-control/blob/master/spring-mvc-cache-control-demo/src/main/java/net/rossillo/spring/web/mvc/demo/DemoController.java
[status]: https://circleci.com/gh/foo4u/spring-mvc-cache-control.png?circle-token=2671c269c8ab085fb58617d58167ffe45bc70aac
