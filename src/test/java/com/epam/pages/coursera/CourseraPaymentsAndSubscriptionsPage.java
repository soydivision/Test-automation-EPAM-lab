package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseraPaymentsAndSubscriptionsPage extends BasePage {
    private Logger logger = getLogger();

    @FindBy(xpath = "//a[text()='Change your subscription plan']")
    private WebElement changeSubscriptionButton;

    @Override
    protected void openPage() {
        logger.info("Nothing happened, you don't need to open this page directly");
    }

    public void clickChangeSubscriptionPlanButton() {
        logger.info("Click change subscription plan button, new page is opening");
        changeSubscriptionButton.click();
    }
}
