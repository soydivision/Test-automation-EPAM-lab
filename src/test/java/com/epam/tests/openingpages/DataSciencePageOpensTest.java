package com.epam.tests.openingpages;

import com.epam.service.PagesManager;
import com.epam.service.UsersManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataSciencePageOpensTest extends PagesManager {
    private static final String HEADER_TEXT = "Master of Data Science";

    @Test(description = "data Science Page HSE University link works", groups = "smoke")
    public void dataSciencePageOpens() {
        getHomePage().openPage();
        getHomePage().clickLoginButton();
        getLoginPage().loginWithFacebookAccount(UsersManager.getSecondFacebookUser());
        getUserPage().notNow();
        getHomePage().clickDataScienceButton();
        String headerText = getHomePage().getHeaderText();
        Assert.assertEquals(headerText, HEADER_TEXT, "Header  text on data science page  is not equal");
    }
}
