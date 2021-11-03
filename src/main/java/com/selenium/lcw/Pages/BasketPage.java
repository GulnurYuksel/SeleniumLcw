package com.selenium.lcw.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends BasePage{
    WebDriver driver;
    private final By price = By.xpath("//*[@id=\"ShoppingCartContent\"]/div[1]/div[2]/div[1]/div[3]/div/span[2]");
    private By numberOfProducts = By.xpath("/html/body/div[3]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div/div[1]/div/a[2]");
    private By totalProduct = By.cssSelector("#ShoppingCartContent > div.row.mt-20.main-content-row > div.col-md-8 > div:nth-child(1) > div > span");
    private By deleteProduct = By.className("cart-square-link");
    private By emptyBasket = By.xpath("//*[@id=\"ShoppingCartContent\"]/div[1]/div/div/p[1]");

    public BasketPage(WebDriver driver){
        super(driver);

    }
    public String Price(){
        return driver.findElement(price).getText();
    }

    public void NumberOfProducts(){
        click(numberOfProducts);
    }

    public String TotalProduct(){
        return driver.findElement(totalProduct).getText();
    }

    public void deleteProduct(){

        click(deleteProduct);
    }

    public String isEmpty(){
        return driver.findElement(emptyBasket).getText();
    }

}
