package com.juaracoding.apitest.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationTest {

  @Given("User is on the registration page")
  public void step01() {
    System.out.println("RegistrationTest:step01");
  }

  @When("User type first name {string}")
  public void step02(String firstName) {
    System.out.println("FIRST NAME: " + firstName);
  }

  @And("User type last name {string}")
  public void step03(String lastName) {
    System.out.println("LAST NAME: " + lastName);
  }

  @And("User type email {string}")
  public void step04(String email) {
    System.out.println("EMAIL: " + email);
  }

  @And("User type password {string}")
  public void step05(String password) {
    System.out.println("PASSWORD: " + password);
  }

  @And("User submits the registration form")
  public void step06() {
    System.out.println("RegistrationTest:step06");
  }

  @Then("User should see a success message")
  public void step07() {
    System.out.println("RegistrationTest:step07");
  }
}
