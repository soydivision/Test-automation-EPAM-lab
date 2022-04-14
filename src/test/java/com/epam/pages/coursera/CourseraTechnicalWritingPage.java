package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseraTechnicalWritingPage extends BasePage {

    @FindBy(tagName = "h1")
    private WebElement header;

    public String getHeaderText() {
        return header.getText();
    }

    @Override
    public void openPage() {
    }
}
