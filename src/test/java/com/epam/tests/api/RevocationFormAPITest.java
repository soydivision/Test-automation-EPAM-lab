package com.epam.tests.api;

import com.epam.core.enums.StatusCode;
import com.epam.core.utilities.service.JsonService;
import com.epam.service.WWWCourseraOrgTestManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class RevocationFormAPITest extends WWWCourseraOrgTestManager {
    private static final String FIELDS_ACTION = "createOrUpdate";
    private static final String FIELDS_PRODUCT_ID = "GenericPage~credentialtracks";
    private static final String END_POINT_FORM_API = "/api/qualificationSurveySectionResponses.v2";
    private static final String DATA_FOR_FILLING_FORM_CREATION = "body/request-body-filled-data-form.json";


    @Test
    public void getFillingRevocationForm() {
        File requestBody = JsonService.getJsonFile(DATA_FOR_FILLING_FORM_CREATION);
        RestAssured.baseURI = BASE_URI;
        given()
                .urlEncodingEnabled(false)
                .queryParam(ACTION_PARAMETER, FIELDS_ACTION)
                .queryParam(PRODUCT_ID_PARAMETER, FIELDS_PRODUCT_ID)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(END_POINT_FORM_API)
                .then().log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .body("id != null", is(true))
                .body("section.definition.body"
                        + ".definition.value.contains('Thank you for requesting information')", is(true));
    }
}
