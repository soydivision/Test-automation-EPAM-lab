package com.epam.tests.openingpages;

import com.epam.service.PagesManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CourseraGooglePlayLinkVerificationTest extends PagesManager {
    private static final String COURSERA_APP_TITLE = "Coursera";

    @Test(description = "Verify that link to google play app works correctly", groups = "critical path")
    public void googlePlayLinkVerificationTest() {
        getHomePage().openPage();
        getHomePage().clickGooglePlayButton();
        Assert.assertEquals(getGooglePlayPage().getCourseraAppTitle(), COURSERA_APP_TITLE);
    }
}
