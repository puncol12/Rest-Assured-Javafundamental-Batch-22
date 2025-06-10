package com.juaracoding.apitest.steps;

import org.openqa.selenium.WebDriver;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.SignInPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AuthenticationSignInTestStep {
  WebDriver driver;
  SignInPage signInPage;

  @Given("buka halaman login")
  public void testStep01() {
    driver = DriverSingleton.createOrGetDriver();
    driver.get("https://www.saucedemo.com/v1/index.html");
    signInPage = new SignInPage(driver);
  }

  @When("Masukkan username {string} dan password {string} valid")
  public void testStep02(String username, String password) {
    signInPage.setUsername(username);
    signInPage.setPassword(password);
  }

  @And("Klik tombol login")
  public void testStep03() {
    signInPage.onClick();
  }

  @Then("Pengguna berhasil masuk ke halaman produk")
  public void testStep04() {
    System.err.println("Pengguna berhasil masuk ke halaman produk");
  }
}
