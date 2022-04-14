package com.epam.tests.login;

import com.epam.service.PagesManager;
import com.epam.service.UsersManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CourseraLogoutTest extends PagesManager {
    @Test(description = "Log out from coursera.org", groups = "smoke")
    public void logOutTest() {
        getHomePage().openPage();
        getHomePage().clickLoginButton();
        getLoginPage().loginWithGoogleAccount(UsersManager.getUserWithProfileProperties());
        getUserPage().closeOnboardForm();
        getUserPage().clickOnLoggedInUser();
        getUserPage().clickLogoutButtonInUserMenu();
        Assert.assertFalse(getUserPage().isUserNameDisplayed());
    }
}
