package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AddUserPage extends Utility {

    private static final Logger log = LogManager.getLogger(AddUserPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//div[@class='orangehrm-card-container']/h6")
    WebElement pageTitle;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='User Role']/parent::div/following-sibling::div//div[@class='oxd-select-wrapper']")
    WebElement selectUserRoleDropdown;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Employee Name']/parent::div/following-sibling::div//input")
    WebElement employeeName;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-autocomplete-text-input--after']")
    WebElement employeeNameAutoComplete;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Username']/parent::div/following-sibling::div//input")
    WebElement userName;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Status']/parent::div/following-sibling::div//div[@class='oxd-select-wrapper']")
    WebElement selectStatusDropdown;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
    WebElement password;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
    WebElement confirmPassword;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement saveButton;

    @CacheLookup
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
    WebElement successMessage;

    public String getAdduserPageTitle(){
        log.info("Get Add User text "+pageTitle.toString());
        return getTextFromElement(pageTitle);
    }

    public void selectUserRoleDropdown(String role){
        mouseHoverToElementAndClick(selectUserRoleDropdown);
        typeKeysAndEnter(role.split("")[0]);
        log.info("Select User roles "+selectUserRoleDropdown.toString()+" as "+role);
    }
    public void enterEmployeeName(String empName) throws InterruptedException {
        sendTextToElement(employeeName, empName);
        Thread.sleep(5000);
        selectAutoPopulateFirstEntryByArrowKeysAndEnter(employeeName);
        log.info("Enter the Employee Name "+employeeName.toString()+" as "+empName);
    }

    public void enterUserName(String uName){
        sendTextToElement(userName, uName);
        log.info("Enter the Username "+userName.toString()+" as "+uName);
    }

    public void selectStatusDropdown(String status){
        mouseHoverToElementAndClick(selectStatusDropdown);
        typeKeysAndEnter(status.split("")[0]);
        log.info("Select Status "+selectStatusDropdown.toString()+" as "+status);
    }

    public void enterPassword(String pwd){
        sendTextToElement(password,pwd);
        log.info("Enter password "+password.toString());
    }

    public void enterConfirmPassword(String cpwd){
        sendTextToElement(confirmPassword,cpwd);
        log.info("Enter password confirmation "+confirmPassword.toString());
    }
    public void clickOnSaveButton(){
        clickOnElement(saveButton);
        log.info("Click on Save button"+saveButton.toString());
    }

    public String getSuccessMessage(){
        log.info("get success message "+successMessage.toString());
        return getTextFromElement(waitForElementWithFluentWait(successMessage,10,2));
    }
}
