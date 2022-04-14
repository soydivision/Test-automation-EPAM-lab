package com.epam.tests.openingpages;

import com.epam.core.utilities.service.LinksService;
import com.epam.service.PagesManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomePageLinksOpen extends PagesManager {

    @Test(description = "checks if home page links open", groups = "smoke")
    public void homePageLinksOpen() {
        getHomePage().openPage();
        List<String> excludedLinks = new ArrayList<String>(Arrays.asList(getProperties().getProperty(
                "excluded.websites.to.check").split(" ")));
        excludedLinks.remove("");
        List<String> cleanListOfLinks = LinksService.removeExcludedLinks(LinksService.getAllLinksOnPage(),
                (ArrayList<String>) excludedLinks);
        List<String> brokenLinks = LinksService.checkLinks(cleanListOfLinks);
        Assert.assertTrue(brokenLinks.isEmpty());
    }
}


