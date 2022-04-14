package com.epam.service;

import com.epam.core.utilities.service.StringService;
import io.restassured.path.json.JsonPath;
import java.io.File;

public class WWWCourseraOrgTestManager {

    public static final String BASE_URI = "https://www.coursera.org";
    public static final String SUB_TYPE_TEST_ENDPOINT = "/api/productSkus.v1";
    public static final String METRICS_SPEC_TEST_ENDPOINT = "/api/productMetrics.v1/Specialization~";
    public static final String ALICE_MSG_TEST_ENDPOINT = "/api/aliceMessages.v1/";
    public static final String EVENTING_ENDPOINT = "/eventing/infoBatch.v2";
    public static final String USER_PREFERENCE_ENDPOINT = "/api/userPreferences.v1/";
    public static final String ID_PARAM = "id";
    public static final String EVENT_TYPE_PARAM = "eventType";
    public static final String CONTEXT_TYPE_PARAM = "contextType";
    public static final String ACTION_PARAMETER = "action";
    public static final String PRODUCT_ID_PARAMETER = "productId";
    public static final String OPNAME_PARAMETER = "opname";
    public static final String SESSION_ID_PARAMETER = "sessionId";
    private String qParamValueForSubscriptionTest = "findByUnderlying";
    private String idParamValueForSubscriptionTest = "CourseraPlusSubscription~";
    private String fieldsParamValueForMetricsSpecTest = "id,productPageViewsInLastMonthCount,totalEnrollmentCount";
    private String qParamValueForAliceMsgTest = "byContextAndEventType";
    private String eventTypeParamForAliceMsgTest = "PAGEVIEW";
    private String contentTypeParamValueForAliceMsgTest = "LOGGED_IN_DASHBOARD";
    private String courseId = "M4k2FiN0EeqnFRLwbdubGw";
    private String productId = "Nf1hONLKQjyXSmwOh0KGyQ";
    private String actionParamValueForSetOrUpdateTest = "setOrUpdateRecentlyViewedXDP";
    private String sessionIdValueForSetOrUpdateTest = "SESSION~2696558095";
    private String productIdValueForSetOrUpdateTest = "SPECIALIZATION~M4k2FiN0EeqnFRLwbdubGw";
    private String opnameParameterValueForCollectionQueryTest = "CollectionQuery";
    private String opnameParameterValueForCollectionRecommendationsQueryTest = "CollectionRecommendationsQuery";

    public String getOpnameParameterValueForCollectionRecommendationsQueryTest() {
        return opnameParameterValueForCollectionRecommendationsQueryTest;
    }

    public String getOpnameParameterValueForCollectionQueryTest() {
        return opnameParameterValueForCollectionQueryTest;
    }

    public String getProductIdValueForSetOrUpdateTest() {
        return productIdValueForSetOrUpdateTest;
    }

    public String getSessionIdValueForSetOrUpdateTest() {
        return sessionIdValueForSetOrUpdateTest;
    }

    public String getActionParamValueForSetOrUpdateTest() {
        return actionParamValueForSetOrUpdateTest;
    }

    public String getProductId() {
        return productId;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getContentTypeParamValueForAliceMsgTest() {
        return contentTypeParamValueForAliceMsgTest;
    }

    public String getEventTypeParamForAliceMsgTest() {
        return eventTypeParamForAliceMsgTest;
    }

    public String getQParamValueForAliceMsgTest() {
        return qParamValueForAliceMsgTest;
    }

    public String getFieldsParamValueForMetricsSpecTest() {
        return fieldsParamValueForMetricsSpecTest;
    }

    public String getQParamValueForSubscriptionTest() {
        return qParamValueForSubscriptionTest;
    }

    public String getIdParamValueForSubscriptionTest() {
        return idParamValueForSubscriptionTest;
    }

    public String getFirstWordInCollectionName(final File requestBody) {
        String firstWordInCollectionName = StringService.getFirstWordFromString((JsonPath.from(requestBody)
                .get("variables.contextId[0]")), "-");
        firstWordInCollectionName = StringService.getCapitalizedWord(firstWordInCollectionName);
        return firstWordInCollectionName;
    }
}
