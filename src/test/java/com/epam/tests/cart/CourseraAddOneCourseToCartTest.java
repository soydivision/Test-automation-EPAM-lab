package com.epam.tests.cart;

import com.epam.service.PagesManager;
import com.epam.service.UsersManager;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CourseraAddOneCourseToCartTest extends PagesManager {
    @Test(description = "User can add course to cart at coursera.org", groups = "smoke")
    public void userCanAddCourseToCart() {
        getHomePage().openPage();
        getHomePage().clickLoginButton();
        getLoginPage().loginWithGoogleAccount(UsersManager.getGoogleUser());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(getUserPage().getLoggedInUserName().contains(UsersManager.getGoogleUser().getFullName()));
        getHomePage().enterCourseToSearch(UsersManager.getGoogleUser().getCourseName());
        getSearchResultsPage().clickOnFirstCourseInSearch();
        getCourseDescriptionPage().clickEnrollForFreeButton();
        getCourseDescriptionPage().clickStartFreeTrialButton();
        softAssert.assertTrue(getCartPage().getCourseAddedToCart().isDisplayed()
                && getCartPage().getCourseAddedToCart().isEnabled());
        softAssert.assertAll();
    }
}
