package com.juaracoding.apitest;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AppTest1 {

    int createdGroupId;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost:8000";
    }

    @Test
    public void getListGroup() {

        RestAssured.given().header(
                "Authorization",
                "Token bb25b29c69616918e77620148a1d01dcbeeb7a56")
                .get("/catalogs/groups/")
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .body("count", instanceOf(Integer.class))
                .body("next", anyOf(nullValue(), instanceOf(String.class)))
                .body("results", notNullValue());

    }

    @Test(dependsOnMethods = "getListGroup")
    public void creatGroup() {
        JSONObject payload = new JSONObject();
        payload.put("title", "Mobil Balap Liar");
        payload.put("origin", "Pemkot DKI Javarta");

        Response response = RestAssured
                .given()
                .header("Authorization", "Token bb25b29c69616918e77620148a1d01dcbeeb7a56")
                .contentType(ContentType.JSON)
                .body(payload.toString())
                .when()
                .post("/catalogs/groups/");

        createdGroupId = response.jsonPath().getInt("id");
    }

    @Test(dependsOnMethods = "creatGroup")
    public void updateGroup() {
        JSONObject payloadUpdate = new JSONObject();
        payloadUpdate.put("title", "Mobil Balap Liar Oleng 2");
        payloadUpdate.put("origin", "PT.TIMAH");

        RestAssured
                .given()
                .header("Authorization", "Token bb25b29c69616918e77620148a1d01dcbeeb7a56")
                .contentType(ContentType.JSON)
                .body(payloadUpdate.toString())
                .when()
                .put("/catalogs/groups/" + createdGroupId + "/")
                .then()
                .statusCode(200)
                .body("id", instanceOf(Integer.class))
                .body("title", instanceOf(String.class));
    }

    @Test(dependsOnMethods = "updateGroup")
    public void deleteGroup() {

        RestAssured
                .given()
                .header("Authorization", "Token bb25b29c69616918e77620148a1d01dcbeeb7a56")
                .when()
                .delete("/catalogs/groups/" + createdGroupId + "/")
                .then()
                .statusCode(204);
    }

    @Test(dependsOnMethods = "deleteGroup")
    public void verifyDeleteGroup() {

        RestAssured
                .given()
                .header("Authorization", "Token bb25b29c69616918e77620148a1d01dcbeeb7a56")
                .when()
                .delete("/catalogs/groups/" + createdGroupId + "/")
                .then()
                .statusCode(404);
    }
}
