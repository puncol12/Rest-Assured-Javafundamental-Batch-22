package com.juaracoding.apitest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
  public final WebDriver driver;

  @FindBy(id = "user-name")
  WebElement usernameField;

  @FindBy(id = "password")
  WebElement passwordField;

  @FindBy(id = "login-button")
  WebElement loginButton;

  @FindBy(xpath = "//h3[@data-test='error']")
  WebElement errorMessage;

  public SignInPage(WebDriver driver) {
    this.driver = driver;
  }

  public static SignInPage init(WebDriver driver) {
    SignInPage signInPage = new SignInPage(driver);
    PageFactory.initElements(driver, signInPage);
    return signInPage;
  }

  public void setUsername(String value) {
    usernameField.sendKeys(value);
  }

  public void setPassword(String password) {
    passwordField.sendKeys(password);
  }

  public void onClick() {
    loginButton.click();
  }

  public void login(String username, String password) {
    setUsername(username);
    setPassword(password);
    onClick();
  }

  public String getErrorMessage() {
    return errorMessage.getText();
  }
}
