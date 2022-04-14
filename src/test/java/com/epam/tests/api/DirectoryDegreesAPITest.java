package com.epam.tests.api;

import com.epam.core.enums.StatusCode;
import com.epam.core.utilities.service.JsonService;
import com.epam.service.WWWCourseraOrgTestManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import java.io.File;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class DirectoryDegreesAPITest extends WWWCourseraOrgTestManager {
    private static final String END_POINT_DEGREES_DATA = "/graphqlBatch";
    private static final String FIELD_OPNAME = "CatalogDegreeData";
    private static final String DATA_DEGREES_CREATION = "body/request-boby-data-degrees.json";
    private static final String DATA_CATALOG_RESPONSE_SCHEMA = "schema/response-boby-schema-data-catalog-degrees.json";


    @Test
    public void checkCatalogDegreesData() {
        File requestBody = JsonService.getJsonFile(DATA_DEGREES_CREATION);
        File responseBodySchema = JsonService.getJsonFile(DATA_CATALOG_RESPONSE_SCHEMA);
        RestAssured.baseURI = BASE_URI;
        given()
                .queryParam(OPNAME_PARAMETER, FIELD_OPNAME)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(END_POINT_DEGREES_DATA)
                .then().log().ifError()
                .statusCode(StatusCode.OK_200.getValue())
                .contentType(ContentType.JSON)
                .body(matchesJsonSchema(responseBodySchema));
    }
}
