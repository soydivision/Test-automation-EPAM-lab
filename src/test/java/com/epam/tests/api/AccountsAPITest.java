package com.epam.tests.api;

import com.epam.core.enums.StatusCode;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.when;

public class AccountsAPITest {
    private static final String ACCOUNTS_URI = "https://accounts.coursera.org";
    private static final String AUTH_ENDPOINT = "/oauth2/v1/auth";

    @Test(priority = 1)
    public void canNotObtainAnAccessTokenWithoutQueryParams() {
        RestAssured.baseURI = ACCOUNTS_URI;
        when()
                .get(AUTH_ENDPOINT)
                .then().log().ifError()
                .assertThat()
                .statusCode(StatusCode.ERROR_400.getValue());
    }
}
