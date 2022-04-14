package com.epam.core.utilities.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public final class WaitersService {
    private static final int TIMEOUT = 20;
    private static final int MILLISECONDS_TIMEOUT = 4000;

    private WaitersService() {
    }

    public static void waitUntilVisibilityOfAllElements(final WebDriver driver, final List<WebElement> elements) {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public static WebElement waitUntilPresenceOfElementAndReturn(final WebDriver driver, final By by) {
        WebElement element = new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(by));
        return element;
    }

    public static void waitForElementToBeClickable(final WebDriver driver, final WebElement element) {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForVisibilityOfElement(final WebDriver driver, final WebElement element) {
        new WebDriverWait(driver, TIMEOUT)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilPageIsCompletelyLoaded(final WebDriver driver) {
        new WebDriverWait(driver, TIMEOUT).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete"));
    }

    public static void waitForVisibilityOfElementCustomTimeout(final WebDriver driver,
                                                               final WebElement element, final int timeout) {
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForListOfWebElementsVisibility(final WebDriver driver,
                                                           final List<WebElement> webElements) {
        new WebDriverWait(driver, TIMEOUT)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOfAllElements(webElements));
    }

    public static void waitUntilUrlContains(final WebDriver driver, final String url) {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.urlContains(url));
    }

    public static void threadSleep() {
        try {
            Thread.sleep(MILLISECONDS_TIMEOUT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
