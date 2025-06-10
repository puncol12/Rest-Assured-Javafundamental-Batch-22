package com.juaracoding.apitest.steps;

import io.cucumber.java.en.Given;

public class APIBackgroundTest {
  @Given("Preparing header for authorization")
  public void prepareHeader() {
    System.out.println("APIBackgroundTest::prepareHeader()");
  }

  // @When("User type last name {string}")
  // public void User_type_last_name(String s) {
  // // Write code here that turns the phrase above into concrete actions
  // }
}
