package com.epam.tests.api;

import com.epam.core.enums.StatusCode;
import com.epam.core.utilities.service.JsonService;
import com.epam.service.APICourseraOrgTestManager;
import com.epam.service.WWWCourseraOrgTestManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.equalTo;

public class WWWCourseraOrgTest extends WWWCourseraOrgTestManager {

    @Test
    public void courseraSubscriptionTypeTest() {
        RestAssured.baseURI = BASE_URI;

        given()
                .log().all()
                .param(APICourseraOrgTestManager.Q_PARAMETER, getQParamValueForSubscriptionTest())
                .param(ID_PARAM, getIdParamValueForSubscriptionTest() + getProductId())
                .when()
                .get(SUB_TYPE_TEST_ENDPOINT)
                .then()
                .log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .contentType(ContentType.JSON)
                .body("elements.findAll{it.underlyingProductId == ('"
                              + getIdParamValueForSubscriptionTest() + getProductId() + "')}.size() > 0",
                        is(true))
                .body("elements.findAll{it.id.contains('"
                              + getIdParamValueForSubscriptionTest() + "')}.size() > 0", is(true));
    }

    @Test
    public void courseraMetricsSpecializationTest() {
        RestAssured.baseURI = BASE_URI;

        given()
                .log().all()
                .urlEncodingEnabled(false)
                .param(APICourseraOrgTestManager.FIELDS_PARAMETER, getFieldsParamValueForMetricsSpecTest())
                .when()
                .get(METRICS_SPEC_TEST_ENDPOINT + getCourseId())
                .then()
                .log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .contentType(ContentType.JSON)
                .body("elements[0].id", equalTo("Specialization~" + getCourseId()))
                .body("elements[0].totalEnrollmentCount > 0", is(true));
    }

    @Test
    public void courseraAliceMessageTest() {
        RestAssured.baseURI = BASE_URI;

        given()
                .log().all()
                .param(APICourseraOrgTestManager.Q_PARAMETER, getQParamValueForAliceMsgTest())
                .param(EVENT_TYPE_PARAM, getEventTypeParamForAliceMsgTest())
                .param(CONTEXT_TYPE_PARAM, getContentTypeParamValueForAliceMsgTest())
                .when()
                .get(ALICE_MSG_TEST_ENDPOINT)
                .then()
                .log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .contentType(ContentType.JSON)
                .body("$", notNullValue());
    }

    @Test
    public void courseraCourseMatchTest() {
        File requestBody = JsonService.getJsonFile("body/request-body-course-match.json");
        RestAssured.baseURI = BASE_URI;

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(EVENTING_ENDPOINT)
                .then()
                .log().ifValidationFails()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .contentType(ContentType.TEXT)
                .body(containsString("{\"200\":[\"Success\"]}"));
    }

    @Test
    public void setOrUpdateUserPreferencesTest() {
        File requestBody = JsonService.getJsonFile("body/request-body-user-preferences.xml");
        RestAssured.baseURI = BASE_URI;

        given()
                .log().all()
                .queryParam(ACTION_PARAMETER, getActionParamValueForSetOrUpdateTest())
                .queryParam(SESSION_ID_PARAMETER, getSessionIdValueForSetOrUpdateTest())
                .queryParam(PRODUCT_ID_PARAMETER, getProductIdValueForSetOrUpdateTest())
                .body(requestBody)
                .post(USER_PREFERENCE_ENDPOINT)
                .then()
                .log().ifValidationFails()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .contentType(ContentType.JSON)
                .body(equalTo("{}"));
    }

    @Test
    public void courseraBannerClosingTest() {
        File requestBody = JsonService.getJsonFile("body/request-body-banner-closing.json");
        RestAssured.baseURI = BASE_URI;

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(EVENTING_ENDPOINT)
                .then()
                .log().ifValidationFails()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .contentType(ContentType.TEXT)
                .body(containsString("{\"200\":[\"Success\"]}"));
    }
}
