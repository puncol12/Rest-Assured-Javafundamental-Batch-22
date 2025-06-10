@NewFeature
Feature: Checkout Process
  @Checkout @SmokeTest
  Scenario: Successful checkout with valid payment details
    Given User has items in the cart
    When User proceeds to checkout
    And User enters valid payment details
    And User confirms the order
    Then User should see an order confirmation message