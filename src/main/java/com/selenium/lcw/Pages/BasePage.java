package com.selenium.lcw.Pages;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver ;

    public BasePage(WebDriver driver) {
        this.driver = driver;

    }
    public WebElement find(By locator){
        return driver.findElement(locator);
    }

    public void click(By by)
    {

        find(by).click();
    }
    public String getText(By byElement) {
        return getText(byElement);
    }
}
