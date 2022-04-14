package com.epam.tests.api;

import com.epam.core.enums.StatusCode;
import com.epam.service.CourseraLearnerHelpAPITestManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class LearnerHelpAPITest extends CourseraLearnerHelpAPITestManager {

    @Test
    public void courseraLearnerHelpAPITest() {
        RestAssured.baseURI = LEARNER_HELP_URI;

        given().log().all()
                .param(PER_PAGE_PARAMETER, getPerPageParameterValue())
                .when()
                .get(ENDPOINT_FOR_LEARNER_HELP_TEST)
                .then()
                .log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .contentType(ContentType.JSON)
                .body("per_page == " + getPerPageParameterValue(), is(true));
    }
}
