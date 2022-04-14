package com.epam.tests.share;

import com.epam.service.PagesManager;
import com.epam.service.UsersManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShareToTwitterTest extends PagesManager {
    private static final String TEXT_TO_SEARCH = "Coursera";

    @Test(groups = "advanced")
    public void shareToTwitterFunctionWorks() {
        getHomePage().openPage();
        getHomePage().clickForStudentsButtonAndSwitchToNewTab();
        getForStudentsPage().clickShareButton();
        getForStudentsPage().clickTwitterButtonAndSwitchToNewTab();
        getTwitterLogInPage().enterLoginAndPassword(UsersManager.getUserEmailU().getEmail(),
                UsersManager.getUserEmailU().getTwitterPassword());
        getTwitterLogInPage().clickSignInButton();
        Assert.assertTrue(getTweetPage().getTweetText().contains(TEXT_TO_SEARCH) && getTweetPage()
                        .tweetWindowISDisplayed() && getTweetPage().tweetButtonIsClickable(),
                "Tweet window is not displayed with needed text");
    }
}
