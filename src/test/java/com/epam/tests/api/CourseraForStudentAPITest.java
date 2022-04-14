package com.epam.tests.api;

import com.epam.core.enums.StatusCode;
import com.epam.core.utilities.service.JsonService;
import com.epam.service.WWWCourseraOrgTestManager;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import java.io.File;
import static io.restassured.RestAssured.given;

public class CourseraForStudentAPITest extends WWWCourseraOrgTestManager {
    private static final String END_POINT_COURSERA_FOR_STUDENT_API = "/api/customUrls.v1";
    private static final String COURSERA_FOR_STUDENT_CREATION = "body/request-body-coursera-for-student.json";


    @Test
    public void getCourseraForStudent() {
        File requestBody = JsonService.getJsonFile(COURSERA_FOR_STUDENT_CREATION);
        RestAssured.baseURI = BASE_URI;
        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(END_POINT_COURSERA_FOR_STUDENT_API)
                .then().log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_201.getValue())
                .body("elements.targetUrl[0]", equalTo(JsonPath.from(requestBody).get("targetUrl")));
    }
}
