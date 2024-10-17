package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

    WebDriver driver = new ChromeDriver();

    WebElement input1 = driver.findElement(By.id("input-email"));
    WebElement input2 = driver.findElement(By.id("input-password"));
    WebElement submitButton = driver.findElement(By.xpath("//input[@class=\"btn btn-primary-login\"]"));

    public void login(String login, String pass) {

        input1.sendKeys(login);
        input2.sendKeys(pass);
        submitButton.click();
    }
}
