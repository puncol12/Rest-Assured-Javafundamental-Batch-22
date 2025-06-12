package com.juaracoding.apitest.steps;

import org.openqa.selenium.WebDriver;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.CartPage;
import com.juaracoding.apitest.pages.ProductListPage;
import com.juaracoding.apitest.pages.SignInPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductListAddToCartSteps {

    WebDriver driver;
    SignInPage signInPage;
    ProductListPage productListPage;
    CartPage cartPage;

    @Given("Login dengan user valid")
    public void testStep01() throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.get("https://www.saucedemo.com/v1/index.html");

        signInPage = new SignInPage(driver);
        productListPage = new ProductListPage(driver);
        cartPage = new CartPage(driver);

        signInPage.login("standard_user", "secret_sauce");
        Thread.sleep(2000);
    }

    @When("Klik tombol Add to Cart pada salah satu produk")
    public void testStep02() throws InterruptedException {
        productListPage.getTotalButtons();
        Thread.sleep(2000);
    }

    @Then("Klik ikon keranjang")
    public void testStep03() throws InterruptedException {
        cartPage.clickCartIcon();
        Thread.sleep(2000);
    }

}