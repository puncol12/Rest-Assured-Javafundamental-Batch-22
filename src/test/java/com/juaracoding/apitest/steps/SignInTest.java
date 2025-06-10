package com.juaracoding.apitest.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignInTest {

  @Given("User is on the signin page")
  public void step01() {
    System.out.println("SignInTest::step01");
  }

  @When("User enters valid username and password")
  public void step02() {
    System.out.println("SignInTest::step02");
  }

  @And("User clicks the signin button")
  public void step03() {
    System.out.println("SignInTest::step03");
  }

  @Then("User should be redirected to the homepage")
  public void step04() {
    System.out.println("SignInTest::step04");
  }

}
