package com.epam.tests.openingpages;

import com.epam.service.PagesManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RelevantScoreOrderTest extends PagesManager {

    @Test(description = "Relevant score in 'Coursera CourseMathch' is appeared in the right order",
            groups = "critical path")
    public void relevantScoreOnCampusCourseMatchTest() {
        getCourseraForCampusPage().openPage();
        getCourseraForCampusPage().clickCoursematchButton();
        getCourseraCampusCoursematchPage().closeForm();
        Assert.assertTrue(getCourseraCampusCoursematchPage().areElementsFromRelevantScoreInDescendingOrder(),
                "Values from relevant score column of the table are not in descending order!");
    }
}
