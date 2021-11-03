import com.selenium.lcw.Log4j;
import org.junit.After;
import org.junit.Assert;
import com.selenium.lcw.Pages.BasketPage;
import com.selenium.lcw.Pages.LoginPage;
import com.selenium.lcw.Pages.ProductPage;
import com.selenium.lcw.Pages.SearchPage;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.AssertJUnit.*;

import java.util.concurrent.TimeUnit;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    public WebDriver driver;
    LoginPage loginPage;
    SearchPage searchPage;
    ProductPage productPage;
    @BeforeAll
    public void setUp() {
        try {

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\gulnu\\IdeaProjects\\SeleniumLcw\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            String baseUrl ="https://www.lcwaikiki.com/tr-TR/TR";
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //Log4j.info("Test is starting...");
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.get(baseUrl);
            driver.manage().deleteAllCookies();

            //dynamic wait
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    public void Login() {
        loginPage = new LoginPage(driver);
        driver.findElement(By.className("dropdown-toggle")).click();
        loginPage.setUserEmail("gulnuryuksel96@gmail.com");
        loginPage.setUserPassword("G12345");
        loginPage.clickLoginButton();
    }
    @Test
    public void Search() {
    WebElement searchBox = driver.findElement(By.className("search-box__input"));
    searchBox.click();
    searchBox.sendKeys("Pantalon");
    driver.findElement(By.className("search-box__button")).click();
    searchPage.scrollToPageEnd();
    searchPage.choosePage();
    searchPage.scrollToPageEnd();
    }
    @Test
    public void ProductPage(){
        Log4j.info("Product details page");
        ProductPage productPage = searchPage.productDetails();
        Log4j.info("Product price information ");
        String productPrice = productPage.productPrice();
        searchPage.scrollToPage("300");
        Log4j.info("The selected product is added to the basket");
        productPage.addBasket();
    }
    @Test
    public void BasketPage(){
        Log4j.info("Go to my basket page.");
        BasketPage basketPage = productPage.goToBasket();
        String productPrice = productPage.productPrice();
        productPage.ClickSize();
        Log4j.info("The compared is between The price on the product page and the price of the product in the basket");
        Assert.assertEquals(productPrice,basketPage.Price());

        Log4j.info("The number of products is increased ");
        basketPage.NumberOfProducts();
        Assert.assertTrue(basketPage.TotalProduct().contains("Sepetim (2 Ürün)"));
        Log4j.info("The product is deleted from the basket.");
        basketPage.deleteProduct();
        String basketMessage = "Sepetinizde ürün bulunmamaktadır.";
        Log4j.info("Check if the basket is empty");
        Assert.assertEquals(basketMessage, basketPage.isEmpty());
    }


    @After
    public void tearDown(){
        driver.quit();
    }
}
