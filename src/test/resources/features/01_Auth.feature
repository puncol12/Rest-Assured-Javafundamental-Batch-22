Feature: Auth Functionality

  @SignIn @SmokeTest @Web
  Scenario: Successful SignIn with valid credentials
    Given User is on the signin page
    When User enters valid username and password
    And User clicks the signin button
    Then User should be redirected to the homepage

  @Registration @Mobile @SmokeTest
  Scenario Outline: Successful user registration
    Given User is on the registration page
    When User type first name "<firstName>"
    And User type last name "<lastName>"
    And User type email "<email>"
    And User type password "<password>"
    And User submits the registration form
    Then User should see a success message

    Examples:
      | firstName | lastName  | email          | password |
      | Budi      | Wicaksono | budi@mail.com  |   123qwe |
      | Santi     | Sintia    | santi@mail.com |   456qwe |
