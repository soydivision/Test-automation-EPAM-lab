package com.epam.tests.api;

import com.epam.core.enums.StatusCode;
import com.epam.service.MasterTrackCertificatesTestManager;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class MasterTrackCertificatesTest extends MasterTrackCertificatesTestManager {

    @Test(priority = 1)
    public void courseraMasterTrackCertificatesTest() {
        RestAssured.baseURI = BASE_URL;

        given()
                .log().all()
                .header(REQUEST_METHOD_HEADER, getAccessControlRequestMethodHeaderValue())
                .header(REQUEST_HEADER, getAccessControlRequestHeaderValue())
                .header(ORIGIN_HEADER, getOriginHeaderValue())
                .options()
                .then()
                .log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .header("Access-Control-Allow-Methods", getAccessControlRequestMethodHeaderValue())
                .header("Access-Control-Allow-Credentials", "true");
    }
}
