package com.juaracoding.apitest.steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.CartPage;
import com.juaracoding.apitest.pages.CheckoutPage;
import com.juaracoding.apitest.pages.ProductListPage;
import com.juaracoding.apitest.pages.SignInPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps {

    WebDriver driver;
    SignInPage signInPage;
    ProductListPage productListPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @Given("Login user valid")
    public void testStep01() throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.get("https://www.saucedemo.com/v1/index.html");

        signInPage = new SignInPage(driver);
        productListPage = new ProductListPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);

        signInPage.login("standard_user", "secret_sauce");
        Thread.sleep(3000);
    }

    @When("Tambah produk ke keranjang")
    public void testStep02() throws InterruptedException {
        productListPage.clickAddToCart();
        Thread.sleep(1000);
    } 

    @Then("Klik keranjang")
    public void testStep03() throws InterruptedException {
        cartPage.clickCartIcon();
        Thread.sleep(3000);
        String expected = "https://www.saucedemo.com/v1/cart.html";
        String actual = driver.getCurrentUrl();
        Assert.assertEquals(actual, expected);
    }

    @Then("Klik Checkout")
    public void testStep04() throws InterruptedException {
        cartPage.clickCheckout();
        Thread.sleep(3000);
        String expected = "https://www.saucedemo.com/v1/checkout-step-one.html";
        String actual = driver.getCurrentUrl();
        Assert.assertEquals(actual, expected);
    }

    @And("Masukkan informasi pelanggan firt name {string} dan last name {string} dan postal code {string}")
    public void testStep05(String fname, String lname, String pcode) throws InterruptedException {
        checkoutPage.input(fname, lname, pcode);
        Thread.sleep(1000);
    }

    @Then("Klik Continue")
    public void testStep06() throws InterruptedException {
        checkoutPage.clickContinue();
        Thread.sleep(1000);
        String expected = "https://www.saucedemo.com/v1/checkout-step-two.html";
        String actual = driver.getCurrentUrl();
        Assert.assertEquals(actual, expected);
    }
}
