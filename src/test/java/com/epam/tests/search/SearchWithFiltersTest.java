package com.epam.tests.search;

import com.epam.service.PagesManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchWithFiltersTest extends PagesManager {
    private static final String SEARCH_TERM = "Java";
    private static final String COURSE_NAME = "Learn to Teach Java";

    @Test(groups = "critical path")
    public void courseOpensThroughSearchWithFilters() {
        getHomePage().openPage();
        getHomePage().enterCourseToSearch(SEARCH_TERM);
        getSearchResultsPage().chooseRussianFilter();
        getSearchResultsPage().chooseLevelFilter();
        getSearchResultsPage().clickNeededCourse(COURSE_NAME);
        String headerText = getLearnToTeachJavaPage().getHeaderText();
        Assert.assertTrue(headerText.contains(COURSE_NAME), "Header text is incorrect");
    }
}
