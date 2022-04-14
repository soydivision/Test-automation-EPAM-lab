package com.epam.tests.forms;

import com.epam.service.PagesManager;
import com.epam.service.UsersManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TryForFreeFormWorksCorrectlyTest extends PagesManager {
    @Test(description = "Check form not to send without checkbox accepted", groups = "critical path")
    public void doesntSendWithoutCheckbox() {
        getTryForFreeFormPage().openPage();
        getTryForFreeFormPage().enterFirstName(UsersManager.getUserEmailU().getFirstName());
        getTryForFreeFormPage().enterLastName(UsersManager.getUserEmailU().getLastName());
        getTryForFreeFormPage().selectJobFunction(getProperties().getProperty("form.jobfunction"));
        getTryForFreeFormPage().enterJobTitle(getProperties().getProperty("form.jobtitle"));
        getTryForFreeFormPage().enterJobEmail(UsersManager.getUserEmailU().getEmail());
        getTryForFreeFormPage().enterPhoneNumber(UsersManager.getUserEmailU().getPhoneNumber());
        getTryForFreeFormPage().enterInstitutionName(getProperties().getProperty("form.institutionname"));
        getTryForFreeFormPage().enterInstitutionURL(getProperties().getProperty("form.institutionURL"));
        getTryForFreeFormPage().selectInstitutionLevel(getProperties().getProperty("form.institutionlevel"));
        getTryForFreeFormPage().enterNumberOfLearners(getProperties().getProperty("form.numberoflearners"));
        getTryForFreeFormPage().selectPrimaryDiscipline(getProperties().getProperty("form.primarydiscipline"));
        getTryForFreeFormPage().selectCountry(UsersManager.getUserEmailU().getLocation());
        getTryForFreeFormPage().selectState(UsersManager.getUserEmailU().getState());
        getTryForFreeFormPage().clickSubmitButton();
        Assert.assertTrue(getTryForFreeFormPage().alertIsPresented(), "Alert is not displayed");
    }
}
