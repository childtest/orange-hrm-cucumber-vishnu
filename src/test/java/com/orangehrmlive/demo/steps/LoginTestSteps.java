package com.orangehrmlive.demo.steps;

import com.orangehrmlive.demo.pages.DashboardPage;
import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.Objects;

public class LoginTestSteps {

    @Then("I should login successfully and verify the text {string}")
    public void iShouldLoginSuccessfullyAndVerifyTheText(String title) {
        Assert.assertEquals(new DashboardPage().getDashboardTitle(), title);
    }

    //*******************************************************

    @Then("I should see the OrangeHRM logo")
    public void iShouldSeeTheOrangeHRMLogo() {
        Assert.assertTrue(new HomePage().verifyUserProfileIsDisplayed());
    }

    //***********************************************************

    @And("I click on user profile logo")
    public void iClickOnUserProfileLogo() {
        new DashboardPage().clickOnUserProfileImage();
    }

    @And("I mouse hover and click on Logout")
    public void iMouseHoverAndClickOnLogout() {
        new DashboardPage().mouseHoverOnLogOutLinkAndClick();
    }

    @Then("I should navigate to login page and verify {string} text")
    public void iShouldNavigateToLoginPageAndVerifyText(String text) {
        Assert.assertEquals(new LoginPage().getLoginPageTitle(), text);
    }

    @Then("I should get error message {string} depends on {string} and {string}")
    public void iShouldGetErrorMessageDependsOnAnd(String errMsg, String uName, String pass) {
        if (Objects.equals(uName, "")) {
            Assert.assertEquals(new LoginPage().getErrorMessageRequiredOfUsername(), errMsg);
        } else if (Objects.equals(pass, "")) {
            Assert.assertEquals(new LoginPage().getErrorMessageRequiredOfPassword(), errMsg);
        } else {
            Assert.assertEquals(new LoginPage().getErrorMessageOfInvalidCredentials(), errMsg);
        }
    }
}
