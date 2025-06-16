package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.CartPage;
import com.juaracoding.apitest.pages.CheckoutPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps {

    WebDriver driver;
    CartPage cartPage;
    CheckoutPage checkoutPage;


    @Given("Klik Checkout")
    public void testStep01() throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        Thread.sleep(1000);
        cartPage.clickCheckout();
    }

    @When("Masukkan informasi pelanggan firt name {string} dan last name {string} dan postal code {string}")
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
