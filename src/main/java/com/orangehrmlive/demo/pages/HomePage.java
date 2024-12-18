package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Utility {
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
    WebElement userProfileImage;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement logoutButton;

    public boolean verifyUserProfileIsDisplayed() {
        log.info("verify user profile image is displayed  " + userProfileImage);
        return userProfileImage.isDisplayed();
    }

    public void clickOnLogoutButton() {
        clickOnElement(logoutButton);
        log.info("click on " + logoutButton);
    }
}
