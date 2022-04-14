package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.StringService;
import com.epam.core.utilities.service.TabsSwitcher;
import com.epam.core.utilities.service.WaitersService;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CourseraSearchResultsPage extends BasePage {
    private Logger logger = getLogger();

    @FindBy(css = ".tab-contents li[class$='item']")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//*[contains(@class,'banner-title') and text()]")
    private WebElement courseFromSearchResult;

    @FindBy(xpath = "//div[@class='Select-placeholder' and text()='Language']")
    private WebElement languageFilter;

    @FindBy(xpath = "//button[@data-e2e='Russian']")
    private WebElement russianFilter;

    @FindBy(xpath = "//div[@class='Select-placeholder' and text()='Level']")
    private WebElement levelFilter;

    @FindBy(xpath = "//button[@data-e2e='Beginner']")
    private WebElement beginnerLevel;

    @FindBy(xpath = "//div[@data-track-app='search']")
    private List<WebElement> clickableSearchResults;

    @Override
    public void openPage() {
    }

    public List<WebElement> getSearchResults() {
        return searchResults;
    }

    public void clickOnFirstCourseInSearch() {
        WaitersService.waitForListOfWebElementsVisibility(getDriver(), searchResults);
        logger.info("click on searched course link");
        searchResults.get(0).click();
    }

    public boolean doesSearchResultContainParticularCourse(final String searchRequest) {
        String courseNameFromSearchRequest = getCourseNameFromSearchResult();
        logger.info("open {} page", courseNameFromSearchRequest);
        int numberOfEqualWords = StringService
                .getNumberOfEqualWordsInStrings(searchRequest, courseNameFromSearchRequest);
        logger.info("Search result contains {} ", searchRequest);
        return numberOfEqualWords > 0;
    }

    private String getCourseNameFromSearchResult() {
        TabsSwitcher.switchToNewTab(getDriver());
        return courseFromSearchResult.getText();
    }

    public void chooseRussianFilter() {
        getActions().moveToElement(languageFilter).click().build().perform();
        logger.info("Choosing language filter");
        russianFilter.click();
    }

    public void chooseLevelFilter() {
        getActions().moveToElement(levelFilter).click().build().perform();
        logger.info("Choosing level filter");
        beginnerLevel.click();
    }

    public void clickNeededCourse(final String courseName) {
        logger.info("Clicking needed course");
        clickableSearchResults.forEach(result -> {
            if (result.getText().contains(courseName)) {
                result.click();
            }
        });
        TabsSwitcher.switchToNewTab(getDriver());
    }

    public void goToSearchResult() {
        logger.info("go to the new tab");
        TabsSwitcher.switchToNewTab(getDriver());
    }
}
