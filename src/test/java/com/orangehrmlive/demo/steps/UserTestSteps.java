package com.orangehrmlive.demo.steps;

import com.orangehrmlive.demo.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class UserTestSteps {

    @When("I enter username {string} and password {string} for log in")
    public void iEnterUsernameAndPasswordForLogIn(String uName, String pass) {
        new LoginPage().enterUserNameAndPasswordForLogin(uName, pass);
    }

    @And("I click on Admin tab")
    public void iClickOnAdminTab() {
        new SideMenuPage().clickOnTab("Admin");
    }

    @And("I should see the System Users text")
    public void iShouldSeeTheSystemUsersText() {
        Assert.assertEquals(new AdminPage().getPageTitle(), "System Users");
    }

    @And("I click on Add button")
    public void iClickOnAddButton() {
        new AdminPage().clickOnAddButton();
    }

    @And("I should see the Add User text")
    public void iShouldSeeTheAddUserText() {
        Assert.assertEquals(new AddUserPage().getAdduserPageTitle(), "Add User");
    }

    @And("I select User Role as {string}")
    public void iSelectUserRoleAs(String role) {
        new AddUserPage().selectUserRoleDropdown(role);
    }

    @And("I enter Employee Name {string}")
    public void iEnterEmployeeName(String empName) throws InterruptedException {
        new AddUserPage().enterEmployeeName(empName);
    }

    @And("I enter User Name {string}")
    public void iEnterUserName(String uName) {
        new AddUserPage().enterUserName(uName);
    }

    @And("I select Status from dropdown as {string}")
    public void iSelectStatusFromDropdownAs(String status) {
        new AddUserPage().selectStatusDropdown(status);
    }

    @And("I enter Password {string} in create user")
    public void iEnterPasswordInCreateUser(String pass) {
        new AddUserPage().enterPassword(pass);
    }

    @And("I enter Confirm Password {string} in create User")
    public void iEnterConfirmPasswordInCreateUser(String cPass) {
        new AddUserPage().enterConfirmPassword(cPass);
    }

    @And("I click on Save button")
    public void iClickOnSaveButton() {
        new AddUserPage().clickOnSaveButton();
    }

    @Then("I should see the message {string}")
    public void iShouldSeeTheMessage(String msg) {
        Assert.assertEquals(new AddUserPage().getSuccessMessage(), "Successfully Saved");
    }

//************************************************************************************

    @And("I enter user name {string} in system users page")
    public void iEnterUserNameInSystemUsersPage(String uName) {
        new AdminPage().enterUserName(uName);
    }

    @And("I select user role as {string} in system users page")
    public void iSelectUserRoleAsInSystemUsersPage(String role) {
        new AdminPage().selectUserRoleFromDropdown(role);
    }

    @And("I select status as {string} in system users page")
    public void iSelectStatusAsInSystemUsersPage(String status) {
        new AdminPage().selectStatusFromDropdown(status);
    }

    @And("I click on search button")
    public void iClickOnSearchButton() {
        new AdminPage().clickOnSearchButton();
    }

    @Then("I should verify the user name {string} in result list")
    public void iShouldVerifyTheUserNameInResultList(String uName) {
        Assert.assertEquals(new AdminPage().getUsernameFromSearchResult(), uName);
    }

    //***************************************************************************

    @And("I click on check box against the user name")
    public void iClickOnCheckBoxAgainstTheUserName() {
        new AdminPage().selectTheCheckboxOfUserNameResult();
    }

    @And("I click on delete button against the user name")
    public void iClickOnDeleteButtonAgainstTheUserName() {
        new AdminPage().clickOnDeleteButtonInList();
    }

    @And("I click on ok button on popup")
    public void iClickOnOkButtonOnPopup() {
        new AdminPage().clickOnYesDeleteButtonOnPopUp();
    }

    @Then("I should get successfully deleted message {string}")
    public void iShouldGetSuccessfullyDeletedMessage(String msg) {
        Assert.assertEquals(new ViewSystemUserPage().getSuccessDeleteMessage(), msg);
    }

    //******************************************************************

    @And("I see the one record found {string} message")
    public void iSeeTheOneRecordFoundMessage(String msg) {
        Assert.assertEquals(new AdminPage().getRecordsFound(), msg);
    }

    @Then("I click on reset button")
    public void iClickOnResetButton() {
        new AdminPage().clickOnResetButton();
    }
}
