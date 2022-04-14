package com.epam.tests.job;

import com.epam.service.PagesManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JobPageFilterTest extends PagesManager {

    @Test(description = "Filter on https://jobs.lever.co/ page works correctly", groups = "advanced")
    public void jobsLeverCoPageFilterTest() {
        String location = getProperties().getProperty("location");
        String team = getProperties().getProperty("team");
        getHomePage().openPage();
        getHomePage().clickDevelopersLink();
        getCourseraDevelopersPage().clickViewOpenPositionsButton();
        getCourseraCareersPage().clickStudentsAndNewGradsButton();
        getCourseraCareersPage().clickSearchOpenRolesLink();
        getJobsLeverCoPage().selectLocation();
        getJobsLeverCoPage().selectTeam();
        Assert.assertTrue(getJobsLeverCoPage().doesFilterResultContainLocationAndTeamValues(location, team),
                "Filter result doesn't contain location: " + location + " and team: " + team);
    }
}
