package com.epam.tests.help.center;

import com.epam.service.PagesManager;
import com.epam.service.UsersManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubscriptionPlanPageOpens extends PagesManager {
    private static final String HEADER_TEXT = "Change your subscription plan";

    @Test(description = "Opens subscription plan page of help center", groups = "critical path")
    public void subscriptionPlanHelpCenterPageOpens() {
        getHomePage().openPage();
        getHomePage().clickLoginButton();
        getLoginPage().loginWithGoogleAccount(UsersManager.getUserEmailU());
        getUserPage().goToHelpCenter();
        getHelpCenterPage().clickPaymentsButtonAndSwitchToNewTab();
        getCourseraPaymentsAndSubscriptionsPage().clickChangeSubscriptionPlanButton();
        String headerText = getChangeSubscriptionPlanPage().getHeaderText();
        Assert.assertEquals(headerText, HEADER_TEXT, "Header text is incorrect");
    }
}
