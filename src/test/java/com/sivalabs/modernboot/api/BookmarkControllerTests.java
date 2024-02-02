package com.sivalabs.modernboot.api;

import com.sivalabs.modernboot.AbstractIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import static io.restassured.RestAssured.given;

@Sql("classpath:/test_data.sql")
class BookmarkControllerTests extends AbstractIntegrationTest {

    @Test
    void shouldGetAllBookmarks() {
        given()
                .when().get("/api/bookmarks")
                .then()
                .statusCode(200);
    }

    @Test
    void shouldGetBookmarkById() {
        given()
                .when().get("/api/bookmarks/1")
                .then()
                .statusCode(200);
    }

    @Test
    void shouldCreateBookmark() {
        given()
                .contentType("application/json")
                .body("""
                        {
                            "title":"test bookmark",
                            "url":"https://test.com",
                            "description":"test bookmark"
                        }
                        
                """)
                .when().post("/api/bookmarks")
                .then()
                .statusCode(201);
    }

    @Test
    void shouldUpdateBookmark() {
        given()
                .contentType("application/json")
                .body("""
                        {
                            "title":"test bookmark",
                            "url":"https://test.com",
                            "description":"test bookmark"
                        }
                        
                """)
                .when().put("/api/bookmarks/1")
                .then()
                .statusCode(200);
    }

    @Test
    void shouldDeleteBookmark() {
        given()
                .when().delete("/api/bookmarks/1")
                .then()
                .statusCode(200);
    }
}