@regression
Feature: User Test Features

  As a user
  I want to verify admin can execute different actions on users.

  Background:I am on Login page

  @sanity
  Scenario: Admin should add user successfully
    When I enter username "Admin" and password "admin123" for log in
    And I click on Admin tab
    And I should see the System Users text
    And I click on Add button
    And I should see the Add User text
    And I select User Role as "Admin"
    And I enter Employee Name "a"
    And I enter User Name "prime test"
    And I select Status from dropdown as "Disable"
    And I enter Password "Test123456" in create user
    And I enter Confirm Password "Test123456" in create User
    And I click on Save button
    Then I should see the message "Successfully Saved"


  @smoke
  Scenario: User created successfully and verify it
    When I enter username "Admin" and password "admin123" for log in
    And I click on Admin tab
    And I should see the System Users text
    And I enter user name "prime test" in system users page
    And I select user role as "Admin" in system users page
    And I select status as "Disable" in system users page
    And I click on search button
    Then I should verify the user name "prime test" in result list

  Scenario: Admin should delete the user successfully
    When I enter username "Admin" and password "admin123" for log in
    And I click on Admin tab
    And I should see the System Users text
    And I enter user name "prime test" in system users page
    And I select user role as "Admin" in system users page
    And I select status as "Disable" in system users page
    And I click on search button
    And I should verify the user name "prime test" in result list
    And I click on check box against the user name
    And I click on delete button against the user name
    And I click on ok button on popup
    Then I should get successfully deleted message "Successfully Deleted"

  Scenario Outline: User should search and verify the message record found
    When I enter username "Admin" and password "admin123" for log in
    And I click on Admin tab
    And I should see the System Users text
    And I enter user name "<username>" in system users page
    And I select user role as "<user role>" in system users page
    And I select status as "<status>" in system users page
    And I click on search button
    And I see the one record found "(1) Record Found" message
    And I should verify the user name "<username>" in result list
    Then I click on reset button
    Examples:
      | username    | user role | status |
      | Admin       | Admin     | Enable |
      | Orange Test | ESS       | Enable |
      | iivanov643  | ESS       | Enable |
      | Enakin      | ESS       | Enable |
