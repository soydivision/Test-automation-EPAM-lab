package com.epam.tests.openingpages;

import com.epam.pages.coursera.CourseraHomePage;
import com.epam.service.PagesManager;
import org.junit.Assert;
import org.testng.annotations.Test;

public class CourseraMainElementTest extends PagesManager {

    @Test(description = "Coursera element at the left-top corner on https://www.coursera.org/ page redirects correctly",
            groups = "smoke")
    public void courseraMainElementTest() {
        getHomePage().openPage();
        getHomePage().clickOnInformationTechnologyButton();
        getCourseraInformationTechnologyPage().clickNetworkingButton();
        getCourseraNetworkingPage().clickOnShowMoreButtonTwiceUnderSkillsField();
        getCourseraNetworkingPage().clickSoftwareTestingInSkills();
        getCourseraSoftwareTestingPage().clickCourseraMainButton();
        Assert.assertEquals(CourseraHomePage.getHomePageUrl(), getDriver().getCurrentUrl());
    }
}
