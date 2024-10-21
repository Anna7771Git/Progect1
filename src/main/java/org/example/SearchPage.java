package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    WebDriver driver;

    public SearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
@FindBy(id = "searchinput")
        WebElement search;


@FindBy(xpath = "//button[@class=\"btn btn-default btn-lg button-search\"]")
    WebElement submitButton;


    public void enterWord(){
        search.sendKeys("перетворювач іржі тригер skadi");
    }

    public void submitSearch(){
        submitButton.click();
    }
}
