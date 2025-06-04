package com.juaracoding.apitest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AppTest {

    RequestSpecification requestSpecification;
    Response response;

    @Test
    public void stepTest01() {
        RestAssured.baseURI = "http://localhost:8000";

        requestSpecification = RestAssured.given();
        requestSpecification.header(
                "Authorization",
                "Token bb25b29c69616918e77620148a1d01dcbeeb7a56");

        response = requestSpecification.get("catalogs/groups/");
        String statusLine = response.statusLine();
        int statusCode = response.statusCode();

        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
        Assert.assertEquals(statusCode, 200);
        response.prettyPrint();
    }

}
