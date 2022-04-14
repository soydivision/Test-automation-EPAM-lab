package com.epam.tests.openingpages;

import com.epam.service.PagesManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GlobalMasterHealthPageOpensTest extends PagesManager {
    private static final String HEADER_TEXT = "Global Master of Public Health (GMPH)";

    @Test(description = "opens global master of public health course page through explore menu", groups = "smoke")
    public void globalMasterHealthPageOpens() {
        getHomePage().openPage();
        getHomePage().clickGlobalMasterButton();
        String headerText = getCourseraGlobalMasterOfPublicHealthPage().getHeaderText();
        Assert.assertEquals(headerText, HEADER_TEXT, "Header text doesn't match. Page doesn't opened");
    }
}
