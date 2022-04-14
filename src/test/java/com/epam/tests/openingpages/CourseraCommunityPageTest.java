package com.epam.tests.openingpages;

import com.epam.service.PagesManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CourseraCommunityPageTest extends PagesManager {

    @Test(description = "Source and Topic type number the same as we selected in checkboxes on the 'Community' page",
            groups = "advanced")
    public void courseraCommunityPageTest() {
        getHomePage().openPage();
        getHomePage().clickLearnersButton();
        getCourseraCommunityPage().clickHowToUseCommunityButton();
        getCourseraCommunityPage()
                .closeTagsFilter()
                .selectCommunityCheckbox()
                .selectLearnerHelpCenterCheckbox()
                .selectQuestionCheckbox()
                .selectDiscussionCheckbox()
                .selectArticleCheckbox()
                .selectIdeaCheckbox()
                .selectEventCheckbox();
        Assert.assertEquals(getCourseraCommunityPage().getTotalTopicsNumberFromCheckboxes(),
                getCourseraCommunityPage().getTotalTopicsNumberFromFilterElement(),
                "Quantity of topics not equals!");
    }
}
