Feature: As a grumpy product owner, I want to be able to register users

  Scenario: A valid user should be registered
    Given I have a valid user
    When I register that user
    Then The user should be registered