package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseraChangeSubscriptionPlanPage extends BasePage {
    private Logger logger = getLogger();

    @FindBy(tagName = "h1")
    private WebElement header;

    @Override
    protected void openPage() {
        logger.info("Nothing happened, you don't need to open this page directly");
    }

    public String getHeaderText() {
        return header.getText();
    }
}
