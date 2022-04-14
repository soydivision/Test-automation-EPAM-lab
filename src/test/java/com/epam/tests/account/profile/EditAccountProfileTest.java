package com.epam.tests.account.profile;

import com.epam.service.PagesManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.epam.service.UsersManager.getUserWithProfileProperties;

public class EditAccountProfileTest extends PagesManager {

    @Test(description = "Edit current account profile", groups = "critical path")
    public void editCurrentAccountProfile() {
        getHomePage().openPage();
        getHomePage().clickLoginButton();
        getLoginPage().loginWithGoogleAccount(getUserWithProfileProperties());
        getUserPage().clickOnLoggedInUser();
        getUserPage().clickProfileButton();
        getCourseraEditorProfilePage()
                .clickOnEditProfileButton()
                .selectEmployedTimeStatus(getUserWithProfileProperties().getEmployedTimeStatus())
                .inputIndustryValue(getUserWithProfileProperties().getIndustry())
                .inputEmployerValue(getUserWithProfileProperties().getEmployer())
                .inputOccupationValue(getUserWithProfileProperties().getOccupation())
                .selectExperiencedLevel(getUserWithProfileProperties().getExperiencedLevel())
                .isItYourCurrentEmployerCheckbox(getUserWithProfileProperties().getIsItYourCurrentEmployer())
                .selectHighestDegree(getUserWithProfileProperties().getHighestDegree())
                .inputUniversityValue(getUserWithProfileProperties().getUniversity())
                .selectEducationMajor(getUserWithProfileProperties().getEducationMajor())
                .areYouCurrentlyStudentCheckbox(getUserWithProfileProperties().getAreYouCurrentlyStudent())
                .clickSaveChangesButton();
        Assert.assertTrue(getCourseraEditorProfilePage().wereYourChangesSaved(), "Changes were not saved!");
    }
}
