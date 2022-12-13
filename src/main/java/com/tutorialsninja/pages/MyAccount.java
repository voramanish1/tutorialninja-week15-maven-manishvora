package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyAccount extends Utility {
    public MyAccount() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccount;
    @FindBy(id = "input-firstname")
    WebElement firstName;
    @FindBy(id = "input-lastname")
    WebElement lastName;
    @FindBy(id = "input-email")
    WebElement emailField;
    @FindBy(id = "input-telephone")
    WebElement telephoneField;
    @FindBy(id = "input-password")
    WebElement passwordField;
    @FindBy(id = "input-confirm")
    WebElement confirmPasswordField;
    @FindBy(xpath = "//div[@class = 'buttons']//input[@name='agree']")
    WebElement privacyCheck;
    @FindBy(xpath = "//div[@class = 'buttons']//input[@value='Continue']")
    WebElement continueButton;
    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement confirmMessage;
    @FindBy(xpath = "//div[@class='col-sm-9']/h1")
    WebElement logoutMessage;
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement registerText;
    @FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
    WebElement returningCustomerText;

    public void clickOnMyAccount() {
        clickOnElement(myAccount);
    }

    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        }
    }

    public void enterFirstname(String firstname) {
        sendTextToElement(firstName, firstname);
    }

    public void enterLastname(String lastname) {
        sendTextToElement(lastName, lastname);
    }

    public void enterEmail(String email) {
        sendTextToElement(emailField, email);
    }

    public void enterTelephone(String phone) {
        sendTextToElement(telephoneField, phone);
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
    }

    public void enterConfirmPassword(String confirmPass) {
        sendTextToElement(confirmPasswordField, confirmPass);
    }

    public void selectRadioButton() {
        List<WebElement> radioButtons = driver.findElements(By.xpath("//fieldset[3]//input"));
        for (WebElement e : radioButtons) {
            if (e.getText().equals("Yes")) {
                e.click();
                break;
            }
        }
    }

    public void clickOnPrivacyCheck() {
        clickOnElement(privacyCheck);
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }

    public String getRegistrationConfirmMessage() {
        return getTextFromElement(confirmMessage);
    }

    public String getLogoutMessage() {
        return getTextFromElement(logoutMessage);
    }

    public String getRegisterText() {
        return getTextFromElement(registerText);
    }

    public String getReturningCustomerText(){
        return getTextFromElement(returningCustomerText);
    }
}
