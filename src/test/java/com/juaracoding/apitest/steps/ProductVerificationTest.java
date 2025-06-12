package com.juaracoding.apitest.steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.ProductListPage;
import com.juaracoding.apitest.pages.SignInPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductVerificationTest {
  WebDriver driver;
  SignInPage signInPage;
  ProductListPage productListPage;

  @Given("Pretest verifikasi, login dengan user valid")
  public void testStep01() throws InterruptedException {
    driver = DriverSingleton.createOrGetDriver();
    driver.get("https://www.saucedemo.com/v1/index.html");
    signInPage = new SignInPage(driver);
    productListPage = new ProductListPage(driver);

    signInPage.login("standard_user", "secret_sauce");
    Thread.sleep(2000);
  }

  @When("Verifikasi semua produk ditampilkan")
  public void testStep02() throws InterruptedException {
    Assert.assertTrue(productListPage.hasAProducts());
    Thread.sleep(2000);
  }

  @Then("Daftar produk muncul lengkap dengan nama, harga, dan tombol Add to Cart")
  public void testStep03() {
    Assert.assertTrue(productListPage.checkProperty());
  }
}
