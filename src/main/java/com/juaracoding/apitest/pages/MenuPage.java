package com.juaracoding.apitest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"menu_button_container\"]/div/div[3]/div")
    WebElement menuButton;

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    WebElement logoutButton;

    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public static MenuPage init(WebDriver driver) {
        MenuPage menuPage = new MenuPage(driver);
        PageFactory.initElements(driver, menuPage);
        return menuPage;
    }

    public void clickMenu() {
        menuButton.click();
    }

    public void clickLogout() {
        logoutButton.click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
