package com.juaracoding.apitest.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class APIGroupCreateTest {

  @When("I post data payload to server")
  public void requestToServer() {
    System.out.println("APIGroupCreateTest::requestToServer()");
  }

  @Then("I received response 201 from the server")
  public void receivedFromServer() {
    System.out.println("APIGroupCreateTest::receivedFromServer()");
  }
}
