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
import static com.epam.core.utilities.service.JsonService.getJsonFile;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.containsString;

public class GraphQIAPITest extends WWWCourseraOrgTestManager {
    private static final String GRAPHQL_ENDPOINT = "/graphqlBatch";
    private static final String ALL_DOMAINS_BODY = "body/request-body-for-all-domains-graph.json";
    private static final String BANNER_BODY = "body/request-body-for-banner-graph.json";
    private static final String CERTIFICATES_BODY = "body/request-body-for-certificates-graph.json";
    private static final String BANNER_SCHEMA = "schema/banner-graph-schema.json";
    private static final String DOMAINS_SCHEMA = "schema/domains-graph-schema.json";
    private static final String CERTIFICATES_SCHEMA = "schema/certificates-graph-schema.json";
    private static final String MULTIPLE_GET_PARTNERS_FILENAME = "body/request-body-for-multiple-get-partners.json";
    private static final String MEGA_MENU_QUERY_FILENAME = "body/request-body-for-mega-menu-query.json";
    private static final String MULTIPLE_GET_PARTNERS_SCHEMA = "schema/multiple-get-partners-schema.json";
    private static final String MEGA_MENU_QUERY_SCHEMA = "schema/mega-menu-query-schema.json";

    @Test
    public void canReceiveAllDomains() {
        RestAssured.baseURI = BASE_URI;
        given().body(getJsonFile(ALL_DOMAINS_BODY))
                .contentType(ContentType.JSON)
                .when().post(GRAPHQL_ENDPOINT)
                .then().log().ifError().assertThat().statusCode(StatusCode.OK_200.getValue())
                .contentType(ContentType.JSON)
                .body(matchesJsonSchema(getJsonFile(DOMAINS_SCHEMA)));
    }

    @Test
    public void canReceiveBannerAdCampaignsData() {
        RestAssured.baseURI = BASE_URI;
        given().body(getJsonFile(BANNER_BODY))
                .contentType(ContentType.JSON)
                .when().post(GRAPHQL_ENDPOINT)
                .then().log().ifError().assertThat().statusCode(StatusCode.OK_200.getValue())
                .contentType(ContentType.JSON)
                .body(matchesJsonSchema(getJsonFile(BANNER_SCHEMA)));
    }

    @Test
    public void canReceiveProfessionalCertificatesData() {
        RestAssured.baseURI = BASE_URI;
        given().body(getJsonFile(CERTIFICATES_BODY))
                .contentType(ContentType.JSON)
                .when().post(GRAPHQL_ENDPOINT)
                .then().log().ifError().assertThat().statusCode(StatusCode.OK_200.getValue())
                .contentType(ContentType.JSON)
                .body(matchesJsonSchema(getJsonFile(CERTIFICATES_SCHEMA)));
    }

    @Test
    public void canPostRequestWithMultipleGetPartnersIdsAndReceiveTheirNames() {
        File requestBody = JsonService.getJsonFile(MULTIPLE_GET_PARTNERS_FILENAME);
        RestAssured.baseURI = BASE_URI;
        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(GRAPHQL_ENDPOINT)
                .then().log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .contentType(ContentType.JSON)
                .body("data.PartnersV1Resource.multiGet.elements[0].name.size()", equalTo(JsonPath
                        .from(requestBody).get("variables.ids[0].size()")))
                .body(JsonSchemaValidator.matchesJsonSchema(JsonService.getJsonFile(MULTIPLE_GET_PARTNERS_SCHEMA)));
    }

    @Test
    public void canPostMegaMenuQueryRequestWithDomainIdAndGetSubdomainElements() {
        File requestBody = JsonService.getJsonFile(MEGA_MENU_QUERY_FILENAME);
        RestAssured.baseURI = BASE_URI;
        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(GRAPHQL_ENDPOINT)
                .then().log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .contentType(ContentType.JSON)
                .body("data.DomainsV1Resource.domains.elements.id", equalTo(JsonPath
                        .from(requestBody).get("variables.ids")))
                .body("data.DomainsV1Resource.domains.elements[0].subdomains.elements[0].size()>0", is(true))
                .body("data.DomainsV1Resource.domains.elements[0].subdomains.paging.total[0]>0", is(true))
                .body(JsonSchemaValidator.matchesJsonSchema(JsonService.getJsonFile(MEGA_MENU_QUERY_SCHEMA)));
    }

    @Test
    public void collectionQueryTest() {
        File requestBody = JsonService.getJsonFile("body/request-body-collection-query.json");
        RestAssured.baseURI = BASE_URI;
        String firstWordInCollectionName = getFirstWordInCollectionName(requestBody);

        given()
                .log().all()
                .queryParam(OPNAME_PARAMETER, getOpnameParameterValueForCollectionQueryTest())
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(GRAPHQL_ENDPOINT)
                .then()
                .log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .contentType(ContentType.JSON)
                .body(JsonSchemaValidator.matchesJsonSchema(
                        JsonService.getJsonFile("schema/collection-query-schema.json")))
                .body("data.BrowseCollectionsV1Resource.byCollections.elements[0].s12ns.elements[0].name[0]",
                        containsString(firstWordInCollectionName));
    }

    @Test
    public void collectionRecommendationsQueryTest() {
        File requestBody = JsonService.getJsonFile("body/request-body-collection-recommendations-query.json");
        RestAssured.baseURI = BASE_URI;

        given()
                .log().all()
                .queryParam(OPNAME_PARAMETER, getOpnameParameterValueForCollectionRecommendationsQueryTest())
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(GRAPHQL_ENDPOINT)
                .then()
                .log().ifError()
                .assertThat()
                .statusCode(StatusCode.OK_200.getValue())
                .contentType(ContentType.JSON)
                .body(JsonSchemaValidator.matchesJsonSchema(
                        JsonService.getJsonFile("schema/collection-recommendations-query-schema.json")))
                .body("data.BrowseCollectionsV1Resource.byCollections.elements[0].entries.flatten().unique().size()",
                        equalTo(JsonPath.from(requestBody).get("variables.numEntriesPerCollection[0]")));
    }
}
