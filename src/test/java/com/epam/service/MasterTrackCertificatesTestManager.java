package com.epam.service;

public class MasterTrackCertificatesTestManager {

    public static final String BASE_URL = "https://segments.company-target.com";
    public static final String REQUEST_METHOD_HEADER = "Access-Control-Request-Method";
    public static final String REQUEST_HEADER = "Access-Control-Request-Headers";
    public static final String ORIGIN_HEADER = "Origin";
    private String accessControlRequestMethodHeaderValue = "GET";
    private String accessControlRequestHeaderValue = "content-type";
    private String originHeaderValue = "https://www.coursera.org";

    public String getOriginHeaderValue() {
        return originHeaderValue;
    }

    public String getAccessControlRequestHeaderValue() {
        return accessControlRequestHeaderValue;
    }

    public String getAccessControlRequestMethodHeaderValue() {
        return accessControlRequestMethodHeaderValue;
    }
}
