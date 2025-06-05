package com.juaracoding.apitest.definitions;

import org.hamcrest.CoreMatchers;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class APIGroupListTest {
  RequestSpecification requestSpecification;
  Response response;
  ValidatableResponse validatableResponse;

  @Before
  public void setup() {
    RestAssured.baseURI = "http://localhost:8000";
  }

  @Given("Preparing header for authorization")
  public void prepareHeader() {
    System.out.println("APIGroupListTest::prepareHeader");
    requestSpecification = RestAssured.given().header(
        "Authorization",
        "Token bb25b29c69616918e77620148a1d01dcbeeb7a56");
  }

  @When("I access group with credential")
  public void accessGroups() {
    System.out.println("APIGroupListTest::accessGroups");
    response = requestSpecification.when()
        .get("/catalogs/groups/");
  }

  @Then("I received response from the server")
  public void receivedFromServer() {
    System.out.println("APIGroupListTest::receivedFromServer");
    response.then()
        .statusCode(200)
        .statusLine("HTTP/1.1 200 OK")
        .body("count", CoreMatchers.instanceOf(Integer.class))
        .body("next", CoreMatchers.anyOf(CoreMatchers.nullValue(),
            CoreMatchers.instanceOf(String.class)));
  }
}
