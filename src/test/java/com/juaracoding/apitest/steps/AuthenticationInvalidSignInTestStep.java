package com.juaracoding.apitest.steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.SignInPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AuthenticationInvalidSignInTestStep {
  WebDriver driver;
  SignInPage signInPage;
  
  @Given("buka halaman login untuk pengujian tidak valid")
    public void testStep01() {
      driver = DriverSingleton.createOrGetDriver();
      driver.get("https://www.saucedemo.com/v1/index.html");
      signInPage = new SignInPage(driver);
    }
  
    @When("Masukkan username {string} dan password {string} tidak valid")
    public void testStep02(String username, String password) throws InterruptedException {
      signInPage.setUsername(username);
      Thread.sleep(1000);
      signInPage.setPassword(password);
      Thread.sleep(1000);
    }
  
    @And("Klik tombol login tidak valid")
    public void testStep03() {
      signInPage.onClick();
    }
  
    @Then("muncul pesan error login gagal")
    public void testStep04() throws InterruptedException {
      String expected = "Epic sadface: Username and password do not match any user in this service";
      String actual = signInPage.getErrorMessage();
      Thread.sleep(1000);
      Assert.assertEquals(actual, expected);
  }
}
