package com.epam.tests.account.settings;

import com.epam.service.PagesManager;
import com.epam.service.UsersManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RequestDataTest extends PagesManager {
    @Test(description = "Request a report of all learner data", groups = "advanced")
    public void requestReportData() {
        String keyword = getProperties().getProperty("data.release");
        getHomePage().openPage();
        getHomePage().clickLoginButton();
        getLoginPage().loginWithGoogleAccount(UsersManager.getCourseraUser());
        getUserPage().clickOnLoggedInUser();
        getUserPage().clickSettingsButton();
        getAccountSettingsPage().clickSendReportButton();
        Boolean sendResult = getAccountSettingsPage().confirmSendDataReport();
        getGmailPage().goToGmailPage();
        Boolean readResult = getGmailPage().selectionLetter(keyword);
        Assert.assertEquals(sendResult, readResult, "The message didn't come on the email!");
    }
}
