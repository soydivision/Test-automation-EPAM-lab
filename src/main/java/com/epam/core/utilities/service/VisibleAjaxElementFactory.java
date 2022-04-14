package com.epam.core.utilities.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.AjaxElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import java.lang.reflect.Field;

public class VisibleAjaxElementFactory implements ElementLocatorFactory {
    private final WebDriver driver;
    private final int timeOutInSeconds;

    public VisibleAjaxElementFactory(final WebDriver driver, final int timeOutInSeconds) {
        this.driver = driver;
        this.timeOutInSeconds = timeOutInSeconds;
    }

    @Override
    public ElementLocator createLocator(final Field field) {
        return new VisibleAjaxElementLocator(driver, field, timeOutInSeconds);
    }

    private static class VisibleAjaxElementLocator extends AjaxElementLocator {

        VisibleAjaxElementLocator(final WebDriver driver, final Field field, final int timeOutInSeconds) {
            super(driver, field, timeOutInSeconds);
        }

        @Override
        protected boolean isElementUsable(final WebElement element) {
            if (element == null) {
                return false;
            }
            return element.isDisplayed() && element.isEnabled();
        }
    }
}
