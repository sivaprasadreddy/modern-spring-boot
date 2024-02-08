# Modern Spring Boot Application Development

* Explore some new Java 17/21 features such as **Records**, **Text Blocks**, **Type Inference using var**, etc.
* Build a sample Spring Boot application demonstrating the following features:
  * Testcontainers Support
  * JdbcClient
  * RestClient
  * HTTP Interfaces
  * GraalVM Native Image Support

## Run application

```shell
$ ./mvnw spring-boot:test-run
```

## Run application using Docker Compose in JVM mode

```shell
$ ./mvnw spring-boot:build-image
$ docker compose up --build -d
$ docker compose logs -f
```

## Run application using Docker Compose in GraalVM Native mode

```shell
$ ./mvnw -Pnative spring-boot:build-image
$ docker compose up --build -d
$ docker compose logs -f
```

## References
* [Spring Boot Testcontainers Support](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.testing.testcontainers)
* [Testcontainers](https://www.testcontainers.com/)
* [Testcontainers Desktop](https://testcontainers.com/desktop/)
* [Testcontainers Guides](https://testcontainers.com/guides/)
* [JdbcClient Tutorial](https://www.sivalabs.in/spring-boot-jdbcclient-tutorial/)
* [REST Clients](https://docs.spring.io/spring-framework/reference/integration/rest-clients.html)
* [RestClient](https://spring.io/blog/2023/07/13/new-in-spring-6-1-restclient)
* [HTTP Interfaces](https://docs.spring.io/spring-framework/reference/integration/rest-clients.html#rest-http-interface)
* [GraalVM Native Image Support](https://docs.spring.io/spring-boot/docs/current/reference/html/native-image.html)
