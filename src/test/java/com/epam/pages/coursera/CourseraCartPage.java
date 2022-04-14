package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseraCartPage extends BasePage {
    private Logger logger = getLogger();

    @FindBy(css = "img[alt$='1 item']")
    private WebElement itemVerification;

    @FindBy(css = ".item a.caption-text")
    private WebElement removeFromCartLink;

    @Override
    public void openPage() {
    }

    public WebElement getCourseAddedToCart() {
        logger.info("verify that item added to cart");
        return itemVerification;
    }

    public void removeItemFromCart() {
        logger.info("click remove from cart link");
        removeFromCartLink.click();
    }
}
