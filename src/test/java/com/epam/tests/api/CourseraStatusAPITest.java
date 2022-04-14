package com.epam.tests.api;

import com.epam.core.enums.StatusCode;
import com.epam.service.StatusCourseraOrgTestManager;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class CourseraStatusAPITest extends StatusCourseraOrgTestManager {
    private static final String END_POINT_STATUS_API = "/api/v2/status.json";


    @Test
    public void getCourseraStatus() {
        RestAssured.baseURI = BASE_URI;
        given()
                .when().get(END_POINT_STATUS_API)
                .then().log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .body("status.size()>0", is(true));
    }
}
