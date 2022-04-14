package com.epam.tests.api;

import com.epam.core.enums.StatusCode;
import com.epam.service.PagesManager;
import com.epam.service.UsersManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import static com.epam.core.utilities.service.JsonService.getJsonFile;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class DisableNotificationsTest extends PagesManager {
    private static final String BODY = "body/request-body-disable-notifications.json";
    private static final String SCHEMA = "schema/disable-notifications-schema.json";
    private static final String BASE_URI = "https://www.coursera.org/api/userNoteGlobalSettings.v1/80990376";
    private static final String COOKIE_NAME = "CAUTH";

    @Test
    public void disableNotifications() {
        getHomePage().openPage();
        getHomePage().clickLoginButton();
        getLoginPage().loginWithGoogleAccount(UsersManager.getUserEmailU());
        getUserPage().waitUntilUserIsLoggedIn();
        Cookie cookie = getDriver().manage().getCookieNamed(COOKIE_NAME);
        RestAssured.baseURI = BASE_URI;
        given().body(getJsonFile(BODY))
                .contentType(ContentType.JSON)
                .cookie(String.valueOf(cookie))
                .when().put()
                .then().log().ifError().assertThat().statusCode(StatusCode.OK_200.getValue())
                .contentType(ContentType.JSON)
                .body(matchesJsonSchema(getJsonFile(SCHEMA)));
    }
}
