package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;


    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);


    }
    @FindBy(id="input-email")
    WebElement input1;

    @FindBy(id = "input-password")
    WebElement input2;

    @FindBy(xpath = "//input[@class=\"btn btn-primary-login\"]")
    WebElement submitButton;


    public void enterEmail(){
        input1.sendKeys("anna.smirnova0502@gmail.com");
    }
    public void enterPass() {
        input2.sendKeys("test911");
    }
        public void submitLogin(){
            submitButton.click();
        }
    }

