package com.epam.tests.api;

import com.epam.core.enums.StatusCode;
import com.epam.service.APICourseraOrgTestManager;
import com.epam.service.WWWCourseraOrgTestManager;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CourseMaterialsAPITest extends WWWCourseraOrgTestManager {
    private static final String END_POINT_MATERIALS_API = "/api/onDemandCourseMaterials.v2/";
    private static final String ID = "JLygJMCgEeWP5g5dlaZx4w";
    private static final String MODULE_IDS = "moduleIds";


    @Test
    public void getCourseMaterialsId() {
        RestAssured.baseURI = BASE_URI;
        given().param(APICourseraOrgTestManager.FIELDS_PARAMETER, MODULE_IDS)
                .when().get(END_POINT_MATERIALS_API + ID)
                .then().log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .body("elements.id.get(0)", equalTo(ID))
                .body("elements.moduleIds.size()>0", is(true));
    }
}
