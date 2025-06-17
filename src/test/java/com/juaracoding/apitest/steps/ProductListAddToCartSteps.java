package com.juaracoding.apitest.steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

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

        signInPage = SignInPage.init(driver);
        productListPage = ProductListPage.init(driver);
        cartPage = CartPage.init(driver);

        signInPage.login("standard_user", "secret_sauce");
        Thread.sleep(3000);
    }

    @When("Klik tombol Add to Cart pada salah satu produk")
    public void testStep02() throws InterruptedException {
        productListPage.clickAddToCart(0);
        Thread.sleep(1000);
    }

    @Then("Klik ikon keranjang")
    public void testStep03() throws InterruptedException {
        cartPage.clickCartIcon();
        Thread.sleep(3000);
    }

    @Then("Produk muncul di halaman keranjang")
    public void testStep04() throws InterruptedException {
        String expected = "https://www.saucedemo.com/v1/cart.html";
        Thread.sleep(1000);
        String actual = driver.getCurrentUrl();
        Assert.assertEquals(actual, expected);
    }
}
