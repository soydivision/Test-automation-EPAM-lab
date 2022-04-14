package com.epam.service;

import com.epam.core.test.CommonConditions;
import com.epam.core.utilities.property.PropertyDataReader;
import com.epam.pages.coursera.*;
import com.epam.pages.facebook.FacebookSharePage;
import com.epam.pages.gmail.GmailPage;
import com.epam.pages.googleplay.GooglePlayPage;
import com.epam.pages.jobs.JobsLeverCoPage;
import com.epam.pages.twitter.TweetPage;
import com.epam.pages.twitter.TwitterLogInPage;
import org.testng.annotations.BeforeClass;
import java.util.Properties;

public class PagesManager extends CommonConditions {
    private Properties properties;
    private CourseraHomePage homePage;
    private CourseraLoginPage loginPage;
    private CourseraUserPage userPage;
    private CourseraAccountSettingsPage accountSettingsPage;
    private CourseraUserVerificationPage userVerificationPage;
    private CourseraSearchResultsPage searchResultsPage;
    private CourseraCourseDescriptionPage courseDescriptionPage;
    private CourseraCartPage cartPage;
    private CourseraHelpCenterPage helpCenterPage;
    private CourseraContactPage contactPage;
    private CourseraGlobalMasterOfPublicHealthPage courseraGlobalMasterOfPublicHealthPage;
    private CourseraInformationTechnologyPage courseraInformationTechnologyPage;
    private CourseraNetworkingPage courseraNetworkingPage;
    private CourseraSoftwareTestingPage courseraSoftwareTestingPage;
    private CourseraForCampusPage courseraForCampusPage;
    private CourseraCampusCoursematchPage courseraCampusCoursematchPage;
    private CourseraTechnicalWritingPage courseraTechnicalWritingPage;
    private CourseraEditorProfilePage courseraEditorProfilePage;
    private CourseraInformationSystemsAuditingPage courseraInformationSystemsAuditingPage;
    private CourseraCourseOverviewPage courseraCourseOverviewPage;
    private CourseraPartnersPage partnersPage;
    private GooglePlayPage googlePlayPage;
    private CourseraSignupPage signupPage;
    private CourseraTermsOfUsePage termsOfUsePage;
    private CourseraPrivacyNoticePage privacyNoticePage;
    private CourseraBlogPage blogPage;
    private CourseraPaymentsAndSubscriptionsPage courseraPaymentsAndSubscriptionsPage;
    private CourseraChangeSubscriptionPlanPage changeSubscriptionPlanPage;
    private CourseraPersonalDevelopmentPage personalDevelopmentPage;
    private CourseraTryForFreeFormPage tryForFreeFormPage;
    private CourseraLearnToTeachJavaPage learnToTeachJavaPage;
    private CourseraForStudentsPage forStudentsPage;
    private TwitterLogInPage twitterLogInPage;
    private TweetPage tweetPage;
    private CourseraForBusinessPage courseraForBusiness;
    private GmailPage gmailPage;
    private CourseraRuPartnersPage courseraRuPartnersPage;
    private CourseraYandexCoursesPage courseraYandexCoursesPage;
    private CourseraDevelopersPage courseraDevelopersPage;
    private CourseraCareersPage courseraCareersPage;
    private JobsLeverCoPage jobsLeverCoPage;
    private CourseraCommunityPage courseraCommunityPage;
    private CourseraAppStorePage appStorePage;
    private CourseraOneFreeCoursePage oneFreeCoursePage;
    private CourseraBasketCoursesPage basketCoursesPage;
    private FacebookSharePage facebookSharePage;
    private CourseraCoursePage courseraCoursePage;


    public Properties getProperties() {
        return properties;
    }

    public CourseraHomePage getHomePage() {
        return homePage;
    }

    public CourseraLoginPage getLoginPage() {
        return loginPage;
    }

    public CourseraUserPage getUserPage() {
        return userPage;
    }

    public CourseraAccountSettingsPage getAccountSettingsPage() {
        return accountSettingsPage;
    }

    public CourseraUserVerificationPage getUserVerificationPage() {
        return userVerificationPage;
    }

    public CourseraSearchResultsPage getSearchResultsPage() {
        return searchResultsPage;
    }

    public CourseraCourseDescriptionPage getCourseDescriptionPage() {
        return courseDescriptionPage;
    }

    public CourseraCartPage getCartPage() {
        return cartPage;
    }

    public CourseraHelpCenterPage getHelpCenterPage() {
        return helpCenterPage;
    }

    public CourseraContactPage getContactPage() {
        return contactPage;
    }

    public CourseraGlobalMasterOfPublicHealthPage getCourseraGlobalMasterOfPublicHealthPage() {
        return courseraGlobalMasterOfPublicHealthPage;
    }

    public CourseraInformationTechnologyPage getCourseraInformationTechnologyPage() {
        return courseraInformationTechnologyPage;
    }

    public CourseraNetworkingPage getCourseraNetworkingPage() {
        return courseraNetworkingPage;
    }

    public CourseraSoftwareTestingPage getCourseraSoftwareTestingPage() {
        return courseraSoftwareTestingPage;
    }

    public CourseraForCampusPage getCourseraForCampusPage() {
        return courseraForCampusPage;
    }

    public CourseraCampusCoursematchPage getCourseraCampusCoursematchPage() {
        return courseraCampusCoursematchPage;
    }

    public CourseraTechnicalWritingPage getCourseraTechnicalWritingPage() {
        return courseraTechnicalWritingPage;
    }

    public CourseraEditorProfilePage getCourseraEditorProfilePage() {
        return courseraEditorProfilePage;
    }

    public CourseraInformationSystemsAuditingPage getCourseraInformationSystemsAuditingPage() {
        return courseraInformationSystemsAuditingPage;
    }

    public CourseraCourseOverviewPage getCourseraCourseOverviewPage() {
        return courseraCourseOverviewPage;
    }

    public CourseraPartnersPage getPartnersPage() {
        return partnersPage;
    }

    public GooglePlayPage getGooglePlayPage() {
        return googlePlayPage;
    }

    public CourseraSignupPage getSignupPage() {
        return signupPage;
    }

    public CourseraTermsOfUsePage getTermsOfUsePage() {
        return termsOfUsePage;
    }

    public CourseraPrivacyNoticePage getPrivacyNoticePage() {
        return privacyNoticePage;
    }

    public CourseraBlogPage getBlogPage() {
        return blogPage;
    }

    public CourseraPaymentsAndSubscriptionsPage getCourseraPaymentsAndSubscriptionsPage() {
        return courseraPaymentsAndSubscriptionsPage;
    }

    public CourseraChangeSubscriptionPlanPage getChangeSubscriptionPlanPage() {
        return changeSubscriptionPlanPage;
    }

    public CourseraPersonalDevelopmentPage getPersonalDevelopmentPage() {
        return personalDevelopmentPage;
    }

    public CourseraTryForFreeFormPage getTryForFreeFormPage() {
        return tryForFreeFormPage;
    }

    public CourseraLearnToTeachJavaPage getLearnToTeachJavaPage() {
        return learnToTeachJavaPage;
    }

    public CourseraForStudentsPage getForStudentsPage() {
        return forStudentsPage;
    }

    public TwitterLogInPage getTwitterLogInPage() {
        return twitterLogInPage;
    }

    public TweetPage getTweetPage() {
        return tweetPage;
    }

    public CourseraForBusinessPage getCourseraForBusiness() {
        return courseraForBusiness;
    }

    public GmailPage getGmailPage() {
        return gmailPage;
    }

    public CourseraRuPartnersPage getCourseraRuPartnersPage() {
        return courseraRuPartnersPage;
    }

    public CourseraYandexCoursesPage getCourseraYandexCoursesPage() {
        return courseraYandexCoursesPage;
    }

    public CourseraDevelopersPage getCourseraDevelopersPage() {
        return courseraDevelopersPage;
    }

    public CourseraCareersPage getCourseraCareersPage() {
        return courseraCareersPage;
    }

    public JobsLeverCoPage getJobsLeverCoPage() {
        return jobsLeverCoPage;
    }

    public CourseraCommunityPage getCourseraCommunityPage() {
        return courseraCommunityPage;
    }

    public CourseraAppStorePage getAppStorePage() {
        return appStorePage;
    }

    public CourseraOneFreeCoursePage getOneFreeCoursePage() {
        return oneFreeCoursePage;
    }

    public CourseraBasketCoursesPage getBasketCoursesPage() {
        return basketCoursesPage;
    }

    public FacebookSharePage getFacebookSharePage() {
        return facebookSharePage;
    }

    public CourseraCoursePage getCourseraCoursePage() {
        return courseraCoursePage;
    }


    @BeforeClass(alwaysRun = true)
    @Override
    public void setUp() {
        super.setUp();
        properties = PropertyDataReader.getProperties(System.getProperty("tests-data"));
        homePage = new CourseraHomePage();
        loginPage = new CourseraLoginPage();
        userPage = new CourseraUserPage();
        accountSettingsPage = new CourseraAccountSettingsPage();
        userVerificationPage = new CourseraUserVerificationPage();
        searchResultsPage = new CourseraSearchResultsPage();
        courseDescriptionPage = new CourseraCourseDescriptionPage();
        cartPage = new CourseraCartPage();
        helpCenterPage = new CourseraHelpCenterPage();
        contactPage = new CourseraContactPage();
        courseraGlobalMasterOfPublicHealthPage = new CourseraGlobalMasterOfPublicHealthPage();
        courseraInformationTechnologyPage = new CourseraInformationTechnologyPage();
        courseraNetworkingPage = new CourseraNetworkingPage();
        courseraSoftwareTestingPage = new CourseraSoftwareTestingPage();
        courseraForCampusPage = new CourseraForCampusPage();
        courseraCampusCoursematchPage = new CourseraCampusCoursematchPage();
        courseraTechnicalWritingPage = new CourseraTechnicalWritingPage();
        courseraEditorProfilePage = new CourseraEditorProfilePage();
        courseraInformationSystemsAuditingPage = new CourseraInformationSystemsAuditingPage();
        courseraCourseOverviewPage = new CourseraCourseOverviewPage();
        partnersPage = new CourseraPartnersPage();
        googlePlayPage = new GooglePlayPage();
        signupPage = new CourseraSignupPage();
        termsOfUsePage = new CourseraTermsOfUsePage();
        privacyNoticePage = new CourseraPrivacyNoticePage();
        blogPage = new CourseraBlogPage();
        courseraPaymentsAndSubscriptionsPage = new CourseraPaymentsAndSubscriptionsPage();
        changeSubscriptionPlanPage = new CourseraChangeSubscriptionPlanPage();
        personalDevelopmentPage = new CourseraPersonalDevelopmentPage();
        tryForFreeFormPage = new CourseraTryForFreeFormPage();
        learnToTeachJavaPage = new CourseraLearnToTeachJavaPage();
        forStudentsPage = new CourseraForStudentsPage();
        twitterLogInPage = new TwitterLogInPage();
        tweetPage = new TweetPage();
        courseraForBusiness = new CourseraForBusinessPage();
        gmailPage = new GmailPage();
        courseraEditorProfilePage = new CourseraEditorProfilePage();
        courseraInformationSystemsAuditingPage = new CourseraInformationSystemsAuditingPage();
        courseraCourseOverviewPage = new CourseraCourseOverviewPage();
        courseraRuPartnersPage = new CourseraRuPartnersPage();
        courseraYandexCoursesPage = new CourseraYandexCoursesPage();
        courseraDevelopersPage = new CourseraDevelopersPage();
        courseraCareersPage = new CourseraCareersPage();
        jobsLeverCoPage = new JobsLeverCoPage();
        courseraEditorProfilePage = new CourseraEditorProfilePage();
        courseraInformationSystemsAuditingPage = new CourseraInformationSystemsAuditingPage();
        courseraCourseOverviewPage = new CourseraCourseOverviewPage();
        courseraRuPartnersPage = new CourseraRuPartnersPage();
        courseraYandexCoursesPage = new CourseraYandexCoursesPage();
        courseraDevelopersPage = new CourseraDevelopersPage();
        courseraCareersPage = new CourseraCareersPage();
        jobsLeverCoPage = new JobsLeverCoPage();
        courseraCommunityPage = new CourseraCommunityPage();
        appStorePage = new CourseraAppStorePage();
        oneFreeCoursePage = new CourseraOneFreeCoursePage();
        basketCoursesPage = new CourseraBasketCoursesPage();
        facebookSharePage = new FacebookSharePage();
        courseraCoursePage = new CourseraCoursePage();
    }
}
