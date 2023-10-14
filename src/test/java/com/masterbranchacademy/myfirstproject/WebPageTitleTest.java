package com.masterbranchacademy.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebPageTitleTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tarayiciyiKapat() {
        driver.close();

    }

    @Test
    public void webPageTitle() throws InterruptedException {
        WebElement element = driver.findElement(By.cssSelector("body"));
        System.out.println("element = " + element);
        String expectedTitle = "Your Store";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle, "Baslik dogru degil");
        Thread.sleep(3000);

        
        WebElement content = driver.findElement(By.id("content"));
        Assert.assertTrue(content.isDisplayed(),"Sayfa icerigi goruntulenmyor");
    }

}
