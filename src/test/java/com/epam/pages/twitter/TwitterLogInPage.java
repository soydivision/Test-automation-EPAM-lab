package com.epam.pages.twitter;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.WaitersService;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class TwitterLogInPage extends BasePage {
    private Logger logger = getLogger();

    @FindBy(xpath = "//input[@name='session[username_or_email]']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@name='session[password]']")
    private WebElement passwordField;

    @FindBy(xpath = "//span[text()='Log in']")
    private List<WebElement> logInButtons;

    @Override
    protected void openPage() {
    }

    public void enterLoginAndPassword(final String login, final String password) {
        logger.info("Entering valid login and password");
        WaitersService.waitForVisibilityOfElement(getDriver(), loginField);
        getActions().sendKeys(loginField, login).sendKeys(passwordField, password).build().perform();
    }

    public void clickSignInButton() {
        logger.info("Clicking log in button");
        getActions().moveToElement(logInButtons.get(1)).click().build().perform();
    }
}
