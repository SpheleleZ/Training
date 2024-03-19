Feature: User Login

# Registered user should be able to login to access Adactin Hotel

  Background:
    Given User navigate to login page "https://adactinhotelapp.com/HotelAppBuild2/" build two

  @login
  Scenario Outline: Login with valid credentials
    When User enters valid username <username>
    And Enters valid password <password>
    And Click on login button
    Then User should login successfully

    Examples:
      | username  | password   |
      | SpheleleZ | Nok2lasphe |


  @login
  Scenario Outline: Login with invalid credentials
    When User enters invalid username <username>
    And Enters invalid password <password>
    And Click on login button
    Then User should get a proper warning message

    Examples:
      | username  | password      |
      | Sphelele  | Nok2laSphe123 |
      | SpheleleZ | bow wow       |