package com.epam.tests.login;

import com.epam.service.PagesManager;
import com.epam.service.UsersManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CourseraLoginTest extends PagesManager {
    @Test(description = "User can login at coursera.org via google account", groups = "smoke")
    public void userCanLoginWithGoogleAccount() {
        getHomePage().openPage();
        getHomePage().clickLoginButton();
        getLoginPage().loginWithGoogleAccount(UsersManager.getGoogleUser());
        Assert.assertTrue(getUserPage().getLoggedInUserName().contains(UsersManager.getGoogleUser().getFullName()));
    }
}
