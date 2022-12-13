package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Utility {
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccount;
    @FindBy(id = "input-email")
    WebElement emailField;
    @FindBy(id = "input-password")
    WebElement passwordField;
    @FindBy(xpath = "//form[contains(@action,'login')]//input[@type='submit']")
    WebElement loginButton;
    @FindBy(xpath = "//div[@class='col-sm-9']/h2[contains(text(),'My Account')]")
    WebElement accountText;
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement myAccountText;
    @FindBy(xpath = "//div[@class='pull-right']//a")
    WebElement continueButton;


    public void clickOnMyAccount() {
        clickOnElement(myAccount);
    }

    public void enterEmail(String email) {
        sendTextToElement(emailField, email);
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }

    public String getMyAccountLogoutText() {
        return getTextFromElement(myAccountText);
    }

    public String getMyAccountText() {
        return getTextFromElement(accountText);
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }
}


