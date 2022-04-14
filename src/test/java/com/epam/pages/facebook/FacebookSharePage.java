package com.epam.pages.facebook;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.TabsSwitcher;
import com.epam.service.UsersManager;
import com.epam.core.utilities.service.WaitersService;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookSharePage extends BasePage {
    private static final String TEXT_TO_SEARCH = "coursera.org";
    private Logger logger = getLogger();

    @FindBy(xpath = "//span[contains(text(),'Facebook')]")
    private WebElement shareOnFacebookButton;

    @FindBy(xpath = "//button[contains(.,'Facebook')]")
    private WebElement postButton;

    @FindBy(id = "email")
    private WebElement inputEmail;

    @FindBy(id = "pass")
    private WebElement inputPassword;

    @FindBy(name = "login")
    private WebElement loginButton;

    @Override
    protected void openPage() {
    }

    public void shareOnFacebook() {
        WaitersService.waitForElementToBeClickable(getDriver(), shareOnFacebookButton);
        logger.info("share on facebook");
        getActions().moveToElement(postButton).click().build().perform();
        WaitersService.waitUntilPageIsCompletelyLoaded(getDriver());
        WaitersService.waitUntilUrlContains(getDriver(), TEXT_TO_SEARCH);
    }

    public void goToFacebook() {
        ((JavascriptExecutor) getDriver()).executeScript("window.open('https://www.facebook.com/', '_blank');");
        TabsSwitcher.switchToNewTab(getDriver());
        WaitersService.waitUntilPageIsCompletelyLoaded(getDriver());
    }

    public void clickOnUser(final String username) {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + username + "')]")).click();
    }

    public boolean checkFacebookPost() {
        while (!getDriver().getPageSource().contains(TEXT_TO_SEARCH)) {
            getDriver().navigate().refresh();
        }
        return getDriver().getPageSource().contains(TEXT_TO_SEARCH);
    }

    public void logInFacebookViaFacebookPage() {
        inputEmail.sendKeys(UsersManager.getSecondFacebookUser().getEmail());
        inputPassword.sendKeys(UsersManager.getSecondFacebookUser().getPassword());
        loginButton.click();
    }
}
