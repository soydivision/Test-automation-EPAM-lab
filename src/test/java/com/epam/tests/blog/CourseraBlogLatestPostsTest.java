package com.epam.tests.blog;

import com.epam.service.PagesManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CourseraBlogLatestPostsTest extends PagesManager {

    @Test(description = "Verify that at least one hundred latest posts of coursera blog are in descending order",
            groups = "advanced")
    public void latestPostsOfCourseraBlogAreInDescendingOrder() {
        getHomePage().openPage();
        getHomePage().clickCourseraBlogLink();
        List<LocalDate> dateList = getBlogPage().getDatesOfLatestPostsAsListOfLocalDate();
        List<LocalDate> unsortedDateList = new ArrayList<>(dateList);
        dateList.sort(Collections.reverseOrder());
        Assert.assertEquals(unsortedDateList, dateList, "Dates are not in descending order");
    }
}
