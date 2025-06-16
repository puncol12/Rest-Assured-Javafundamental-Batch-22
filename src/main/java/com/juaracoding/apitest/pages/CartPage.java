package com.juaracoding.apitest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    public final WebDriver driver;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    WebElement cartIcon;

    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[2]/a[2]")
    WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public static CartPage init(WebDriver driver) {
        CartPage cartPage = new CartPage(driver);
        PageFactory.initElements(driver, cartPage);
        return cartPage;
    }

    public void clickCartIcon() {
        cartIcon.click();
    }

    public void clickCheckout() {
        checkoutButton.click();
    }
}
