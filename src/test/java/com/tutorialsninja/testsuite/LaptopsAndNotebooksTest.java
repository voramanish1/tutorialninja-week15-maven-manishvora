package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LaptopsAndNotebooks;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LaptopsAndNotebooksTest extends BaseTest {
    HomePage homePage;
    LaptopsAndNotebooks laptopAndNotebooks;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        laptopAndNotebooks = new LaptopsAndNotebooks();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        //1.2 Click on “Show All Laptops & Notebooks”
        laptopAndNotebooks.clickOnLaptop();
        laptopAndNotebooks.clickOnShowAllLaptopsAndNoteBooks();
        //1.3 Select Sort By "Price (High > Low)"
        //1.4 Verify the Product price will arrange in High to Low order.
        laptopAndNotebooks.selectSortByPriceHighToLow();
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        //2.2 Click on “Show All Laptops & Notebooks”
        laptopAndNotebooks.clickOnLaptop();
        laptopAndNotebooks.clickOnShowAllLaptopsAndNoteBooks();
        homePage.changeCurrencyto£();
        //2.3 Select Sort By "Price (High > Low)"
        laptopAndNotebooks.selectSortByPriceHighToLow();
        //2.4 Select Product “MacBook”
        laptopAndNotebooks.selectProductMacBook();
        //2.5 Verify the text “MacBook”
        Assert.assertEquals(laptopAndNotebooks.verifyTextMacBook(), "MacBook", "MacBook Product not display");
        //2.6 Click on ‘Add To Cart’ button
        laptopAndNotebooks.clickOnAddToCart();
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        Assert.assertTrue(laptopAndNotebooks.shoppingCartMessage().contains("Success: You have added MacBook to your shopping cart!"), "Product not added to cart");
        //2.8 Click on link “shopping cart” display into success message
        laptopAndNotebooks.clickOnShoppingCart();
        //2.9 Verify the text "Shopping Cart"
        Assert.assertTrue(laptopAndNotebooks.verifyShoppingCartText().contains("Shopping Cart"), "Text not found");
        //2.10 Verify the Product name "MacBook"
        Assert.assertEquals(laptopAndNotebooks.verifyProductNameMacBook(), "MacBook", "Product name not matched");
        //2.11 Change Quantity "2"
        WebElement qty = driver.findElement(By.cssSelector("input[value='1']"));
        qty.clear();
        laptopAndNotebooks.enterQuantity("2");
        //2.12 Click on “Update” Tab
        laptopAndNotebooks.clickOnUpdateTab();
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        Assert.assertTrue(laptopAndNotebooks.modifyShoppingCartMessage().contains("Success: You have modified your shopping cart!"), "Cart not modified");
        //2.14 Verify the Total £737.45
        Assert.assertEquals(laptopAndNotebooks.verifyTotal(), "£737.45", "Total not matched");
        //2.15 Click on “Checkout” button
        laptopAndNotebooks.clickOnCheckout();
        //2.16 Verify the text “Checkout”
        Assert.assertEquals(laptopAndNotebooks.verifyCheckoutText(), "Checkout", "not check out");
        //2.17 Verify the Text “New Customer”
        Thread.sleep(1000);
        Assert.assertEquals(laptopAndNotebooks.verifyNewCustomer(), "New Customer", "correct customer");
        //2.18 Click on “Guest Checkout” radio button
        laptopAndNotebooks.clickOnGuestCheckOut();
        //2.19 Click on “Continue” tab
        laptopAndNotebooks.clickOnContinueButton();
        //2.20 Fill the mandatory fields
        Thread.sleep(1000);
        laptopAndNotebooks.enterFirstName("Abc");
        laptopAndNotebooks.enterLastName("Xyz");
        laptopAndNotebooks.enterEmail("test123@gmail.com");
        laptopAndNotebooks.enterTelephone("0987654321");
        laptopAndNotebooks.enterAddress1("10 Downing Street");
        laptopAndNotebooks.enterCity("London");
        laptopAndNotebooks.enterPostcode("EC1B 2JL");
        laptopAndNotebooks.selectCountry("United Kingdom");
        laptopAndNotebooks.selectRegion("Greater London");
        //2.21 Click on “Continue” Button
        laptopAndNotebooks.clickOnContinue();
        //2.22 Add Comments About your order into text area
        laptopAndNotebooks.addComments("Thank You");
        //2.23 Check the Terms & Conditions check box
        laptopAndNotebooks.clickOnTermsAndConditions();
        //2.24 Click on “Continue” button
        laptopAndNotebooks.clickOnContinueTab();
        //2.25 Verify the message “Warning: Payment method required!”
        Assert.assertEquals(laptopAndNotebooks.paymentWarningMessage(), "Warning: Payment method required!\n×");
    }
}
