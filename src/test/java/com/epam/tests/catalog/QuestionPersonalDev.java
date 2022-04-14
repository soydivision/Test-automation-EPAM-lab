package com.epam.tests.catalog;

import com.epam.service.PagesManager;
import com.epam.service.UsersManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QuestionPersonalDev extends PagesManager {
    @Test(description = "checks if answer to question about personal dev is shown", groups = "critical path")
    public void questionAboutPersonalDevelopmentIsShown() {
        getHomePage().openPage();
        getHomePage().clickLoginButton();
        getLoginPage().loginWithGoogleAccount(UsersManager.getUserEmailU());
        getUserPage().waitUntilUserIsLoggedIn();
        getPersonalDevelopmentPage().openPage();
        getPersonalDevelopmentPage().clickQuestionButton();
        Assert.assertTrue(getPersonalDevelopmentPage().answerIsShown(), "Answer to the question is not shown");
    }
}
