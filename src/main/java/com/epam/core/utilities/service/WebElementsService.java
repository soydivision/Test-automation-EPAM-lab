package com.epam.core.utilities.service;

import com.epam.core.webdriver.factory.DriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.ArrayList;
import java.util.List;

public final class WebElementsService {

    private WebElementsService() {
    }

    public static ArrayList<String> getListOfWebElementsText(final List<WebElement> elements) {
        ArrayList<String> elementsText = new ArrayList<>();
        elements.forEach(element -> elementsText.add(element.getText()));
        return elementsText;
    }

    public static ArrayList<Double> getListOfDoubleFromElementsText(final List<WebElement> elements) {
        ArrayList<Double> doubleList = new ArrayList<>();
        elements.forEach(element -> {
            double doubleValue = Double.parseDouble(element.getText());
            doubleList.add(doubleValue);
        });
        return doubleList;
    }

    public static void clearInputFieldAndSendNewValue(final WebElement input, final String newValue) {
        new Actions(((WrapsDriver) DriverManager.getDriver()).getWrappedDriver())
                .doubleClick(input).sendKeys(Keys.DELETE).build().perform();
        input.sendKeys(newValue);
    }
}
