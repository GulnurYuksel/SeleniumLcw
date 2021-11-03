package com.selenium.lcw.Pages;

import org.openqa.selenium.*;

import java.util.Random;

public class SearchPage extends BasePage{
    WebDriver driver;
    By searchBox = By.className("search-box__input");
    By clickSearch = By.className("search-box__button");
    By body = By.xpath("/html/body");
    By showMoreButton = By.cssSelector("#divModels > div:nth-child(10) > div > div.paging-process > a");
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void search(String searchText){
        driver.findElement(searchBox).sendKeys(searchText);
        driver.findElement(clickSearch).click();
    }
    public void scrollToPage(String pixel){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixel + ")");
    }
    public void scrollToPageEnd(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }

    public void choosePage() {
        driver.findElement(body).sendKeys(Keys.ARROW_UP);
        click(showMoreButton);


    }
    public By randomSelectProduct() {
        Random random = new Random();
        int rand = random.nextInt(30) + 1;
        return By.xpath("/html/body/div[5]/div[3]/div[2]/div[7]/div/div[1]/div[" + rand + "]/a");



    }
    public ProductPage productDetails() {

        click(randomSelectProduct());
        return new ProductPage(driver);
    }


}
