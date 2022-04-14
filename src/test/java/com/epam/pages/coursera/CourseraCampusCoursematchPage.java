package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.FrameSwitcher;
import com.epam.core.utilities.service.WaitersService;
import com.epam.core.utilities.service.TabsSwitcher;
import com.epam.core.utilities.service.WebElementsService;
import com.epam.core.utilities.service.ListService;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CourseraCampusCoursematchPage extends BasePage {
    private static final String FIRST_RESULT_LINK_LOCATOR = "//*[contains(@href, 'technical-writing')]";
    private Logger logger = getLogger();

    @FindBy(xpath = "//a[@data-track-action='close']")
    private WebElement closeFormButton;

    @FindBy(xpath = "//button[@lk-track-name='dashboard']")
    private WebElement runButton;

    @FindBy(xpath = "//iframe[@title='Looker Dashboard']")
    private WebElement frame;

    private WebElement firstResultLink;

    @FindBy(css = ".vis .measure .drillable-item-content")
    private List<WebElement> relevanceScoreColumn;

    public void closeForm() {
        logger.info("The form is closing");
        closeFormButton.click();
    }

    public String getFirstResultCourseName() {
        FrameSwitcher.switchToFrameWithWait(getDriver(), frame);
        firstResultLink = WaitersService.waitUntilPresenceOfElementAndReturn(getDriver(),
                By.xpath(FIRST_RESULT_LINK_LOCATOR));
        return firstResultLink.getText();
    }

    public void clickFirstResultAndSwitchToNewTab() {
        logger.info("First result course page is opening");
        firstResultLink.click();
        TabsSwitcher.switchToNewTab(getDriver());
    }

    public boolean areElementsFromRelevantScoreInDescendingOrder() {
        FrameSwitcher.switchToFrameWithWait(getDriver(), frame);
        logger.info("read values from the table");
        List<Double> scoreList = WebElementsService.getListOfDoubleFromElementsText(relevanceScoreColumn);
        logger.info("check the order of elements");
        double maxValue = 1.0;
        boolean result = ListService.isListDoubleInDescendingOrder(scoreList, maxValue);
        logger.info("Values from relevant score column of the table in descending order: {}", result);
        return result;
    }

    @Override
    public void openPage() {
    }
}
