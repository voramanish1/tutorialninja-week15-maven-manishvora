package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        homePage.mouseHoverOnDesktopsAndClickShowAllDesktops();
        Assert.assertEquals(homePage.getDesktopsTextMessage(), "Desktops", "Message not found");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        homePage.mouseHoverOnLaptopsAndNotebooksAndClickShowAllLaptopsAndNotebooks();
        Assert.assertEquals(homePage.getLaptopsAndNotebooksTextMessage(), "Laptops & Notebooks", "Message not found");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        homePage.mouseHoverOnComponentsAndClickShowAllComponents();
        Assert.assertEquals(homePage.getComponentsTextMessage(), "Components", "Message not found");
    }
}