package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.Desktops;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DesktopsTest extends BaseTest {
    Desktops desktops;
    HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        desktops = new Desktops();
        homePage = new HomePage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyProductArrangeInAlphaBaticalOrder() {
        //1.1 Mouse hover on Desktops Tab.and click
        //1.2 Click on “Show All Desktops”
        homePage.mouseHoverOnDesktopsAndClickShowAllDesktops();
        //1.3 Select Sort By position "Name: Z to A"
        //1.4 Verify the Product will arrange in Descending order.
        desktops.selectFilterAndVerifyRequirement();
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyProductAddedToShoppingCartSuccessFully() {
        //2.1 Mouse hover on Desktops Tab. and click
        //2.2 Click on “Show All Desktops”
        homePage.mouseHoverOnDesktopsAndClickShowAllDesktops();
        homePage.changeCurrencyto£();
        //2.3 Select Sort By position "Name: A to Z"
        desktops.selectSortBy("Name (A - Z)");
        //2.4 Select product “HP LP3065”
        desktops.selectProduct();
        //2.5 Verify the Text "HP LP3065"
        Assert.assertEquals(desktops.getProductTitle(), "HP LP3065", "Title not found");
        //2.6 Select Delivery Date "2022-11-30"
        desktops.selectRequiredDateFormCalendar("2023", "November", "30");
        //2.7.Enter Qty "1” using Select class.
        //2.8 Click on “Add to Cart” button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        Assert.assertTrue(getTextFromElement(By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible"))
                .contains("Success: You have added HP LP3065 to your shopping cart!"), "Product not added to cart");
        //2.10 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        //2.11 Verify the text "Shopping Cart"
        Assert.assertTrue(getTextFromElement(By.xpath("//h1[contains(text(),'Shopping Cart')]")).contains("Shopping Cart"), "Shopping Cart text not found");
        //2.12 Verify the Product name "HP LP3065"
        Assert.assertEquals(getTextFromElement(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")), "HP LP3065", "Product name not matched");
        //2.13 Verify the Delivery Date "2022-11-30"
        Assert.assertEquals(getTextFromElement(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")), "Delivery Date: 2023-11-30", "Delivery date not matched");
        //2.14 Verify the Model "Product21"
        Assert.assertEquals(getTextFromElement(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[3]")), "Product 21", "Model not matched");
        //2.15 Verify the Total "£74.73"
        Assert.assertEquals(getTextFromElement(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]")), "£74.73", "Total not matched");
    }
}