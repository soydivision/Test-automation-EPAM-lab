package com.epam.tests.login;

import com.epam.service.GmailMailChecker;
import com.epam.service.PagesManager;
import com.epam.service.UsersManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends PagesManager {
    @Test(description = "user can restore password with email", groups = "advanced")
    public void restorePasswordForCourseraUser() {
        String subject = getProperties().getProperty("email.subject.to.check");
        getHomePage().openPage();
        getHomePage().clickLoginButton();
        getLoginPage().clickForgotPassword();
        getLoginPage().inputRegistrationEmail(UsersManager.getFirstFacebookUser().getEmail());
        getLoginPage().sendEmailToRecoverPassword();
        Assert.assertTrue(GmailMailChecker.emailReceived(UsersManager.getFirstFacebookUser().getEmail(),
                UsersManager.getFirstFacebookUser().getFacebookPassword(), subject));
    }
}
