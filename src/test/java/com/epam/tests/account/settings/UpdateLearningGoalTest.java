package com.epam.tests.account.settings;

import com.epam.service.PagesManager;
import com.epam.service.UsersManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateLearningGoalTest extends PagesManager {
    private static final String OCCUPATION_GOAL = "Java Developer / Engineer";
    private static final String INDUSTRY = "Technology";

    @Test(groups = "advanced")
    public void userGoalUpdates() {
        getHomePage().openPage();
        getHomePage().clickLoginButton();
        getLoginPage().loginWithGoogleAccount(UsersManager.getUserEmailU());
        getUserPage().waitUntilUserIsLoggedIn();
        getHomePage().clickUpdateLearningGoalButton();
        getHomePage().clickChangeCareerButton();
        getHomePage().enterToBecomeProfession(OCCUPATION_GOAL);
        getHomePage().enterIndustry(INDUSTRY);
        getHomePage().clickSubmitButton();
        getHomePage().clickCloseButton();
        Assert.assertEquals(getHomePage().getOccupationGoalText(), OCCUPATION_GOAL, "Learning goal isn't updated");
    }
}
