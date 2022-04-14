package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.TabsSwitcher;
import com.epam.core.utilities.service.WaitersService;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CourseraUserPage extends BasePage {
    private static final int TIMEOUT = 15;
    private static final int PAUSE_TIME = 1000;
    private Logger logger = getLogger();

    @FindBy(css = "span[class$='username']")
    private WebElement loggedInUser;

    @FindBy(css = "span[class$='username']")
    private List<WebElement> anyUsers;

    @FindBy(css = "ul[id$='dropdown'] #account-settings-link")
    private WebElement settingsButton;

    @FindBy(xpath = "//*[contains(@class,'btn isLohpRebrand')]//a[contains(@to, 'https://learner.coursera.help')]")
    private WebElement helpCenterButton;

    @FindBy(xpath = "//div[@class='rc-NotificationCenter']")
    private WebElement bellButton;

    @FindBy(xpath = "//*[@class='rc-NotificationListEmpty']//h2")
    private WebElement noteContent;

    @FindBy(xpath = "//button[@id='logout-btn' and @tabindex]")
    private WebElement logoutButton;

    @FindBy(xpath = "//*[@id = 'profile-link' and @tabindex]")
    private WebElement profileButton;

    @FindBy(css = "a[data-click-key$='link_help']")
    private WebElement helpCenterLink;

    @FindBy(xpath = "//*[contains(text(),'Not now')]")
    private WebElement notNow;

    @FindBy(xpath = "//ul[@role='menu']//*[@data-e2e='item-coursera-for-business']")
    private WebElement courseraForBusinessButton;

    @FindBy(xpath = "//*[contains(@class, 'c-navbar-item bt3-nav bt3-navbar-nav')]")
    private List<WebElement> listForEnterprise;

    @FindBy(xpath = "//*[@class='c-ph-enterprise__svg']")
    private WebElement listDown;

    @FindBy(css = "a[data-click-key$='ios'] img")
    private WebElement appStoreButton;

    @FindBy(xpath = "//*[@aria-autocomplete='list' and @role='textbox']")
    private WebElement fieldForSearch;

    @FindBy(xpath = "//*[@data-track-component='onboarding_skip_button']")
    private WebElement onboardSkipButton;

    @FindBy(xpath = "//*[@id = 'my-courses-link' and @tabindex]")
    private WebElement myCoursesButton;

    @Override
    public void openPage() {
    }

    public boolean isUserNameDisplayed() {
        return anyUsers.size() > 0;
    }

    public void closeOnboardForm() {
        try {
            onboardSkipButton.click();
        } catch (NoSuchElementException exception) {
            logger.debug("onboard form doesn't appear!");
        }
    }

    public void clickLogoutButtonInUserMenu() {
        getActions().moveToElement(logoutButton)
                .pause(PAUSE_TIME)
                .click()
                .build()
                .perform();
        logger.info("Log out button is selected");
        getDriver().manage().deleteAllCookies();
        logger.info("Cookies are deleted");
    }

    public String getLoggedInUserName() {
        String loggedInUsername = loggedInUser.getText();
        logger.info("logged in with username: {}", loggedInUsername);
        return loggedInUsername;
    }

    public void clickOnLoggedInUser() {
        logger.info("click on the logged in username");
        loggedInUser.click();
    }

    public void clickSettingsButton() {
        logger.info("click on settings button");
        settingsButton.click();
    }

    public void goToHelpCenter() {
        logger.info("click on the logged in username");
        loggedInUser.click();
        logger.info("click on the help center button");
        helpCenterButton.click();
        logger.info("switch to another tab");
        TabsSwitcher.switchToNewTab(getDriver());
    }

    public void clickTheBellButton() {
        logger.info("click on the bell button");
        bellButton.click();
    }

    public String getNotificationContent() {
        WaitersService.waitForVisibilityOfElement(getDriver(), noteContent);
        return noteContent.getText();
    }

    public void clickProfileButton() {
        profileButton.click();
        WaitersService.waitUntilPageIsCompletelyLoaded(getDriver());
    }

    public void notNow() {
        logger.info("Not now pop-up pressed");
        try {
            if (notNow.isDisplayed() && notNow.isEnabled()) {
                notNow.click();
            }
        } catch (NoSuchElementException e) {
            logger.info("Not now was not displayed on screen");
        }
    }

    public void clickHelpCenterLink() {
        logger.info("click on help center link");
        helpCenterLink.click();
    }

    public void waitUntilUserIsLoggedIn() {
        WaitersService.waitForVisibilityOfElement(getDriver(), loggedInUser);
    }

    public void goToCourseraForBusiness() {
        logger.info("choose coursera for enterprise or coursera for business");
        listForEnterprise.get(0).click();
        try {
            logger.info("choose coursera for business");
            courseraForBusinessButton.click();
            logger.info("switch to another tab");
            TabsSwitcher.switchToNewTab(getDriver());
        } catch (Exception e) {
            logger.info("chose coursera for business without down list");
        }
    }

    public void clickAppStoreButton() {
        logger.info("click on app store button");
        appStoreButton.click();
        logger.info("refresh the page");
    }

    public void inputCourseForSearch(final String courseName) {
        waitUntilUserIsLoggedIn();
        logger.info("input data in the search field");
        fieldForSearch.sendKeys(courseName + Keys.ENTER);
    }

    public void goToCourseraForStudent() {
        logger.info("click on the button coursera for student");
        listForEnterprise.get(1).click();
    }

    public void myCoursesButton() {
        logger.info("click on help center link");
        myCoursesButton.click();
    }
}
