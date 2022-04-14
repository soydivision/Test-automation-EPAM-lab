package com.epam.tests.search;

import com.epam.service.PagesManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CourseraSearchResultTest extends PagesManager {

    @Test(description = "Search with coursera.org search field", groups = "smoke")
    public void courseraSearchResultTest() {
        String searchCourse = "java core";
        getHomePage().openPage();
        getHomePage().enterCourseToSearch(searchCourse);
        getSearchResultsPage().clickOnFirstCourseInSearch();
        Assert.assertTrue(getSearchResultsPage().doesSearchResultContainParticularCourse(searchCourse));
    }
}
