package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.TabsSwitcher;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseraYandexCoursesPage extends BasePage {
    private Logger logger = getLogger();

    @FindBy(xpath = "//*[contains(@alt,'Big Data Applications')]")
    private WebElement bigDataApplicationsCourseButton;

    @FindBy(xpath = "//*[@class='PartnerList']//*[contains(@class,'rc-Partner__title')]")
    private WebElement partnerTitle;

    public void selectBigDataApplicationsCourse() {
        logger.info("select 'Big Data Applications:Machine Learning at Scale' course");
        bigDataApplicationsCourseButton.click();
        TabsSwitcher.switchToNewTab(getDriver());
    }

    public String getPartnerTitleValue() {
        String partnerTitleValue = partnerTitle.getText();
        logger.info("this course offered by {}", partnerTitleValue);
        return partnerTitleValue;
    }

    @Override
    protected void openPage() {
    }
}
