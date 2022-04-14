package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseraBasicPlanPage extends BasePage {
    private Logger logger = getLogger();

    @FindBy(xpath = "//div[@class='cta-wrapper']/a[@href='#form']")
    private WebElement startForFreeButton;

    @Override
    protected void openPage() {
        logger.info("Nothing happened, you don't need to open this page directly");
    }

    public void clickStartForFreeButton() {
        logger.info("Clicking start for free button");
        startForFreeButton.click();
    }
}
