package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseraSignupPage extends BasePage {
    private Logger logger = getLogger();

    @FindBy(name = "name")
    private WebElement usernameInput;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(css = "[data-track-component='signup_form_submit_button']")
    private WebElement submitButton;

    @FindBy(css = "div[style^='visibility: visible;']")
    private WebElement recaptchaWindow;

    @FindBy(css = "span a[href='/about/terms']")
    private WebElement termsOfUseLink;

    @FindBy(css = "span a[href='/about/privacy']")
    private WebElement privacyNoticeLink;

    @Override
    public void openPage() {
    }

    public void signUp(final String username, final String email, final String password) {
        inputUsername(username);
        inputEmail(email);
        inputPassword(password);
        clickSubmitButton();
    }

    private void inputUsername(final String username) {
        logger.info("enter username: {}", username);
        usernameInput.sendKeys(username);
    }

    private void inputEmail(final String email) {
        logger.info("enter email: {}", email);
        emailInput.sendKeys(email);
    }

    private void inputPassword(final String password) {
        logger.info("enter password: {}", password);
        passwordInput.sendKeys(password);
    }

    private void clickSubmitButton() {
        logger.info("click submit button");
        submitButton.click();
    }

    public WebElement getRecaptchaWindow() {
        logger.info("get recaptcha window");
        return recaptchaWindow;
    }

    public void clickTermsOfUseLink() {
        logger.info("click terms of use link");
        termsOfUseLink.click();
    }

    public void clickPrivacyNoticeLink() {
        logger.info("click privacy notice link");
        privacyNoticeLink.click();
    }
}
