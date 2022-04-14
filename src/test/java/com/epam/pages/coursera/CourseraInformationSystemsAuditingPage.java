package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.TabsSwitcher;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseraInformationSystemsAuditingPage extends BasePage {
    private Logger logger = getLogger();

    @FindBy(xpath = "//*[contains(@aria-label,'Introduction to Information Systems (IS) Auditing')]")
    private WebElement seeAllButton;

    @FindBy(xpath = "//*[contains(@data-track-href,'course-overview')]")
    private WebElement courseOverviewVideoLink;

    @Override
    protected void openPage() {
    }

    public CourseraInformationSystemsAuditingPage clickSeeAllButtonInSyllabusSection() {
        TabsSwitcher.switchToNewTab(getDriver());
        logger.info("click on SEE ALL button in Syllabus");
        getActions()
                .moveToElement(seeAllButton)
                .click()
                .build()
                .perform();
        return this;
    }

    public void clickCourseOverviewVideoLink() {
        logger.info("click on Course Overview link");
        courseOverviewVideoLink.click();
    }
}
