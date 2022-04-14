package com.epam.tests.openingpages;

import com.epam.service.PagesManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsPageOpensTest extends PagesManager {
    private static final String HEADER_TEXT = "Contact Us";

    @Test(description = "checks if contact us page can be opened", groups = "smoke")
    public void contactUsPageOpens() {
        getHomePage().openPage();
        getHomePage().scrollDownToBottom();
        getHomePage().clickContactButton();
        String headerText = getContactPage().getHeaderText();
        Assert.assertEquals(headerText, HEADER_TEXT, "Header text is incorrect");
    }
}
