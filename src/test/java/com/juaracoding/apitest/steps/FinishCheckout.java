package com.juaracoding.apitest.steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.CheckoutPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FinishCheckout {

    WebDriver driver;
    CheckoutPage checkoutPage;

    @Given("Lanjut dari ringkasan pembelian")
    public void testStep01() {
        driver = DriverSingleton.createOrGetDriver();
        checkoutPage = new CheckoutPage(driver);
    }

    @When("Klik tombol Finish")
    public void testStep02() {
        checkoutPage.clickFinish();
    }

    @Then("Muncul pesan {string}")
    public void testStep03(String message) throws InterruptedException {
        String actualMessage = checkoutPage.getMessage();
        Assert.assertEquals(actualMessage, message);
        Thread.sleep(1000);
        driver.quit();
    }
}
