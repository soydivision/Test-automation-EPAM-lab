package com.epam.pages.coursera;

import com.epam.core.model.User;
import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.WaitersService;
import com.epam.core.utilities.service.WindowsService;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.Set;

public class CourseraLoginPage extends BasePage {
    private Logger logger = getLogger();

    @FindBy(xpath = "//button[contains(@data-track-component,'continue_with_google')]")
    private WebElement googleButton;

    @FindBy(id = "identifierId")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(id = "email")
    private WebElement facebookEmailInput;

    @FindBy(id = "pass")
    private WebElement facebookPasswordInput;

    @FindBy(xpath = "//button[contains(@data-track-component,'continue_with_facebook')]")
    private WebElement facebookButton;

    @FindBy(xpath = "//*[@data-track-component='login_form_forgot_password_link']")
    private WebElement forgotPasswordButton;

    @FindBy(xpath = "//*[@id='email-input'] | //*[@id='email']")
    private WebElement bothRegistrationEmailInputs;

    @FindBy(xpath = "//button[contains(@data-track-component,'reset_page_button')]")
    private WebElement resetPasswordButton;

    @Override
    public void openPage() {
    }

    public void loginWithGoogleAccount(final String email, final String password) {
        String originalWindow = getDriver().getWindowHandle();
        Set<String> windowsSet = getDriver().getWindowHandles();
        googleButton.click();
        String newWindow = WindowsService.getNewWindowHandle(getDriver(), windowsSet);
        getDriver().switchTo().window(newWindow);
        logger.info("log in with email: {}, password: {}", email, password);
        emailInput.sendKeys(email + Keys.ENTER);
        passwordInput.sendKeys(password + Keys.ENTER);
        getDriver().switchTo().window(originalWindow);
    }

    public void loginWithGoogleAccount(final User user) {
        loginWithGoogleAccount(user.getEmail(), user.getPassword());
    }

    public void loginWithFacebookAccount(final String email, final String password) {
        String originalWindow = getDriver().getWindowHandle();
        Set<String> windowsSet = getDriver().getWindowHandles();
        facebookButton.click();
        String newWindow = WindowsService.getNewWindowHandle(getDriver(), windowsSet);
        getDriver().switchTo().window(newWindow);
        facebookEmailInput.sendKeys(email + Keys.TAB);
        facebookPasswordInput.sendKeys(password + Keys.ENTER);
        getDriver().switchTo().window(originalWindow);
        logger.info("logged in with email: " + email + ", password: " + password + ", using Facebook account");
        WaitersService.waitUntilPageIsCompletelyLoaded(getDriver());
    }

    public void loginWithFacebookAccount(final User user) {
        loginWithFacebookAccount(user.getEmail(), user.getPassword());
    }

    public void clickForgotPassword() {
        logger.info("forgotPasswordButton clicked");
        forgotPasswordButton.click();
    }

    public void inputRegistrationEmail(final String email) {
        logger.info("inputRegistrationEmail form input executed");
        bothRegistrationEmailInputs.sendKeys(email);
    }

    public void sendEmailToRecoverPassword() {
        getActions().moveToElement(resetPasswordButton).click().build().perform();
        logger.info("sendEmailToRecoverPassword button pressed");
    }
}
