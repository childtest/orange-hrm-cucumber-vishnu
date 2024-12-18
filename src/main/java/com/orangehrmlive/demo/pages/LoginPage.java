package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Utility {
    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//h5[normalize-space()='Login']")
    WebElement title;

    @CacheLookup
    @FindBy(xpath = "//input[@name='username']")
    WebElement userName;

    @CacheLookup
    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='orangehrm-login-slot-wrapper']//div[1]//div[1]//span[1]")
    WebElement errorRequiredOfUsername;

    @CacheLookup
    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
    WebElement errorRequiredOfPassword;

    @CacheLookup
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    WebElement errorOfInvalidCredentials;

    public String getLoginPageTitle() {
        log.info("get login page title");
        return getTextFromElement(title);
    }

    public void enterUsername(String uName) {
        sendTextToElement(userName, uName);
        log.info("enter user name :" + uName);

    }

    public void enterPassword(String pass) {
        sendTextToElement(password, pass);
        log.info("enter password" + pass);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
        log.info("click on " + loginButton);
    }

    public void enterUserNameAndPasswordForLogin(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickOnLoginButton();
    }

    public String getErrorMessageRequiredOfUsername() {
        log.info("get error message " + errorRequiredOfUsername);
        return getTextFromElement(errorRequiredOfUsername);
    }

    public String getErrorMessageRequiredOfPassword() {
        log.info("get error message " + errorRequiredOfPassword);
        return getTextFromElement(errorRequiredOfPassword);
    }

    public String getErrorMessageOfInvalidCredentials() {
        log.info("get error message " + errorOfInvalidCredentials);
        return getTextFromElement(errorOfInvalidCredentials);
    }
}
