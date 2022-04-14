package com.epam.tests.courses;

import com.epam.service.PagesManager;
import com.epam.service.UsersManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CourseraCancelingCourseTest extends PagesManager {
    @Test(description = "Canceling course enrollment", groups = "advanced")
    public void cancelingCourseEnrollment() {
        String dataSearch = getProperties().getProperty("data.search");
        String courseTitle = getProperties().getProperty("course.title");
        getHomePage().openPage();
        getHomePage().clickLoginButton();
        getLoginPage().loginWithGoogleAccount(UsersManager.getCourseraUser());
        getUserPage().inputCourseForSearch(dataSearch);
        getSearchResultsPage().clickOnFirstCourseInSearch();
        getSearchResultsPage().goToSearchResult();
        getOneFreeCoursePage().enrollForFreeCourse();
        getOneFreeCoursePage().goToTheCourseList();
        getBasketCoursesPage().unenrollCourse();
        getBasketCoursesPage().confirmUnenroll();
        Assert.assertTrue(getBasketCoursesPage().wasCourseCanceled(courseTitle),
                "Сourse didn't remove from the list of user courses!");
    }
}
