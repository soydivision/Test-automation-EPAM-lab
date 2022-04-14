package com.epam.tests.login;

import com.epam.service.PagesManager;
import com.epam.service.UsersManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FacebookLoginTest extends PagesManager {
    @Test(description = "User can login using valid Facebook account", groups = "smoke", priority = 1)
    public void userCanLoginWithFacebookAccount() {
        getHomePage().openPage();
        getHomePage().clickLoginButton();
        getLoginPage().loginWithFacebookAccount(UsersManager.getSecondFacebookUser());
        Assert.assertTrue(getUserPage().getLoggedInUserName()
                .contains(UsersManager.getSecondFacebookUser().getFullName()));
    }

    @Test(description = "User can logout using valid Facebook account", groups = "smoke", priority = 2)
    public void userCanLogoutWithFacebookAccount() {
        getUserPage().notNow();
        getUserPage().clickOnLoggedInUser();
        getUserPage().clickLogoutButtonInUserMenu();
        Assert.assertFalse(getUserPage().isUserNameDisplayed());
    }
}
