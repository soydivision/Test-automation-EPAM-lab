package com.epam.tests.partners;

import com.epam.service.PagesManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CourseraPartnersNumberTest extends PagesManager {

    @Test(description = "Verify that at coursera partners page correct number of partners is displayed",
            groups = "critical path")
    public void partnersNumberTest() {
        getHomePage().openPage();
        getHomePage().clickPartnersLink();
        Assert.assertEquals(getPartnersPage().getPartnersNumber(), getPartnersPage().getNumberOfPartnersLogos(),
                "Partners number and number of partners logos are not equals");
    }
}
