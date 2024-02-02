# Code Snippets

## Spring Boot Testcontainers integration before 3.1.0
```java
@SpringBootTest
@Testcontainers
class ProductControllerTests {

    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine");

    @DynamicPropertySource
    static void overrideProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgresqlContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgresqlContainer::getUsername);
        registry.add("spring.datasource.password", postgresqlContainer::getPassword);
    }
    ...
    ...
}
```


## Spring Boot Testcontainers integration from 3.1.0+

```java
@SpringBootTest
@Testcontainers
class ProductControllerTests {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine");

    ...
    ...
}
```


## Spring Boot Testcontainers Local Development Support

```java
@TestConfiguration(proxyBeanMethods = false)
public class TestApplication {

    @Bean
    @ServiceConnection
    PostgreSQLContainer<?> postgresContainer() {
        return new PostgreSQLContainer<>("postgres:16-alpine");
    }

	public static void main(String[] args) {
		SpringApplication
				.from(Application::main)
				.with(TestApplication.class)
				.run(args);
	}

}
```

## JdbcClient

```java
@Repository
@Transactional(readOnly = true)
public class BookmarkRepository {
private final JdbcClient jdbcClient;

    public Optional<Bookmark> findById(Long id) {
        String sql = "select id, title, url, created_at from bookmarks where id = :id";
        return jdbcClient.sql(sql).param("id", id).query(Bookmark.class).optional();
    }

    @Transactional
    public Long save(Bookmark bookmark) {
        String sql = """
                    insert into bookmarks(title, url, created_at)
                    values(:title,:url,:createdAt) returning id
                    """;
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcClient.sql(sql)
                .param("title", bookmark.title())
                .param("url", bookmark.url())
                .param("createdAt", Timestamp.from(bookmark.createdAt()))
                .update(keyHolder);
        return keyHolder.getKeyAs(Long.class);
    }
}
```

## RestClient

```java
RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com");

User getUserById(int id) {
    return restClient.get()
        .uri("/users/{id}", id)
        .accept(APPLICATION_JSON)
        .retrieve()
        .body(User.class);
}

User createUser(User user) {
    return restClient.post()
        .uri("/users")
        .contentType(APPLICATION_JSON)
        .body(user)
        .retrieve()
        .body(User.class);
}
```

## Declarative HTTP Client

```java
public interface JsonPlaceHolderHttpClient {
    @GetExchange("/users/{id}")
    User findUserById(@PathVariable Integer id);
}

@Configuration
class AppConfig {

    @Bean
    JsonPlaceHolderHttpClient jsonPlaceholderService(RestClient restClient) {
        HttpServiceProxyFactory factory = 
             HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(restClient))
                .build();
        return factory.createClient(JsonPlaceHolderHttpClient.class);
    }
}

@Autowired
JsonPlaceHolderHttpClient client;

User user = client.findUserById(1);
```


## Spring Boot GraalVM Native Image

```
Maven:

<plugin>
  <groupId>org.graalvm.buildtools</groupId>
  <artifactId>native-maven-plugin</artifactId>
</plugin>

$ mvn -Pnative spring-boot:build-image
------------------------------------------------------
Gradle:

plugins {
...
id 'org.graalvm.buildtools.native' version '0.9.28'
}

$ gradle bootBuildImage
```