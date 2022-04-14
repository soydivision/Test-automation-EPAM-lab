package com.epam.tests.openingpages;

import com.epam.service.PagesManager;
import com.epam.service.UsersManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CourseraAppStoreLinkVerificationTest extends PagesManager {
    @Test(description = "Verify that the link to App Store works correctly after login", groups = "critical path")
    public void appStoreLinkVerificationAfterLoginTest() {
        String appStoreName = getProperties().getProperty("appStore");
        String courseraName = getProperties().getProperty("coursera");
        getHomePage().openPage();
        getHomePage().clickLoginButton();
        getLoginPage().loginWithGoogleAccount(UsersManager.getCourseraUser());
        getUserPage().clickAppStoreButton();
        Assert.assertTrue(getAppStorePage().isItCourseraInAppStore(appStoreName, courseraName),
                "Coursera page application didn't open in App Store!");
    }
}
