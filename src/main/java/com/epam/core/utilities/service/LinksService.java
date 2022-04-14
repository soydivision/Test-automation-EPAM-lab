package com.epam.core.utilities.service;

import com.epam.core.webdriver.factory.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class LinksService {
    private static final int INVALID_RESPONSE_CODE = 400;
    private static final Logger LOGGER = LogManager.getRootLogger();

    private  LinksService() {
    }

    public static ArrayList<String> getAllLinksOnPage() {
        LOGGER.info("Getting all links on page with getAllLinksOnPage()");
        WaitersService.waitUntilPageIsCompletelyLoaded(DriverManager.getDriver());
        WaitersService.threadSleep();
        List<WebElement> links = DriverManager.getDriver().findElements(By.tagName("a"));
        List<String> linksArrayList = new ArrayList<>();
        for (WebElement link : links) {
            if (link.getAttribute("href") != null) {
                linksArrayList.add(link.getAttribute("href"));
            }
        }
        linksArrayList.removeAll(Collections.singleton(null));
        return (ArrayList<String>) linksArrayList;
    }

    public static boolean isValidLink(final String url) {
        LOGGER.info("validating link: " + url);
        if (url != null) {
            boolean isValidLink = false;
            if ((!isValidLinkCheckingWithRequestMethod(url, "HEAD"))
                    && (!isValidLinkCheckingWithRequestMethod(url, "GET"))) {
                isValidLink = isLinkValidCheckInANewTab(url);
            } else {
                isValidLink = true;
                LOGGER.info("link: " + url + " is valid");
            }
            return isValidLink;
        } else {
            return false;
        }
    }

    public static boolean isValidLinkCheckingWithRequestMethod(final String url, final String requestMethod) {
        boolean isValidLink = false;
        HttpURLConnection httpURLConnection = null;
        int responseCode = 0;
        if (url == null || url.isEmpty()) {
            return isValidLink;
        } else {
            try {
                httpURLConnection = (HttpURLConnection) (new URL(url).openConnection());
                httpURLConnection.setRequestMethod(requestMethod);
                httpURLConnection.connect();
                responseCode = httpURLConnection.getResponseCode();
                if (responseCode >= INVALID_RESPONSE_CODE) {
                    isValidLink = false;
                } else {
                    isValidLink = true;
                }
            } catch (IOException exception) {
                exception.printStackTrace();
                LOGGER.error("isValidLinkCheckingWithRequestMethod failed due to IOException" + exception.getMessage());
            }
        }
        httpURLConnection = null;
        return isValidLink;
    }

    public static boolean isLinkValidCheckInANewTab(final String url) {
        LOGGER.info("Checking link " + url + " in a new tab.");
        TabsSwitcher.createNewTabAndSwitchToIt(DriverManager.getDriver());
        DriverManager.getDriver().get(url);
        boolean pageLoaded = false;
        WaitersService.waitUntilPageIsCompletelyLoaded(DriverManager.getDriver());
        if (DriverManager.getDriver().getCurrentUrl().equals(url)) {
            pageLoaded = true;
        }
        return pageLoaded;
    }

    public static ArrayList<String> removeExcludedLinks(final ArrayList<String> linksOnPage,
                                                        final ArrayList<String> excludedLinks) {
        LOGGER.info("Removing excluded links from list of all links");
        List<String> cleanList = new ArrayList<>();
        if (excludedLinks.isEmpty()) {
            cleanList = linksOnPage;
        } else {
            for (String linkOnPage : linksOnPage) {
                int exclusionCounter = 0;
                for (int i = 0; i < excludedLinks.size(); i++) {
                    if (linkOnPage.contains(excludedLinks.get(i))) {
                        exclusionCounter++;
                    }
                }
                if (exclusionCounter == 0) {
                    cleanList.add(linkOnPage);
                }
            }
        }
        return (ArrayList<String>) cleanList;
    }

    public static ArrayList<String> checkLinks(final List<String> links) {
        List<String> brokenLinks = new ArrayList<>();
        for (String link : links) {
            if (!isValidLink(link)) {
                brokenLinks.add(link);
            }
        }
        if (!brokenLinks.isEmpty()) {
            LOGGER.info("Broken links are:" + brokenLinks);
        }
        return (ArrayList<String>) brokenLinks;
    }
}
