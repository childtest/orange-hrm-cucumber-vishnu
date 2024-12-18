package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ViewSystemUserPage extends Utility {
    private static final Logger log = LogManager.getLogger(ViewSystemUserPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
    WebElement successfullyDeletedMessage;

    public String getSuccessDeleteMessage() {
        log.info("get success message : " + successfullyDeletedMessage);
        return getTextFromElement(successfullyDeletedMessage);
    }

}
