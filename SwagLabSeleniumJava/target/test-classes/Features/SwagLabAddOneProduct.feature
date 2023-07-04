@Functionality
Feature: Swag Labs Add One Product Functionality

  Background: 
    Given User has opened Swag Labs on the browser add product functionality
    Given User has navigated to Swag Labs URL add product functionality

  @TCID001
  Scenario Outline: Add one product to cart page
    When User enter valid <username> and <password> add product functionality
    And User click the login button on valid case add product functionality
    Then Showing Swag Labs title at the top of the page add product functionality
    When User clicks the Add to Cart button on the inventory page add product functionality
    Then User should see the added product in the cart page with the corresponding details add product functionality
    When User clicks the cart icon on the inventory page add product functionality
    Then User will be redirected to the cart page add product functionality
    And User should see the details of the previously added product, including the product name, product description, and product price add product functionality


    Examples: 
      | username      | password     |
      | standard_user | secret_sauce |
