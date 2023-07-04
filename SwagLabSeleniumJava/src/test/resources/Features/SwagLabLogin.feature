@Functionality
Feature: Swag Labs Login Functionality

  Background: 
    Given User has opened Swag Labs on the browser login functionality
    Given User has navigated to Swag Labs URL login functionality

  @TCID001
  Scenario Outline: Verify valid Swag Labs login
    When User enter valid <username> and <password> login functionality
    And User click the login button on valid case login functionality
    Then Showing Swag Labs title at the top of the page login functionality

    Examples: 
      | username      | password     |
      | standard_user | secret_sauce |

  @TCID002
  Scenario Outline: Verify invalid Swag Labs login
    When User enter invalid <username> and <password> login functionality
    And User click the login button on invalid case login functionality
    Then Showing Epic sadface: Sorry, this user has been locked out login functionality

    Examples: 
      | username        | password     |
      | locked_out_user | secret_sauce |

  @TCID003
  Scenario Outline: Verify problem Swag Labs login
    When User enter problem <username> and <password> login functionality
    And User click the login button on problem case login functionality
    Then The image is not show-up login functionality

    Examples: 
      | username     | password     |
      | problem_user | secret_sauce |

