package com.epam.tests.openingpages;

import com.epam.service.PagesManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageCorrectlyOpens extends PagesManager {
    private static final String TITLE_TEXT = "Coursera | Build Skills with Online Courses from Top Institutions";

    @Test(description = "checks if home page opens", groups = "smoke")
    public void homePageOpens() {
        getHomePage().openPage();
        String titleText = getHomePage().getTitleText();
        Assert.assertEquals(titleText, TITLE_TEXT, "Title does not match");
    }
}
