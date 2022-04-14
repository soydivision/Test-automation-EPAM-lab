package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.TabsSwitcher;
import com.epam.core.utilities.service.WaitersService;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseraHomePage extends BasePage {
    private static final String HOME_PAGE_URL = "https://www.coursera.org/";
    private static final int PAUSE_TIME = 100;
    private Logger logger = getLogger();

    @FindBy(css = "a[data-e2e='header-login-button']")
    private WebElement loginButton;

    @FindBy(css = "input[class$='input']")
    private WebElement searchInput;

    @FindBy(xpath = "//a[@to='/about/contact']")
    private WebElement contactButton;

    @FindBy(xpath = "//*[@data-e2e='megamenu-explore-button']")
    private WebElement exploreButton;

    @FindBy(xpath = "//*[contains(@data-e2e, 'life-sciences')]")
    private WebElement healthButton;

    @FindBy(css = "a[data-click-key$='see_all_partner']")
    private WebElement partnersLink;

    @FindBy(css = "a[data-click-key$='android'] img")
    private WebElement googlePlayButton;

    @FindBy(css = "a.standardSignupBtnLink")
    private WebElement signupButton;

    @FindBy(xpath = "//*[contains(@href, 'global-mph-imperial')]")
    private WebElement globalMasterButton;

    @FindBy(id = "information-technology~menu-item")
    private WebElement informationTechnologyElementInExploreDropdown;

    @FindBy(xpath = "//*[contains(@data-track-component,'launch_or_advance_your_career')]")
    private WebElement launchYourCareerButton;

    @FindBy(xpath = "//*[contains(@data-e2e,'Computer User Support Specialist')]")
    private WebElement computerUserSupportSpecialistButton;

    @FindBy(css = "a[href='https://blog.coursera.org']")
    private WebElement courseraBlogLink;

    @FindBy(xpath = "//button[@data-e2e='update-learning-goal-button']")
    private WebElement updateGoalButton;

    @FindBy(xpath = "//button[@data-e2e='change-my-career-button']")
    private WebElement changeCareerButton;

    @FindBy(xpath = "//div[text()='I want to become a']/..//input")
    private WebElement toBecomeField;

    @FindBy(xpath = "//div[@id='react-select-IndustriesDropdown~switchCareer--value']//input")
    private WebElement industryField;

    @FindBy(xpath = "//button[@data-e2e='concierge-submit-button']")
    private WebElement submitButton;

    @FindBy(xpath = "//a[@data-e2e='close-modal-button']")
    private WebElement closeButton;

    @FindBy(id = "react-select-frontdesk-occupation-goal--value-item")
    private WebElement occupationGoalField;

    @FindBy(xpath = "//*[contains(@href, 'college-students')]")
    private WebElement forStudentsButton;

    @FindBy(xpath = "//*[contains(@data-track-href,'developer-program')]")
    private WebElement developersLink;

    @FindBy(xpath = "//*[@data-track-href='https://www.coursera.community']")
    private WebElement learnersButton;

    @FindBy(xpath = "//*[@data-track-component='mega_menu_domain_data_science']")
    private WebElement dataScienceButton;

    @FindBy(xpath = "//*[contains(@href,'/degrees/master-of-data-science-hse')]")
    private WebElement hseDataScienceButton;

    public static String getHomePageUrl() {
        return HOME_PAGE_URL;
    }

    @Override
    public void openPage() {
        logger.info("open page: " + HOME_PAGE_URL);
        getDriver().get(HOME_PAGE_URL);
    }

    public void clickLoginButton() {
        logger.info("click on login button");
        loginButton.click();
    }

    public void enterCourseToSearch(final String courseName) {
        logger.info("enter course: {} in the search input field", courseName);
        searchInput.sendKeys(courseName + Keys.ENTER);
    }

    public void clickContactButton() {
        logger.info("contact us page is opened");
        contactButton.click();
    }

    public void clickGlobalMasterButton() {
        getActions().moveToElement(exploreButton).pause(PAUSE_TIME).click().build().perform();
        getActions().moveToElement(healthButton).pause(PAUSE_TIME).perform();
        logger.info("Global master health page is opened");
        WaitersService.waitForVisibilityOfElement(getDriver(), globalMasterButton);
        globalMasterButton.click();
    }

    public void clickOnInformationTechnologyButton() {
        logger.info("open Information Technology page");
        getActions()
                .moveToElement(exploreButton)
                .pause(PAUSE_TIME)
                .click()
                .build()
                .perform();
        informationTechnologyElementInExploreDropdown.click();
    }

    public void clickPartnersLink() {
        logger.info("click on partners link");
        partnersLink.click();
    }

    public void clickGooglePlayButton() {
        logger.info("click on google play button");
        googlePlayButton.click();
    }

    public void clickSignupButton() {
        logger.info("click signup button");
        signupButton.click();
    }

    public void clickCourseraBlogLink() {
        logger.info("click on coursera blog link");
        courseraBlogLink.click();
    }

    public void clickUpdateLearningGoalButton() {
        logger.info("clicking learning goal button");
        updateGoalButton.click();
    }

    public void clickChangeCareerButton() {
        logger.info("clicking change career button");
        changeCareerButton.click();
    }

    public void enterToBecomeProfession(final String value) {
        logger.info("Entering to become profession");
        toBecomeField.sendKeys(value + Keys.ENTER);
    }

    public void enterIndustry(final String value) {
        logger.info("Entering industry");
        industryField.sendKeys(value + Keys.ENTER);
    }

    public void clickSubmitButton() {
        logger.info("Clicking submit button");
        submitButton.click();
    }

    public void clickCloseButton() {
        logger.info("Closing alert");
        closeButton.click();
    }

    public String getOccupationGoalText() {
        return occupationGoalField.getText();
    }

    public void clickForStudentsButtonAndSwitchToNewTab() {
        logger.info("Clicking for students button");
        forStudentsButton.click();
        TabsSwitcher.switchToNewTab(getDriver());
    }

    public String getTitleText() {
        return getDriver().getTitle();
    }

    public void clickDevelopersLink() {
        logger.info("click 'Developers' link");
        developersLink.click();
        TabsSwitcher.switchToNewTab(getDriver());
    }

    public void clickLearnersButton() {
        logger.info("click Learners button");
        learnersButton.click();
        TabsSwitcher.switchToNewTab(getDriver());
    }

    public void clickDataScienceButton() {
        getActions().moveToElement(exploreButton).pause(PAUSE_TIME).click().build().perform();
        getActions().moveToElement(dataScienceButton).pause(PAUSE_TIME).perform();
        logger.info("Data ScienceButton clicked");
        dataScienceButton.click();
        hseDataScienceButton.click();
    }

    public String getHeaderText() {
        return getDriver().findElement(By.tagName("h1")).getText();
    }
}
