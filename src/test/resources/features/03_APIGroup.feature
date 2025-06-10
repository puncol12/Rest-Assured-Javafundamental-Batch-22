Feature: API Group 
  Background:
    Given Preparing header for authorization

  @High
  Scenario: Get all group from catalogs
    When I access group with credential
    Then I received response from the server
  
  @NewSubfeature
  Scenario: Create group with payload
    When I post data payload to server
    Then I received response 201 from the server