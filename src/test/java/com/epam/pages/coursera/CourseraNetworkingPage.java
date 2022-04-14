package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.WaitersService;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseraNetworkingPage extends BasePage {
    private static final int PAUSE_TIME = 150;
    private static final int PIXELS_NUMBER = 500;
    private Logger logger = getLogger();

    @FindBy(xpath = "//*[@data-track-component='show_more_skills']")
    private WebElement showMoreSkillsButton;

    @FindBy(xpath = "//*[contains(@title,'Software Testing')]")
    private WebElement softwareTestingButton;

    public void clickOnShowMoreButtonTwiceUnderSkillsField() {
        WaitersService.waitForVisibilityOfElement(getDriver(), showMoreSkillsButton);
        logger.info("show more skills");
        getActions()
                .moveToElement(showMoreSkillsButton)
                .pause(PAUSE_TIME)
                .build()
                .perform();
        showMoreSkillsButton.click();
        pageScrollDown(PIXELS_NUMBER);
        showMoreSkillsButton.click();
    }

    public void clickSoftwareTestingInSkills() {
        logger.info("open Software Testing page");
        softwareTestingButton.click();
    }

    @Override
    protected void openPage() {
    }
}
