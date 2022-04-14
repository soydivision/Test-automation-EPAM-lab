package com.epam.tests.openingpages;

import com.epam.service.PagesManager;
import com.epam.service.UsersManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CourseraForStudentTest extends PagesManager {
    @Test(description = "checking a list of frequently asked questions is displayed on the page Coursera for student",
            groups = "critical path")
    public void checkingAskedOnCourseraForStudent() {
        getHomePage().openPage();
        getHomePage().clickLoginButton();
        getLoginPage().loginWithGoogleAccount(UsersManager.getCourseraUser());
        getUserPage().goToCourseraForStudent();
        Assert.assertTrue(getForStudentsPage().isListNotEmpty(), "The list of frequently asked questions is empty!");
    }
}
