 
@tag
Feature: Purchase the order from Ecommerce Website
   
Background:
Given I landed on Ecommerce Page
@Regression
  @tag2
  Scenario Outline: Positive test of submitting the order
    Given Logged in with username <name> and password <password>
    When I add product <productName> to Cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmationPage

    Examples: 
      | name            | password       | productName  |
      | keshu@gmail.com | Keshri@123     | ZARA COAT 3  |
      
