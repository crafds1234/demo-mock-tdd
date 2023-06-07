Feature: As a grumpy product owner, I want to be able to create a todo checklist

  Scenario: Should be able to store a valid task
    Given I have a task to go to the gym
    When I add that task
    Then I should see that task in my todo list