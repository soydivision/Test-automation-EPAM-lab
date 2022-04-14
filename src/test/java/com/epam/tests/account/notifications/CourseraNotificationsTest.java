package com.epam.tests.account.notifications;

import com.epam.service.PagesManager;
import com.epam.service.UsersManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CourseraNotificationsTest extends PagesManager {
    @Test(description = "Сhecking the ability to view notifications at coursera.org", groups = "smoke")
    public void checkingTheAbilityToViewNotifications() {
        String noteContentEn = "No notifications";
        String noteContentRu = "Нет уведомлений";
        getHomePage().openPage();
        getHomePage().clickLoginButton();
        getLoginPage().loginWithGoogleAccount(UsersManager.getCourseraUser());
        getUserPage().clickTheBellButton();
        String realNoteContent = getUserPage().getNotificationContent();
        Assert.assertTrue(noteContentEn.equals(realNoteContent) || noteContentRu.equals(realNoteContent),
                "Notifications didn't view!");
    }
}
