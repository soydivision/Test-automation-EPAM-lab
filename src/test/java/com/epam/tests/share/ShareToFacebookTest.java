package com.epam.tests.share;

import com.epam.service.PagesManager;
import com.epam.service.UsersManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShareToFacebookTest extends PagesManager {
    @Test(description = "Checks if user can share post on facebook", groups = "critical path")
    public void shareToFacebookFunctionWorks() {
        getHomePage().openPage();
        getHomePage().clickForStudentsButtonAndSwitchToNewTab();
        getForStudentsPage().clickShareButton();
        getForStudentsPage().clickFacebookButtonAndSwitchToNewTab();
        getFacebookSharePage().logInFacebookViaFacebookPage();
        getFacebookSharePage().shareOnFacebook();
        getFacebookSharePage().goToFacebook();
        getFacebookSharePage().clickOnUser(UsersManager.getSecondFacebookUser().getFullName());
        Assert.assertTrue(getFacebookSharePage().checkFacebookPost());
    }
}
