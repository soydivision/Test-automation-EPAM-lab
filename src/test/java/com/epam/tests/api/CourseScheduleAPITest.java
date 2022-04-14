package com.epam.tests.api;

import com.epam.core.enums.StatusCode;
import com.epam.service.WWWCourseraOrgTestManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class CourseScheduleAPITest extends WWWCourseraOrgTestManager {
    private static final String END_POINT_SCHEDULE_API = "/api/learnerCourseSchedules.v1/undefined";


    @Test
    public void getLearnerCourseScheduleNegative() {
        RestAssured.baseURI = BASE_URI;
        given()
                .when().get(END_POINT_SCHEDULE_API)
                .then().log().ifError()
                .assertThat()
                .statusCode(StatusCode.ERROR_404.getValue())
                .contentType(ContentType.JSON)
                .body("statusCode==404", is(true));
    }
}
