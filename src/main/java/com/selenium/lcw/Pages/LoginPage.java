package com.selenium.lcw.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
    WebDriver driver;
    By userEmail = By.id("LoginEmail");
    By userPassword = By.id("Password");
    By loginButton = By.id("loginLink");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setUserEmail(String userEmailSet) {
        WebElement userEmailElement = driver.findElement(userEmail);
        userEmailElement.click();
        userEmailElement.sendKeys(userEmailSet);
    }

    public void setUserPassword(String passwordSet) {
        WebElement userPasswordElement = driver.findElement(userPassword);
        userPasswordElement.click();
        userPasswordElement.sendKeys(passwordSet);
    }
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

}
