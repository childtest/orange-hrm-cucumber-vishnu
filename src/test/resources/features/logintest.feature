@regression
Feature: Login

  As a user
  I want check login functionality

  Background: I am on HomePage

  @sanity
  Scenario: User should log in successfully with valid credentials
    When I enter username "Admin" and password "admin123" for log in
    Then I should login successfully and verify the text "Dashboard"

  @smoke
  Scenario: User should see the OrangeHRM logo on the Homepage
    When I enter username "Admin" and password "admin123" for log in
    Then I should see the OrangeHRM logo

  @aaa
  Scenario: User should logout successfully
    When I enter username "Admin" and password "admin123" for log in
    And I click on user profile logo
    And I mouse hover and click on Logout
    Then I should navigate to login page and verify "Login" text


  Scenario Outline: : User should get error message with invalid credentials
    When I enter username "<username>" and password "<password>" for log in
    Then I should get error message "<errorMessage>" depends on "<username>" and "<password>"
    Examples:
      | username          | password | errorMessage        |
      |                   |          | Required            |
      | test123@gmail.com |          | Required            |
      |                   | test123  | Required            |
      | test123@gmail.com | test123  | Invalid credentials |

