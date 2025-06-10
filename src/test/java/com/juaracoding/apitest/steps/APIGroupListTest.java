package com.juaracoding.apitest.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class APIGroupListTest {
  @When("I access group with credential")
  public void accessGroups() {
    System.out.println("APIGroupListTest::accessGroups()");

  }

  @Then("I received response from the server")
  public void receivedFromServer() {
    System.out.println("APIGroupListTest::receivedFromServer()");
  }
}
