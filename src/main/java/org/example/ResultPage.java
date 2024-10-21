package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage {

    WebDriver driver;

    public ResultPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

     }
@FindBy(xpath = "//h4")
    WebElement text;

    public String getText(){
        return text.getText();
    }
}
