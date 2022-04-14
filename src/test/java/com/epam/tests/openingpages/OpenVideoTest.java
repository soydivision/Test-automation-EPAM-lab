package com.epam.tests.openingpages;

import com.epam.service.PagesManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenVideoTest extends PagesManager {

    @Test(description = "Course Overview video can be opened", groups = "critical path")
    public void openCourseraOverviewVideoTest() {
        getHomePage().openPage();
        getHomePage().enterCourseToSearch("Information Systems Auditing");
        getSearchResultsPage().clickOnFirstCourseInSearch();
        getCourseraInformationSystemsAuditingPage()
                .clickSeeAllButtonInSyllabusSection()
                .clickCourseOverviewVideoLink();
        getCourseraCourseOverviewPage().clickPlayVideo();
        Assert.assertTrue(getCourseraCourseOverviewPage().isVideoOpened());
    }
}
