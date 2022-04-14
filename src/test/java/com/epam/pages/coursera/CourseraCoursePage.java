package com.epam.pages.coursera;

import com.epam.core.page.BasePage;
import com.epam.core.utilities.service.TabsSwitcher;
import com.epam.core.utilities.service.WaitersService;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseraCoursePage extends BasePage {
    private Logger logger = getLogger();

    @FindBy(xpath = "//span[contains(text(),'Save Note')]")
    private WebElement saveNoteButton;

    @FindBy(xpath = "//*[contains(text(),'Go To Course')]")
    private WebElement goToCourseButton;

    @FindBy(xpath = "//*[contains(text(),'Okay, got it!')]")
    private WebElement okGotItButton;

    @FindBy(className = "review-link-text")
    private WebElement allNotesButton;

    @FindBy(xpath = "//span[text()='Add your thoughts']")
    private WebElement addYourThoughtsButton;

    @FindBy(xpath = "//*[contains(@data-track-component,'note_delete_button')]")
    private WebElement deleteNote;

    @FindBy(xpath = "//*[contains(@data-track-component,'note_delete_confirm_button')]")
    private WebElement deleteNoteConfirm;

    @FindBy(xpath = "//span[text()='Videos']")
    private WebElement videosButton;

    @FindBy(className = "data-state-message headline-5-text")
    private WebElement noteStateMessage;

    @FindBy(xpath = "//a[text()='✕']")
    private WebElement closeTimeZoneWindow;

    @Override
    protected void openPage() {
    }

    public void saveNote() {
        WaitersService.waitForElementToBeClickable(getDriver(), saveNoteButton);
        logger.info("saveNoteButton clicked");
        saveNoteButton.click();
        WaitersService.waitForVisibilityOfElement(getDriver(), addYourThoughtsButton);
    }

    public void clickOnVideo() {
        logger.info("videosButton clicked");
        videosButton.click();
        WaitersService.waitUntilPageIsCompletelyLoaded(getDriver());
    }

    public void goToCourseButton() {
        logger.info("click on help center link");
        goToCourseButton.click();
        TabsSwitcher.switchToNewTab(getDriver());
    }

    public void okGotItPressed() {
        try {
            logger.info("click got it button");
            okGotItButton.click();
            WaitersService.waitUntilPageIsCompletelyLoaded(getDriver());
        } catch (
                  NoSuchElementException e) {
            logger.info(e);
            logger.info("okGotItButton was not found");
        }
    }

    public void goToAllNotes() {
        logger.info("All notes page was opened , allNotesButton clicked");
        getActions().moveToElement(allNotesButton).click().build().perform();
        TabsSwitcher.switchToNewTab(getDriver());
        WaitersService.waitUntilPageIsCompletelyLoaded(getDriver());
    }

    public void deleteNote() {
        logger.info("delete note");
        deleteNote.click();
        deleteNoteConfirm.click();
        WaitersService.waitUntilPageIsCompletelyLoaded(getDriver());
        getDriver().navigate().refresh();
        WaitersService.waitUntilPageIsCompletelyLoaded(getDriver());
    }

    public void turnOffTimeZoneWindow() {
        logger.info("closeTimeZoneWindow clicked");
        closeTimeZoneWindow.click();
    }

    public boolean notesAreEmpty() {
        return getDriver().getPageSource().contains("You have not added any notes yet");
    }
}
