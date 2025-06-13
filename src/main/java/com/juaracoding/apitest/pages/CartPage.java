package com.juaracoding.apitest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    public final WebDriver driver;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    WebElement cartIcon;

    @FindBy(xpath = "//a[@class='btn_action checkout_button']")
    WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCartIcon() {
        cartIcon.click();
    }

    public void clickCheckout() {
        checkoutButton.click();
    }
}
