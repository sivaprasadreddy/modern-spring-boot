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