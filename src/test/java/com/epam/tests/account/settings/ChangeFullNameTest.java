package com.epam.tests.account.settings;

import com.epam.core.utilities.service.StringService;
import com.epam.service.PagesManager;
import com.epam.service.UsersManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeFullNameTest extends PagesManager {
    private static final int RANDOM_STRING_LENGTH = 10;
    private static final String STATUS_MESSAGE = "Update successful!";

    @Test(description = "changes full name of user and checks if it was successful", groups = "smoke")
    public void fullNameChanges() {
        getHomePage().openPage();
        getHomePage().clickLoginButton();
        getLoginPage().loginWithGoogleAccount(UsersManager.getUserEmailU());
        getUserPage().clickOnLoggedInUser();
        getUserPage().clickSettingsButton();
        getAccountSettingsPage().erasePreviousFullName();
        getAccountSettingsPage().enterNewFullNameAndSave(StringService.getRandomString(RANDOM_STRING_LENGTH));
        String statusMessage = getAccountSettingsPage().getStatusMessage();
        Assert.assertEquals(statusMessage, STATUS_MESSAGE, "Status message is incorrect");
    }
}
