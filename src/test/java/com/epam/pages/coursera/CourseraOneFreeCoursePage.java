package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseraOneFreeCoursePage extends BasePage {
    private Logger logger = getLogger();

    @FindBy(xpath = "//*[@class='BannerEnroll']//button[@data-e2e='enroll-button']")
    private WebElement enrollForFreeButton;

    @FindBy(xpath = "//*[@data-e2e='course_enroll_modal_continue_button']")
    private WebElement continueEnrollButton;

    @FindBy(xpath = "//*[@data-e2e='close-modal-button']")
    private WebElement closeWindow;

    @FindBy(css = "span[class$='username']")
    private WebElement dropDownList;

    @FindBy(css = "ul[id$='dropdown'] #my-courses-link")
    private WebElement myCoursesButton;

    @Override
    protected void openPage() {
    }

    public void enrollForFreeCourse() {
        logger.info("click the button enroll for free");
        enrollForFreeButton.click();
        logger.info("click the button continue for enroll");
        continueEnrollButton.click();
        logger.info("click close the window");
        closeWindow.click();
        getDriver().navigate().refresh();
    }

    public void goToTheCourseList() {
        logger.info("click the button drop-down");
        dropDownList.click();
        logger.info("click my courses button");
        myCoursesButton.click();
    }
}
