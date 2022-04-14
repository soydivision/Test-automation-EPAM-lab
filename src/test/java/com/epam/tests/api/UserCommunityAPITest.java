package com.epam.tests.api;

import com.epam.core.enums.StatusCode;
import com.epam.core.utilities.service.JsonService;
import com.epam.service.CommunityCourseraTestManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import java.io.File;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;

public class UserCommunityAPITest extends CommunityCourseraTestManager {
    private static final Integer USER_ID = 39;
    private static final String END_POINT_ID_API = "/member/getUsersById";
    private static final String PHRASES = "phrases";
    private static final String LANGUAGE = "Language";
    private static final String FORMATTING_STYLES = "Formatting Styles";
    private static final String END_POINT_PHRASES_API = "/phrase/batch";
    private static final String END_POINT_HELPFUL_API = "/helpfulness/vote";
    private static final String HELPFULNESS_CREATION = "body/request-body-helpfulness.json";

    @Test
    public void getUserById() {
        RestAssured.baseURI = BASE_URI;
        given()
                .urlEncodingEnabled(false)
                .param(USER_ID_PARAMETER, USER_ID)
                .when()
                .get(END_POINT_ID_API)
                .then().log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .body("39.id", equalTo(USER_ID));
    }

    @Test
    public void getFormForWritingNewPost() {
        RestAssured.baseURI = BASE_URI;
        given()
                .urlEncodingEnabled(false)
                .param(PHRASES, PHRASES_PARAMETER)
                .when()
                .get(END_POINT_PHRASES_API)
                .then().log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .body("Forum != null", is(true))
                .body("Common.'editor.code.language'", equalTo(LANGUAGE))
                .body("Common.'editor.formatting.styles'", equalTo(FORMATTING_STYLES));
    }

    @Test
    public void votingTheTopicAsHelpful() {
        RestAssured.baseURI = BASE_URI;
        File requestBody = JsonService.getJsonFile(HELPFULNESS_CREATION);
        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(END_POINT_HELPFUL_API)
                .then().log().ifError()
                .assertThat().statusCode(StatusCode.OK_200.getValue())
                .body("class == null", is(true));
    }
}

