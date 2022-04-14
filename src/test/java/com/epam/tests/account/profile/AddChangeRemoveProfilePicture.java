package com.epam.tests.account.profile;

import com.epam.core.utilities.service.RobotService;
import com.epam.service.PagesManager;
import com.epam.service.UsersManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddChangeRemoveProfilePicture extends PagesManager {
    @Test(description = "User can set profile pic", groups = "critical path", priority = 1)
    public void addProfilePicture() {
        getHomePage().openPage();
        getHomePage().clickLoginButton();
        getLoginPage().loginWithFacebookAccount(UsersManager.getSecondFacebookUser());
        getUserPage().clickOnLoggedInUser();
        getUserPage().clickProfileButton();
        getCourseraEditorProfilePage().clickOnEditProfileButton();
        getCourseraEditorProfilePage().addPhoto(RobotService.getAbsolutePath(getProperties().getProperty("add"
                + ".profile.pic.path")));
        getCourseraEditorProfilePage().clickSaveChangesButton();
        Assert.assertTrue(getCourseraEditorProfilePage().wereYourChangesSaved());
    }

    @Test(description = "User can change profile pic", groups = "critical path", priority = 2)
    public void changeProfilePicture() {
        getHomePage().openPage();
        getUserPage().clickOnLoggedInUser();
        getUserPage().clickProfileButton();
        getCourseraEditorProfilePage().clickOnEditProfileButton();
        getCourseraEditorProfilePage().changePhoto(RobotService.getAbsolutePath(getProperties().getProperty("new"
                + ".profile.pic.path")));
        getCourseraEditorProfilePage().clickSaveChangesButton();
        Assert.assertTrue(getCourseraEditorProfilePage().wereYourChangesSaved());
    }

    @Test(description = "User can remove profile pic", groups = "critical path", priority = 3)
    public void removeProfilePicture() {
        getHomePage().openPage();
        getUserPage().clickOnLoggedInUser();
        getUserPage().clickProfileButton();
        getCourseraEditorProfilePage().clickOnEditProfileButton();
        getCourseraEditorProfilePage().removePhoto();
        getCourseraEditorProfilePage().clickSaveChangesButton();
        Assert.assertTrue(getCourseraEditorProfilePage().wereYourChangesSaved());
    }
}
