package com.epam.tests.account.profile;

import com.epam.core.utilities.service.RobotService;
import com.epam.service.PagesManager;
import com.epam.service.UsersManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeAddChangeProfilePicture extends PagesManager {
    @Test(description = "User can't add big photos", groups = "critical path", priority = 1)
    public void addBigProfilePicture() {
        getHomePage().openPage();
        getHomePage().clickLoginButton();
        getLoginPage().loginWithFacebookAccount(UsersManager.getSecondFacebookUser());
        getUserPage().clickOnLoggedInUser();
        getUserPage().clickProfileButton();
        getCourseraEditorProfilePage().clickOnEditProfileButton();
        getCourseraEditorProfilePage().addPhoto(RobotService.getAbsolutePath(getProperties().getProperty("large"
                + ".profile.pic.path")));
        Assert.assertTrue(getCourseraEditorProfilePage().checkImageError());
    }

    @Test(description = "User can't Wrong Format photos", groups = "critical path", priority = 2)
    public void addProfilePictureWrongFormat() {
        getUserPage().clickOnLoggedInUser();
        getUserPage().clickProfileButton();
        getCourseraEditorProfilePage().clickOnEditProfileBox();
        getCourseraEditorProfilePage().addPhoto(RobotService.getAbsolutePath(getProperties().getProperty("nonimg"
                + ".profile.pic.path")));
        getCourseraEditorProfilePage().clickSaveChangesButton();
        Assert.assertTrue(getCourseraEditorProfilePage().checkImageError());
    }
}
