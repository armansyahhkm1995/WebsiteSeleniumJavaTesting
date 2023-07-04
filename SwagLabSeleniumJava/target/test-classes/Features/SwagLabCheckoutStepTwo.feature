@Functionality
Feature: Swag Labs Checkout Step Two Functionality

  Background: 
    Given User opens the browser Step Two Functionality
    And User navigates to the Swag Labs URL Step Two Functionality

  @TCID001
  Scenario Outline: Verify Checkout Step Two
    When User enters <username> and <password> Step Two Functionality
    And User clicks the login button Step Two Functionality
    When User clicks the Add to Cart button on the inventory page Step Two Functionality
    Then User should see the added product in the cart page with the corresponding details Step Two Functionality
    When User clicks the cart icon on the inventory page Step Two Functionality
    Then User will be redirected to the cart page Step Two Functionality
    And User should see the details of the previously added product, including the product name, product description, and product price Step Two Functionality
    When User clicks on the checkout button Step Two Functionality
    Then User should be redirected to the checkout page Step Two Functionality
    And User fills the first name form Step Two Functionality
    And User fills the last name form  Step Two Functionality
    And User fills the postal code form Step Two Functionality
    And User clicks continue buttonStep Two Functionality
    Then User will be redirected to the checkout overview page Step Two Functionality
    And User should see the details of the previously added product but in checkout step two page, including the product name, product description, and product price Step Two Functionality
    And User should see the details of the previously added product, including the payment information, shipping information, price total, and total Step Two Functionality
    And User click on finish button Step Two Functionality
    Then User should see thank you for your order page Step Two Functionality
    And User click back to home button Step Two Functionality
    
    
    Examples: 
      | username      | password     |
      | standard_user | secret_sauce |
    

