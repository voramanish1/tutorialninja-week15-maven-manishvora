package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.LoginPage;
import com.tutorialsninja.pages.MyAccount;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAccountTest extends BaseTest {
    MyAccount myAccount;
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        myAccount = new MyAccount();
        loginPage = new LoginPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //1.1 Click on My Account Link
        myAccount.clickOnMyAccount();
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        myAccount.selectMyAccountOptions("Register");
        //1.3 Verify the text “Register Account”
        Assert.assertTrue(myAccount.getRegisterText().contains("Register Account"), "Text not found");
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //2.1 Click on My Account Link
        loginPage.clickOnMyAccount();
        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        myAccount.selectMyAccountOptions("Login");
        //2.3 Verify the text “Returning Customer”
        Assert.assertEquals(myAccount.getReturningCustomerText(), "Returning Customer", "Text not fount");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserRegisterAccountSuccessfully() throws InterruptedException {
        //3.1 Click on My Account Link
        Thread.sleep(1000);
        myAccount.clickOnMyAccount();
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        myAccount.selectMyAccountOptions("Register");
        //3.3 Enter First Name
        Thread.sleep(1000);
        myAccount.enterFirstname("Abc" + getAlphaNumericString(7));
        //3.4 Enter Last Name
        myAccount.enterLastname("Xyz" + getAlphaNumericString(5));
        //3.5 Enter Email
        myAccount.enterEmail("test123" + getAlphaNumericString(7) + "@gmail.com");
        //3.6 Enter Telephone
        myAccount.enterTelephone("0987654321");
        //3.7 Enter Password
        myAccount.enterPassword("test123");
        //3.8 Enter Password Confirm
        myAccount.enterConfirmPassword("test123");
        //3.9 Select Subscribe Yes radio button
        myAccount.selectRadioButton();
        //3.10 Click on Privacy Policy check box
        myAccount.clickOnPrivacyCheck();
        //3.11 Click on Continue button
        myAccount.clickOnContinueButton();
        //3.12 Verify the message “Your Account Has Been Created!”
        Assert.assertEquals(myAccount.getRegistrationConfirmMessage(), "Your Account Has Been Created!", "Message not found");
        //3.13 Click on Continue button
        loginPage.clickOnContinueButton();
        //3.14 Click on My Account Link
        myAccount.clickOnMyAccount();
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        myAccount.selectMyAccountOptions("Logout");
        //3.16 Verify the text “Account Logout”
        Assert.assertEquals(myAccount.getLogoutMessage(), "Account Logout", "Message not found");
        //3.17 Click on Continue button
        loginPage.clickOnContinueButton();
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        //4.1 Click on My Account Link
        loginPage.clickOnMyAccount();
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        myAccount.selectMyAccountOptions("Login");
        //4.3 Enter Email address
        loginPage.enterEmail("test123@gmail.com");
        //4.5 Enter Password
        loginPage.enterPassword("test123");
        //4.6 Click on Login button
        loginPage.clickOnLoginButton();
        //4.7 Verify text “My Account”
        Assert.assertEquals(loginPage.getMyAccountText(), "My Account", "Login Not Successfull");
        //4.8 Click on My Account Link.
        loginPage.clickOnMyAccount();
        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        myAccount.selectMyAccountOptions("Logout");
        //4.10 Verify the text “Account Logout”
        Assert.assertEquals(myAccount.getLogoutMessage(), "Account Logout", "Message not found");
        //4.11 Click on Continue button
        loginPage.clickOnContinueButton();
    }
}
