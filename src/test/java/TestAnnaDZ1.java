import io.qameta.allure.testng.AllureTestNg;
import org.example.EnterPage;
import org.example.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners({AllureTestNg.class})
public class TestAnnaDZ1 {

    WebDriver driver;
    LoginPage loginPage;
    EnterPage enterPage;

    @BeforeTest
    public void setupDriver() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://avtogrand.com.ua/ua/login/");
        loginPage = new LoginPage(driver);
        enterPage = new EnterPage(driver);


    }

    @Test
    public void myTest()  {

        loginPage.enterEmail();
        loginPage.enterPass();
        loginPage.submitLogin();
        enterPage.getText();



        Assert.assertEquals(enterPage.getText(),"Особистий кабінет");



    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}
