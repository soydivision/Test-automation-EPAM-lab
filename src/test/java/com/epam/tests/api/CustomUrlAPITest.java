package com.epam.tests.api;

import com.epam.core.enums.StatusCode;
import com.epam.core.utilities.service.JsonService;
import com.epam.service.WWWCourseraOrgTestManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import java.io.File;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class CustomUrlAPITest extends WWWCourseraOrgTestManager {
    private static final String CUSTOM_URLS_ENDPOINT = "/api/customUrls.v1";
    private static final String CUSTOM_URL_CREATION_FILENAME = "body/request-body-for-custom-url-creation.json";
    private static final String CUSTOM_URL_SCHEMA = "schema/custom-url-schema.json";

    @Test
    public void canPostRequestToCreateCustomUrlAndReceiveCorrectStatusCode() {
        File requestBody = JsonService.getJsonFile(CUSTOM_URL_CREATION_FILENAME);
        RestAssured.baseURI = BASE_URI;
        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(CUSTOM_URLS_ENDPOINT)
                .then().log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_201.getValue())
                .contentType(ContentType.JSON)
                .body("elements.targetUrl[0]", equalTo(JsonPath.from(requestBody).get("targetUrl")))
                .body(JsonSchemaValidator.matchesJsonSchema(JsonService.getJsonFile(CUSTOM_URL_SCHEMA)));
    }
}
