package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends Utility {
    private static final Logger log = LogManager.getLogger(AddUserPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//h5")
    WebElement title;

    @CacheLookup
    @FindBy(xpath = "//li[@class='oxd-topbar-body-nav-tab --parent --visited']")
    WebElement userManagement;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement btnAdd;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Username']/parent::div/following-sibling::div//input")
    WebElement userName;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='User Role']/parent::div/following-sibling::div//div[@class='oxd-select-wrapper']")
    WebElement userRollDropDown;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Status']/parent::div/following-sibling::div//div[@class='oxd-select-wrapper']")
    WebElement statusDropDown;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Search']")
    WebElement btnSearch;

    @CacheLookup
    @FindBy(xpath = "//div[@role='columnheader'or normalize-space()='Username'][2]/ancestor::div[@role='rowgroup']/following-sibling::div[@class='oxd-table-body']//div[@class='oxd-table-cell oxd-padding-cell'][2]")
    WebElement searchedUserInList;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-table-card-cell-checkbox']//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']")
    WebElement cbForSearchResultItem;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Delete Selected']")
    WebElement btnDeleteInResultList;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
    WebElement deletePopUpButtonYes;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Employee Name']/parent::div/following-sibling::div//input")
    WebElement enterEmployeeName;

    @CacheLookup
    //@FindBy(xpath = "//span[normalize-space()='(1) Record Found']")
    @FindBy(xpath = "//span[@class = 'oxd-text oxd-text--span']")
    WebElement recordsFoundOfSearch;

    @CacheLookup
    @FindBy(xpath = "//div[@id='oxd-toaster_1']")
    WebElement recordsFound;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Reset']")
    WebElement resetButton;


    public String getPageTitle() {
        log.info("Get page title of : " + title.toString());
        return getTextFromElement(title);
    }

    public void clickOnUserManagement() {
        clickOnElement(userManagement);
        log.info("Click on user management Tab : " + userManagement.toString());
    }

    public void clickOnJob() {
        clickOnElement(userManagement);
        log.info("click on Job tab : " + userManagement.toString());
    }

    public void clickOnOrganization() {
        clickOnElement(userManagement);
        log.info("click on organization tab" + userManagement.toString());
    }

    public void clickOnAddButton() {
        clickOnElement(btnAdd);
        log.info("click on add button" + btnAdd.toString());
    }

    public void enterUserName(String uName) {
        sendTextToElement(userName, uName);
        log.info("Enter user name : " + uName);
    }

    public void selectUserRoleFromDropdown(String role) {
        mouseHoverToElementAndClick(userRollDropDown);
        typeKeysAndEnter(role.split("")[0]);
        log.info("select user roll from drop down as " + role);

    }

    public void selectStatusFromDropdown(String status) {
        mouseHoverToElementAndClick(statusDropDown);
        typeKeysAndEnter(status.split("")[0]);
        log.info("select user status from drop down as " + status);
    }

    public void clickOnSearchButton() {
        clickOnElement(btnSearch);
        log.info("Click on search button " + btnSearch.toString());
    }

    public String getUsernameFromSearchResult() {
        log.info("get user name from search result " + searchedUserInList.toString());
        return getTextFromElement(searchedUserInList);
    }

    public void selectTheCheckboxOfUserNameResult() {
        clickOnElement(cbForSearchResultItem);
        log.info("Click on search result item check box " + cbForSearchResultItem.toString());
    }

    public void clickOnDeleteButtonInList() {
        clickOnElement(btnDeleteInResultList);
        log.info("Click on search result item delete button " + btnDeleteInResultList.toString());
    }

    public void clickOnYesDeleteButtonOnPopUp() {
        clickOnElement(deletePopUpButtonYes);
        log.info("Click on delete popup yes button " + deletePopUpButtonYes.toString());
    }

    public void enterEmployeeName(String empName) throws InterruptedException {
        sendTextToElement(enterEmployeeName, empName);
        Thread.sleep(5000);
        selectAutoPopulateFirstEntryByArrowKeysAndEnter(enterEmployeeName);
        log.info("Enter the Employee Name "+empName);
    }

    public String getRecordsFound(){
        log.info("Get the records found. "+recordsFoundOfSearch.toString());
        return getTextFromElement(recordsFoundOfSearch);
    }

    public void clickOnResetButton(){
        clickOnElement(resetButton);
        log.info("Clicking on Reset button "+resetButton.toString());
    }

}
