package com.juaracoding.apitest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    public final WebDriver driver;

    @FindBy(id = "first-name")
    WebElement firstName;

    @FindBy(id = "last-name")
    WebElement lastName;

    @FindBy(id = "postal-code")
    WebElement postalCode;

    @FindBy(xpath = "//*[@id=\"checkout_info_container\"]/div/form/div[2]/input")
    WebElement continueButton;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void input(String fname, String lname, String pcode) {
        firstName.sendKeys(fname);
        lastName.sendKeys(lname);
        postalCode.sendKeys(pcode);
    }

    public void clickContinue() {
        continueButton.click();
    }
}
