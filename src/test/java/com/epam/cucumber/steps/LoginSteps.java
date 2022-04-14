package com.epam.cucumber.steps;

import com.epam.pages.coursera.CourseraHomePage;
import com.epam.pages.coursera.CourseraLoginPage;
import com.epam.service.UsersManager;
import io.cucumber.java.en.When;

public class LoginSteps {

    private final CourseraLoginPage loginPage = new CourseraLoginPage();
    private final CourseraHomePage homePage = new CourseraHomePage();

    @When("the user with {string} google account is logged in")
    public void openPageAndLogIn(final String account) {
        homePage.openPage();
        homePage.clickLoginButton();
        switch (account) {
            case "Vlad":
                loginPage.loginWithGoogleAccount(UsersManager.getUserEmailU());
                break;
            case "Pavel":
                loginPage.loginWithGoogleAccount(UsersManager.getUserWithProfileProperties());
                break;
            case "Alex":
                loginPage.loginWithGoogleAccount(UsersManager.getGoogleUser());
                break;
            default:
                loginPage.loginWithGoogleAccount(UsersManager.getCourseraUser());
        }
    }
}
