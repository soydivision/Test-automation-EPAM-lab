package com.epam.tests.notes;

import com.epam.service.PagesManager;
import com.epam.service.UsersManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddPersonalNotesTest extends PagesManager {
    @Test(description = "Course notes can be opened,saved, removed", groups = "critical path")
    public void addNote() {
        getHomePage().openPage();
        getHomePage().clickLoginButton();
        getLoginPage().loginWithFacebookAccount(UsersManager.getSecondFacebookUser());
        getUserPage().clickOnLoggedInUser();
        getUserPage().myCoursesButton();
        getCourseraCoursePage().goToCourseButton();
        getCourseraCoursePage().turnOffTimeZoneWindow();
        getCourseraCoursePage().clickOnVideo();
        getCourseraCoursePage().okGotItPressed();
        getCourseraCoursePage().saveNote();
        getCourseraCoursePage().goToAllNotes();
        Assert.assertFalse(getCourseraCoursePage().notesAreEmpty());
        getCourseraCoursePage().deleteNote();
        Assert.assertTrue(getCourseraCoursePage().notesAreEmpty());
    }
}
