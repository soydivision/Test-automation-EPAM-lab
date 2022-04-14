package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.TabsSwitcher;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseraCareersPage extends BasePage {
    private Logger logger = getLogger();

    @FindBy(xpath = "//*[@href='/careers/students-new-grads']")
    private WebElement studentsAndNewGradsButton;

    @FindBy(xpath = "//*[@href='https://jobs.lever.co/coursera']")
    private WebElement searchOpenRolesLink;

    public void clickStudentsAndNewGradsButton() {
        logger.info("click \"Students and new grads\" button");
        studentsAndNewGradsButton.click();
    }

    public void clickSearchOpenRolesLink() {
        logger.info("click 'Search open roles' link");
        searchOpenRolesLink.click();
        TabsSwitcher.switchToNewTab(getDriver());
    }

    @Override
    protected void openPage() {
    }
}
