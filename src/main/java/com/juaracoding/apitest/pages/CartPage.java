package com.juaracoding.apitest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    public final WebDriver driver;

    @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button")
    WebElement buttonAddToCart;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCartIcon() {
        buttonAddToCart.click();
    }
}
