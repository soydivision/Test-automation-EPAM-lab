package com.epam.tests.cart;

import com.epam.service.PagesManager;
import com.epam.service.UsersManager;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CourseraDeleteCourseFromCartTest extends PagesManager {
    private static final String URL_FOR_CHECK = "https://www.coursera.org/browse";

    @Test(description = "User can delete course from cart at coursera.org", groups = "smoke")
    public void userCanDeleteCourseFromCart() {
        String courseraUsername = UsersManager.getGoogleUser().getFullName();
        getHomePage().openPage();
        getHomePage().clickLoginButton();
        getLoginPage().loginWithGoogleAccount(UsersManager.getGoogleUser());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(getUserPage().getLoggedInUserName().contains(courseraUsername));
        getHomePage().enterCourseToSearch(UsersManager.getGoogleUser().getCourseName());
        getSearchResultsPage().clickOnFirstCourseInSearch();
        getCourseDescriptionPage().clickEnrollForFreeButton();
        getCourseDescriptionPage().clickStartFreeTrialButton();
        getCartPage().removeItemFromCart();
        softAssert.assertEquals(getDriver().getCurrentUrl(), URL_FOR_CHECK);
        softAssert.assertAll();
    }
}
