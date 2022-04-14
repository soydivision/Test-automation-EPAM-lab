package com.epam.tests.openingpages;

import com.epam.service.PagesManager;
import com.epam.service.UsersManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CourseraForBusinessTest extends PagesManager {
    @Test(description = "checking the functionality of Coursera for Business", groups = "critical path")
    public void checkingCourseraForBusinessOpen() {
        String setContent = getProperties().getProperty("name.content");
        getHomePage().openPage();
        getHomePage().clickLoginButton();
        getLoginPage().loginWithGoogleAccount(UsersManager.getCourseraUser());
        getUserPage().goToCourseraForBusiness();
        getCourseraForBusiness().selectionOfSomeContent(setContent);
        String actualContentResult = getCourseraForBusiness().getActualResult();
        Assert.assertTrue(actualContentResult.contains(setContent),
                "Coursera Software Engineering Academy page didn't open correct");
    }
}
