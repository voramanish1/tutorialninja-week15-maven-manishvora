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

public class Desktops extends Utility {
    public Desktops() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "input-sort")
    WebElement sortBy;
    @FindBy(xpath = "//a[contains(text(),'HP LP3065')]")
    WebElement product;
    @FindBy(xpath = "//h1[contains(text(),'HP LP3065')]")
    WebElement productTitle;

    public void selectSortBy(String text) {
        selectByVisibleTextFromDropDown(sortBy, text);
    }

    public void selectProduct() {
        clickOnElement(product);
    }

    public String getProductTitle() {
        return getTextFromElement(productTitle);
    }

    public void selectFilterAndVerifyRequirement() {
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='product-thumb']/ancestor::div/preceding::h4"));
        ArrayList<String> beforeSortList = new ArrayList<>();
        for (WebElement e : products) {
            beforeSortList.add(e.getText());
        }
        Collections.sort(beforeSortList);
        selectByVisibleTextFromDropDown(sortBy, "Name (Z - A)");
        // After filter Z -A Get all the products name and stored into array list
        products = driver.findElements(By.xpath("//div[@class='product-thumb']/ancestor::div/preceding::h4"));
        ArrayList<String> afterSortList = new ArrayList<>();
        for (WebElement e : products) {
            afterSortList.add(e.getText());
        }
        Collections.reverse(beforeSortList);
        System.out.println(afterSortList);
        Assert.assertEquals(beforeSortList, beforeSortList);
    }

    public void selectRequiredDateFormCalendar(String year, String month, String date) {
        clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));
        while (true) {
            String monthAndYear = driver.findElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']"));
            }
        }
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
    }
}