package com.epam.tests.partners;

import com.epam.core.utilities.property.PropertyDataReader;
import com.epam.service.PagesManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CourseraParticularPartnerTest extends PagesManager {

    @Test(description = "Partner courses are offered by particular partner", groups = "critical path")
    public void checkOffersForCourseTest() {
        String partnerName = PropertyDataReader.getProperties("tests-data").getProperty("partner");
        getHomePage().openPage();
        getHomePage().clickPartnersLink();
        getPartnersPage().getRussianPartners();
        getCourseraRuPartnersPage().clickYandexButton();
        getCourseraYandexCoursesPage().selectBigDataApplicationsCourse();
        Assert.assertEquals(getCourseraYandexCoursesPage().getPartnerTitleValue(), partnerName,
                "This course isn't offered by " + partnerName + "!");
    }
}
