package com.epam.tests.openingpages;

import com.epam.core.utilities.service.TabsSwitcher;
import com.epam.service.PagesManager;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CourseraLinksAtSignupPageTest extends PagesManager {
    private static final String TERMS_OF_USE_TITLE = "Terms of Use";
    private static final String PRIVACY_NOTICE_TITLE = "Privacy Notice";

    @Test(description = "Terms of Use and Privacy Notice links works correctly at signup page",
            groups = "critical path")
    public void termsOfUsePrivacyNoticeLinksTest() {
        getHomePage().openPage();
        getHomePage().clickSignupButton();
        getSignupPage().clickTermsOfUseLink();
        TabsSwitcher.switchBetweenTabs(1);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(getTermsOfUsePage().getTermsOfUseTitleAsText(), TERMS_OF_USE_TITLE);
        TabsSwitcher.switchBetweenTabs(0);
        getSignupPage().clickPrivacyNoticeLink();
        TabsSwitcher.switchBetweenTabs(2);
        softAssert.assertEquals(getPrivacyNoticePage().getPrivacyNoticeTitleAsText(), PRIVACY_NOTICE_TITLE);
        softAssert.assertAll();
    }
}
