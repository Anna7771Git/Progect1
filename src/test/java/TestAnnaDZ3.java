import org.example.ProductPage;
import org.example.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAnnaDZ3 {

    WebDriver driver;
    ProductPage productPage;
    CartPage cartPage;

    @BeforeTest
    public void setupDriver() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://avtogrand.com.ua/ua/avtohimiya/preobrazovately-rzhavchini-trigger-500-ml-tsinkary-skadi");
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);

    }

    @Test
    public void myTest2() {

        productPage.addToCard();
        cartPage.getText();



        Assert.assertEquals(cartPage.getText(), "Товар Перетворювач іржі тригер 500 мл ЦИНКАР SKADI доданий до кошика!\n" +
                "×");
    }
        @AfterTest
        public void closeDriver(){
            driver.quit();
        }


}
