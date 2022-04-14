package com.epam.tests.account.settings;

import com.epam.service.PagesManager;
import com.epam.service.UsersManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CourseraPasswordChange extends PagesManager {

    @Test(description = "Changing password in account settings", groups = "critical path")
    public void changePassword() {
        String password = getProperties().getProperty("coursera.password");
        String newPassword = getProperties().getProperty("new.password");
        String successChangePassword = getProperties().getProperty("change.password");
        getHomePage().openPage();
        getHomePage().clickLoginButton();
        getLoginPage().loginWithGoogleAccount(UsersManager.getCourseraUser());
        getUserPage().clickOnLoggedInUser();
        getUserPage().clickSettingsButton();
        getAccountSettingsPage().inputCurrentPassword(password);
        getAccountSettingsPage().inputNewPassword(newPassword);
        getAccountSettingsPage().saveNewPassword();
        getAccountSettingsPage().refresh();
        getAccountSettingsPage().inputCurrentPassword(newPassword);
        getAccountSettingsPage().inputNewPassword(password);
        getAccountSettingsPage().saveNewPassword();
        String actualMassageAboutSave = getAccountSettingsPage().getMassageAboutSave();
        Assert.assertTrue(actualMassageAboutSave.contains(successChangePassword), "Password didn't change!");
    }
}

