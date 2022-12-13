package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooks extends Utility {
    public LaptopsAndNotebooks() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptop;
    @FindBy(linkText = "Show All Laptops & Notebooks")
    WebElement showAllLaptopsAndNotebooks;
    /*@FindBy(xpath = "//p[@class ='price']")
    WebElement productsPrice;*/
    By productsPrice = By.xpath("//p[@class ='price']");
    @FindBy(id = "input-sort")
    WebElement sortBy;
    @FindBy(linkText = "MacBook")
    WebElement MacBook;
    @FindBy(xpath = "//h1[contains(text(),'MacBook')]")
    WebElement MacBookText;
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement cartTab;
    @FindBy(css = "body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible")  //cssSelector
    WebElement shoppingCartMsg;
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCartLink;
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement getShoppingCartMsg;
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement macBookVerification;
    @FindBy(xpath = "//input[contains(@name, 'quantity')]")
    WebElement quantity;
    @FindBy(xpath = "//button[contains(@data-original-title, 'Update')]")
    WebElement updateTab;
    @FindBy(xpath = "//div[@id='checkout-cart']/div[1]")
    WebElement modifiedShoppingCartMessage;
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement checkoutButton;
    @FindBy(xpath = "//div[@class='table-responsive']/table/tbody/tr/td[6]")
    WebElement total;
    @FindBy(xpath = "//h1[normalize-space()='Checkout']")
    WebElement checkoutText;
    @FindBy(xpath = "//div[@class='col-sm-6']/h2[normalize-space()='New Customer']")
    WebElement newCustomer;
    @FindBy(xpath = "//input[@value='guest']")
    WebElement guestCheckout;
    @FindBy(id = "button-account")
    WebElement continueTab;
    @FindBy(id = "button-guest")
    WebElement continueButton;
    @FindBy(xpath = "//input[@id='input-payment-firstname']")
    WebElement firstName;
    @FindBy(xpath = "//input[@id='input-payment-lastname']")
    WebElement lastName;
    @FindBy(xpath = "//input[@id='input-payment-email']")
    WebElement emailField;
    @FindBy(xpath = "//input[@id='input-payment-telephone']")
    WebElement telephone;
    @FindBy(xpath = "//input[@id='input-payment-address-1']")
    WebElement paymentAddress;
    @FindBy(xpath = "//input[@id='input-payment-city']")
    WebElement paymentCity;
    @FindBy(xpath = "//input[@id='input-payment-postcode']")
    WebElement paymentPostCode;
    @FindBy(xpath = "//select[@id='input-payment-country']")
    WebElement paymentCountry;
    @FindBy(xpath = "//select[@id='input-payment-zone']")
    WebElement paymentZone;
    @FindBy(xpath = "//textarea[@name='comment']")
    WebElement comments;
    @FindBy(name = "agree")
    WebElement termsAndConditions;
    @FindBy(id = "button-payment-method")
    WebElement continueTab1;
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement warningMessage;

    public void clickOnLaptop() {
        mouseHoverToElementAndClick(laptop);
    }

    public void clickOnShowAllLaptopsAndNoteBooks() {
        clickOnElement(showAllLaptopsAndNotebooks);
    }

    public void selectSortByPriceHighToLow() {
        //Get all the products price and stored into array list
        List<WebElement> products = driver.findElements(productsPrice);
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        // Select sort by Price (High > Low)
        selectByVisibleTextFromDropDown(sortBy, "Price (High > Low)");
        // After filter Price (High > Low) Get all the products name and stored into array list
        products = driver.findElements(productsPrice);
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        Assert.assertEquals(afterSortByPrice, originalProductsPrice);
    }

    public void selectProductMacBook() {
        clickOnElement(MacBook);
    }

    public String verifyTextMacBook() {
        return getTextFromElement(MacBookText);
    }

    public void clickOnAddToCart() {
        clickOnElement(cartTab);
    }

    public String shoppingCartMessage() {
        return getTextFromElement(shoppingCartMsg);
    }

    public void clickOnShoppingCart() {
        clickOnElement(shoppingCartLink);
    }

    public String verifyShoppingCartText() {
        return getTextFromElement(getShoppingCartMsg);
    }

    public String verifyProductNameMacBook() {
        return getTextFromElement(macBookVerification);
    }

    public void enterQuantity(String qty) {
        sendTextToElement(quantity, qty);
    }

    public void clickOnUpdateTab() {
        clickOnElement(updateTab);
    }

    public String modifyShoppingCartMessage() {
        return getTextFromElement(modifiedShoppingCartMessage);
    }

    public String verifyTotal() {
        return getTextFromElement(total);
    }

    public void clickOnCheckout() {
        clickOnElement(checkoutButton);
    }

    public String verifyCheckoutText() {
        return getTextFromElement(checkoutText);
    }

    public String verifyNewCustomer() {
        return getTextFromElement(newCustomer);
    }

    public void clickOnGuestCheckOut() {
        clickOnElement(guestCheckout);
    }

    public void clickOnContinueButton() {
        clickOnElement(continueTab);
    }

    public void clickOnContinue() {
        clickOnElement(continueButton);
    }

    public void addComments(String text) {
        sendTextToElement(comments, text);
    }

    public void clickOnTermsAndConditions() {
        clickOnElement(termsAndConditions);
    }

    public void clickOnContinueTab() {
        clickOnElement(continueTab1);
    }

    public String paymentWarningMessage() {
        return getTextFromElement(warningMessage);
    }

    public void enterFirstName(String firstname) {
        sendTextToElement(firstName, firstname);
    }

    public void enterLastName(String lastname) {
        sendTextToElement(lastName, lastname);
    }

    public void enterEmail(String email) {
        sendTextToElement(emailField, email);
    }

    public void enterAddress1(String address1) {
        sendTextToElement(paymentAddress, address1);
    }

    public void enterTelephone(String number) {
        sendTextToElement(telephone, number);
    }

    public void enterCity(String cityname) {
        sendTextToElement(paymentCity, cityname);
    }

    public void enterPostcode(String postcode) {
        sendTextToElement(paymentPostCode, postcode);
    }

    public void selectCountry(String country) {
        selectByVisibleTextFromDropDown(paymentCountry, country);
    }

    public void selectRegion(String region) {
        selectByVisibleTextFromDropDown(paymentZone, region);
    }
}
