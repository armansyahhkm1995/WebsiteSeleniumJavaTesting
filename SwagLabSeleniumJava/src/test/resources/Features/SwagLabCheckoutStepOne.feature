@Functionality
Feature: Swag Labs Checkout Step One Functionality

  Background: 
    Given User opens the browser
    And User navigates to the Swag Labs URL

  @TCID001
  Scenario Outline: Verify checkout Step One
    When User enters valid <username> and <password>
    And User clicks the login button
    When User clicks the Add to Cart button on the inventory page
    Then User should see the added product in the cart page with the corresponding details
    When User clicks the cart icon on the inventory page
    Then User will be redirected to the cart page
    And User should see the details of the previously added product, including the product name, product description, and product price
    When User clicks on the checkout button
    Then User should be redirected to the checkout page
    And User fills the first name form 
    And User fills the last name form 
    And User fills the postal code form 
    And User clicks continue button
    Then User will be redirected to the checkout overview page
    
    
    Examples: 
      | username      | password     |
      | standard_user | secret_sauce |
    

