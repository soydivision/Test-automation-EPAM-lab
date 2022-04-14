package com.epam.tests.account.settings;

import com.epam.service.PagesManager;
import com.epam.service.UsersManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CourseraConfirmRealNameTest extends PagesManager {
    @Test(description = "User can confirm real name in account settings", groups = "smoke")
    public void userCanConfirmRealName() {
        String firstName = UsersManager.getGoogleUser().getFirstName();
        String middleName = UsersManager.getGoogleUser().getMiddleName();
        String lastName = UsersManager.getGoogleUser().getLastName();
        getHomePage().openPage();
        getHomePage().clickLoginButton();
        getLoginPage().loginWithGoogleAccount(UsersManager.getGoogleUser());
        getUserPage().clickOnLoggedInUser();
        getUserPage().clickSettingsButton();
        getAccountSettingsPage().clickUserVerificationButton();
        getUserVerificationPage().enterFirstName(UsersManager.getGoogleUser().getFirstName());
        getUserVerificationPage().enterMiddleName(UsersManager.getGoogleUser().getMiddleName());
        getUserVerificationPage().enterLastName(UsersManager.getGoogleUser().getLastName());
        getUserVerificationPage().clickSubmitButton();
        String appearedVerificationString = getAccountSettingsPage().getVerificationMessage();
        Assert.assertTrue(appearedVerificationString.contains(firstName + " " + middleName + " " + lastName));
    }
}
