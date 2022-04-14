package com.epam.tests.account.settings;

import com.epam.service.PagesManager;
import com.epam.service.UsersManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UnlinkFacebookAndRemoveAccountTest extends PagesManager {
    @Test(description = "Unlink valid facebook account and remove it", groups = "advanced")
    public void deleteAccountProfileFromCoursera() {
        String password = UsersManager.getFirstFacebookUser().getPassword();
        getHomePage().openPage();
        getHomePage().clickLoginButton();
        getLoginPage().loginWithFacebookAccount(UsersManager.getFirstFacebookUser());
        getUserPage().clickOnLoggedInUser();
        getUserPage().clickSettingsButton();
        getAccountSettingsPage().unLinkFacebookAccount();
        getAccountSettingsPage().clickDeleteButton();
        getAccountSettingsPage().selectAllCheckboxesInDeletingYourAccountWindow();
        getAccountSettingsPage().enterPasswordInDeletingYourAccountWindow(password);
        getAccountSettingsPage().confirmDeleteYourAccount();
        getAccountSettingsPage().refresh();
        Assert.assertFalse(getUserPage().isUserNameDisplayed());
    }
}
