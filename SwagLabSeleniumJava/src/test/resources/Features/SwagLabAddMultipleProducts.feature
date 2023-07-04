@Functionality
Feature: Swag Labs Add Multiple Product Functionality

  Background: 
    Given User has opened Swag Labs on the browser add products functionality
    Given User has navigated to Swag Labs URL add products functionality

  @TCID001
  Scenario Outline: Add multiple product to cart page
    When User enter valid <username> and <password> add products functionality
    And User click the login button on valid case add products functionality
    Then Showing Swag Labs title at the top of the page add products functionality
    When User clicks the Add to Cart button on the inventory page add products functionality
    Then User should see the added product in the cart page with the corresponding details add products functionality
    When User clicks another Add to Cart button on the inventory page add products functionality
    Then User should see another added product in the cart page with the corresponding details add products functionality
    When User clicks the cart icon on the inventory page add products functionality
    Then User will be redirected to the cart page add products functionality
    And User should two products with each details of the previously added product, including the product name, product description, and product price add products functionality bag
    And User should two products with each details of the previously added product, including the product name, product description, and product price add products functionality bike

    Examples: 
      | username      | password     |
      | standard_user | secret_sauce |
