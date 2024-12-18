package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends Utility {
    private static final Logger log = LogManager.getLogger(DashboardPage.class.getName());
    
    
    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-topbar-header-title']//h6")
    WebElement dashboardTitle;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-brand-banner']//img")
    WebElement logo;

    @CacheLookup
    @FindBy(xpath = "//img[@class='oxd-userdropdown-img']")
    WebElement userProfile;

    @CacheLookup
    @FindBy(linkText = "Logout")
    WebElement logOut;

    public String getDashboardTitle() {
        log.info("get the Dashboard page title " + dashboardTitle.toString());
        return getTextFromElement(dashboardTitle);
    }

    public boolean verifyLogoDisplayed() {
        log.info("Verify the logo is displayed " + logo.toString());
        return logo.isDisplayed();
    }

    public void clickOnUserProfileImage() {
        clickOnElement(userProfile);
        log.info("Click on user profile image " + userProfile.toString());
    }

    public void mouseHoverOnLogOutLinkAndClick() {
        mouseHoverToElementAndClick(logOut);
        log.info("Click on logout link " + logOut.toString());
    }

}
