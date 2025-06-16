package com.juaracoding.apitest.steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.MenuPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutSteps {

    WebDriver driver;
    MenuPage menuPage;

    @Given("Klik ikon menu")
    public void testStep01() throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        menuPage = new MenuPage(driver);
        menuPage.clickMenu();
        Thread.sleep(1000);
    }

    @When("Klik Logout")
    public void testStep02() throws InterruptedException {
        menuPage.clickLogout();
        Thread.sleep(1000);
    }

    @Then("Pengguna diarahkan kembali ke halaman login")
    public void testStep03() throws InterruptedException {
        String expected = "https://www.saucedemo.com/v1/index.html";
        Thread.sleep(1000);
        String actual = driver.getCurrentUrl();
        Assert.assertEquals(actual, expected);
    }
}
