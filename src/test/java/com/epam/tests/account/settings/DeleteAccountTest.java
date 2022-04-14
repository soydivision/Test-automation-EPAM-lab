package com.epam.tests.account.settings;

import com.epam.service.PagesManager;
import com.epam.service.UsersManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteAccountTest extends PagesManager {

    @Test(description = "Delete an existing account", groups = "smoke")
    public void deleteAccountProfileFromCoursera() {
        getHomePage().openPage();
        getHomePage().clickLoginButton();
        getLoginPage().loginWithGoogleAccount(UsersManager.getUserWithProfileProperties());
        getUserPage().clickOnLoggedInUser();
        getUserPage().clickSettingsButton();
        getAccountSettingsPage().clickDeleteAccountButton(UsersManager.getUserWithProfileProperties().getPassword());
        getAccountSettingsPage().selectAllCheckboxesInDeletingYourAccountWindow();
        getAccountSettingsPage().
                enterPasswordInDeletingYourAccountWindow(UsersManager.getUserWithProfileProperties().getPassword());
        getAccountSettingsPage().confirmDeleteYourAccount();
        getDriver().navigate().refresh();
        Assert.assertFalse(getUserPage().isUserNameDisplayed());
    }
}
