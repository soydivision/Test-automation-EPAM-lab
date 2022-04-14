package com.epam.tests.signup;

import com.epam.service.PagesManager;
import com.epam.service.UsersManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CourseraRecaptchaVerificationTest extends PagesManager {
    @Test(description = "Verify that recaptcha appears when user signing up", groups = "critical path")
    public void recaptchaVerificationTest() {
        getHomePage().openPage();
        getHomePage().clickSignupButton();
        getSignupPage().signUp(UsersManager.getGoogleUser().getFullName(), UsersManager.getGoogleUser().getEmail(),
                UsersManager.getGoogleUser().getPassword());
        Assert.assertTrue(getSignupPage().getRecaptchaWindow().isDisplayed());
    }
}
