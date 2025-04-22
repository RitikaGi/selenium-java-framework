 
@tag
Feature: Error Validation

  @tag2
  Scenario Outline: Negative test of log in to the application
    Given I landed on Ecommerce Page
    When Logged in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed

    Examples: 
      | name                  | password     | 
      |keshu@gmail.com        | Keshrit@123   |
