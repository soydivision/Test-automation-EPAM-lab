package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CourseraForBusinessPage extends BasePage {
    private Logger logger = getLogger();

    @FindBy(id = "menu-item-2255")
    private WebElement contentButton;

    @FindBy(xpath = "//*[contains(@class,'2255')]//li//a[contains(@text,'')]")
    private List<WebElement> contentList;

    @FindBy(xpath = "//*[@class='headline']")
    private WebElement actualContentResult;

    @Override
    protected void openPage() {
    }

    public void selectionOfSomeContent(final String contentName) {
        logger.info("get the list of content names/click on the content button");
        contentButton.click();
        logger.info("open the list of content names");
        getActions().moveToElement(contentButton).perform();
        logger.info("select one content name from the list");
        contentList.stream().filter(item -> item.getText().contains(contentName)).findFirst().get().click();
    }

    public String getActualResult() {
        return actualContentResult.getText();
    }
}
