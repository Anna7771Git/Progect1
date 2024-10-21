import org.example.ResultPage;
import org.example.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAnnaDZ2 {

    WebDriver driver;
    SearchPage searchPage;
    ResultPage resultPage;


    @BeforeTest
    public void setupDriver() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://avtogrand.com.ua/ua/");
        searchPage = new SearchPage(driver);
        resultPage = new ResultPage(driver);

    }

    @Test
    public void myTest1()  {

     searchPage.enterWord();
     searchPage.submitSearch();
     resultPage.getText();



        Assert.assertEquals(resultPage.getText(),"ПЕРЕТВОРЮВАЧ ІРЖІ ТРИГЕР 500 МЛ ЦИНКАР SKADI");


    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}
