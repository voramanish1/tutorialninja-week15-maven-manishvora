package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends Utility {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[text()='Desktops']")
    WebElement desktops;
    @FindBy(xpath = "//a[text()='Show All Desktops']")
    WebElement showAllDesktops;
    @FindBy(xpath = "//h2[contains(text(),'Desktops')]")
    WebElement desktopsTextMessage;
    @FindBy(xpath = "//a[text()='Laptops & Notebooks']")
    WebElement laptopsAndNotebooks;
    @FindBy(xpath = "//a[text()='Show All Laptops & Notebooks']")
    WebElement showAllLaptopsAndNotebooks;
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement laptopsAndNotebooksTextMessage;
    @FindBy(xpath = "//a[text()='Components']")
    WebElement components;
    @FindBy(xpath = "//a[text()='Show All Components']")
    WebElement showAllComponents;
    @FindBy(xpath = "//h2[contains(text(),'Components')]")
    WebElement componentsTextMessage;
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement currencyDropdown;

    public void mouseHoverOnDesktopsAndClickShowAllDesktops() {
        mouseHoverToElement(desktops);
        mouseHoverToElementAndClick(showAllDesktops);
    }

    public String getDesktopsTextMessage() {
        return getTextFromElement(desktopsTextMessage);
    }

    public void mouseHoverOnLaptopsAndNotebooksAndClickShowAllLaptopsAndNotebooks() {
        mouseHoverToElement(laptopsAndNotebooks);
        mouseHoverToElementAndClick(showAllLaptopsAndNotebooks);
    }

    public String getLaptopsAndNotebooksTextMessage() {
        return getTextFromElement(laptopsAndNotebooksTextMessage);
    }

    public void mouseHoverOnComponentsAndClickShowAllComponents() {
        mouseHoverToElement(components);
        mouseHoverToElementAndClick(showAllComponents);
    }

    public String getComponentsTextMessage() {
        return getTextFromElement(componentsTextMessage);
    }

    public void changeCurrencyto£() {
        //selectByVisibleTextFromDropDown(currencyDropdown,"£ Pound Sterling");
        clickOnElement(currencyDropdown);
        List<WebElement> currencyList = driver.findElements(By.xpath("//ul[@class = 'dropdown-menu']/li"));
        for (WebElement e : currencyList) {
            if (e.getText().equalsIgnoreCase("£ Pound Sterling")) {
                e.click();
                break;
            }
        }
    }
}