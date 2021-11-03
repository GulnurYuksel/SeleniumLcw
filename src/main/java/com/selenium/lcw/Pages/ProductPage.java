package com.selenium.lcw.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{

    WebDriver driver;

    private By productPrice  = By.className("price single-price");
    private By addBasketButton = By.id("pd_add_to_cart");
    private By clickBasketButton = By.className("button-link");
    private By sizes = By.xpath("//*[@id=\"option-size\"]/a[1]");
    public ProductPage(WebDriver driver){
        super(driver);
    }
    public String productPrice(){
        driver.findElement(productPrice).getText();

        return getText(productPrice);
    }
    public void addBasket(){
        click(addBasketButton);
    }
    public BasketPage goToBasket(){
        click(clickBasketButton);
        return new BasketPage(driver);
    }
    public void ClickSize(){
        click(sizes);
    }
}
