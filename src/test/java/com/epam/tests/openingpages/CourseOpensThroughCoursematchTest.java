package com.epam.tests.openingpages;

import com.epam.service.PagesManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CourseOpensThroughCoursematchTest extends PagesManager {

    @Test(description = "checks if contact us page can be opened", groups = "smoke")
    public void courseOpensThroughCoursematch() {
        getCourseraForCampusPage().openPage();
        getCourseraForCampusPage().clickCoursematchButton();
        getCourseraCampusCoursematchPage().closeForm();
        String courseName = getCourseraCampusCoursematchPage().getFirstResultCourseName();
        getCourseraCampusCoursematchPage().clickFirstResultAndSwitchToNewTab();
        String headerText = getCourseraTechnicalWritingPage().getHeaderText();
        Assert.assertEquals(headerText, courseName, "Header text is not equal to course name!");
    }
}
