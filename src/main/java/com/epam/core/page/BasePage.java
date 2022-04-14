package com.epam.core.page;

import com.epam.core.utilities.service.VisibleAjaxElementFactory;
import com.epam.core.webdriver.factory.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    private static final int TIMEOUT = 10;
    private WebDriver driver;
    private Logger logger;
    private Actions actions;

    protected BasePage() {
        this.driver = DriverManager.getDriver();
        actions = new Actions(((WrapsDriver) getDriver()).getWrappedDriver());
        PageFactory.initElements(new VisibleAjaxElementFactory(driver, TIMEOUT), this);
        logger = LogManager.getRootLogger();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Logger getLogger() {
        return logger;
    }

    public Actions getActions() {
        return actions;
    }

    protected abstract void openPage();

    public void scrollDownToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void pageScrollDown(final int pixel) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, " + pixel + ");");
    }
}
