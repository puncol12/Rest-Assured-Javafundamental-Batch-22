package com.juaracoding.apitest.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutTest {
  @Given("User has items in the cart")
  public void step01() {
    System.out.println("CheckoutTest::step01");
  }

  @When("User proceeds to checkout")
  public void step02() {
    System.out.println("CheckoutTest::step02");
  }

  @And("User enters valid payment details")
  public void step03() {
    System.out.println("CheckoutTest::step03");
  }

  @And("User confirms the order")
  public void step04() {
    System.out.println("CheckoutTest::step04");
  }

  @Then("User should see an order confirmation message")
  public void step05() {
    System.out.println("CheckoutTest::step05");
  }
}
