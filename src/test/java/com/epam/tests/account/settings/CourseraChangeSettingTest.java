package com.epam.tests.account.settings;

import com.epam.service.PagesManager;
import com.epam.service.UsersManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CourseraChangeSettingTest extends PagesManager {
    @BeforeClass(alwaysRun = true)
    public void logIn() {
        getHomePage().openPage();
        getHomePage().clickLoginButton();
        getLoginPage().loginWithGoogleAccount(UsersManager.getCourseraUser());
        getUserPage().clickOnLoggedInUser();
        getUserPage().clickSettingsButton();
    }

    @Test(description = "Changing language in account settings", groups = "smoke")
    public void changeLanguage() {
        String languageRussian = getProperties().getProperty("language.russian");
        String languageEnglish = getProperties().getProperty("language.english");
        String inputLanguage = getAccountSettingsPage().changeLanguage(languageEnglish, languageRussian);
        getAccountSettingsPage().clickButtonSave();
        getAccountSettingsPage().refresh();
        String realSetLanguage = getAccountSettingsPage().getRealLanguage();
        Assert.assertEquals(inputLanguage, realSetLanguage, "Language didn't change in the profile!");
    }

    @Test(description = "Updating timezone in account settings", groups = "smoke")
    public void updateTimezone() {
        String timezoneMinsk = getProperties().getProperty("timezone.minsk");
        String timezoneKiev = getProperties().getProperty("timezone.kiev");
        String inputTimezone = getAccountSettingsPage().changeTimezone(timezoneMinsk, timezoneKiev);
        getAccountSettingsPage().clickButtonSave();
        getAccountSettingsPage().refresh();
        String realSetTimezone = getAccountSettingsPage().getRealTimezone();
        Assert.assertEquals(inputTimezone, realSetTimezone, "Timezone didn't change in the profile");
    }
}
