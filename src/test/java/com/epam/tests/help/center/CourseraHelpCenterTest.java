package com.epam.tests.help.center;

import com.epam.service.PagesManager;
import com.epam.service.UsersManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CourseraHelpCenterTest extends PagesManager {
    @Test(description = "Checking the functionality of help center at coursera.org", groups = "smoke")
    public void checkingTheFunctionalityOfHelpCenter() {
        String inputSearchData = "Reset your Coursera password";
        getHomePage().openPage();
        getHomePage().clickLoginButton();
        getLoginPage().loginWithGoogleAccount(UsersManager.getCourseraUser());
        getUserPage().goToHelpCenter();
        getHelpCenterPage().fillingOutTheSearchFormWithData(inputSearchData);
        getHelpCenterPage().searchForData();
        String realSearchData = getHelpCenterPage().getRealSearchData();
        Assert.assertEquals(inputSearchData, realSearchData, "Help Articles on the page didn't matches searching data");
    }
}
