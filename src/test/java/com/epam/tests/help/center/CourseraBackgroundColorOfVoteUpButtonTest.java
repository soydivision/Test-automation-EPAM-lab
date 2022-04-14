package com.epam.tests.help.center;

import com.epam.service.PagesManager;
import com.epam.service.UsersManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CourseraBackgroundColorOfVoteUpButtonTest extends PagesManager {
    private static final String COLOR_TO_CHECK = "rgba(0, 0, 0, 0)";

    @Test(description = "Verify that background color of vote up button change"
            + "after clicking on it in coursera help center", groups = "advanced")
    public void backgroundColorOfVoteUpButtonTest() {
        getHomePage().openPage();
        getHomePage().clickLoginButton();
        getLoginPage().loginWithGoogleAccount(UsersManager.getGoogleUser());
        getUserPage().clickHelpCenterLink();
        getHelpCenterPage().chooseHelpTopic();
        getHelpCenterPage().chooseHelpArticle();
        getHelpCenterPage().clickVoteUpButton();
        String votedColor = getHelpCenterPage().getVotedColor();
        getHelpCenterPage().clickVoted();
        Assert.assertNotEquals(votedColor, COLOR_TO_CHECK);
    }
}
