package com.epam.service;

public class CourseraLearnerHelpAPITestManager {

    public static final String LEARNER_HELP_URI = "https://learner.coursera.help";
    public static final String ENDPOINT_FOR_LEARNER_HELP_TEST = "/api/v2/help_center/en-us/articles.json";
    public static final String PER_PAGE_PARAMETER = "per_page";
    private String perPageParameterValue = "10";

    public String getPerPageParameterValue() {
        return perPageParameterValue;
    }
}
