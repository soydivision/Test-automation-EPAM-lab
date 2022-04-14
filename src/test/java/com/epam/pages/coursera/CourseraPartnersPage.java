package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.TabsSwitcher;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CourseraPartnersPage extends BasePage {
    private Logger logger = getLogger();

    @FindBy(css = ".number span")
    private List<WebElement> partnersNumberText;

    @FindBy(css = ".partner-box-wrapper")
    private List<WebElement> partnersLogos;

    @FindBy(xpath = "//*[@class='rc-CountryTags horizontal-box wrap']//*[contains(@href,'ru')]")
    private WebElement russiaLink;

    @Override
    public void openPage() {
    }

    public int getNumberOfPartnersLogos() {
        int numberOfPartnersLogos = partnersLogos.size();
        logger.info("number of partners logos: {}", numberOfPartnersLogos);
        return numberOfPartnersLogos;
    }

    public int getPartnersNumber() {
        int partnersNumber = Integer.parseInt(partnersNumberText.get(0).getText());
        logger.info("partners number: {}", partnersNumber);
        return partnersNumber;
    }

    public void getRussianPartners() {
        logger.info("open page with Russian partners");
        russiaLink.click();
        TabsSwitcher.switchToNewTab(getDriver());
    }
}
