package com.masterbranchacademy.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class MenuControlTest {

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
        driver.quit();

    }

    @Test
    public void testNavigationMenu() throws InterruptedException {

        WebElement navigationMenu = driver.findElement(By.id("menu"));
        Assert.assertTrue(navigationMenu.isDisplayed(), "Gezinme menüsü bulunamadı.");

        WebElement laptopsMenuLink = driver.findElement(By.xpath("//a[contains(text(), 'Laptops & Notebooks')]"));
        laptopsMenuLink.click();
        Thread.sleep(3000);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Laptops & Notebooks";
        Assert.assertEquals(actualTitle, expectedTitle, "Beklenen sayfa başlığı bulunamadı.");

        driver.navigate().back();

        WebElement tabletsMenuLink = driver.findElement(By.id("menu-option-8"));
        tabletsMenuLink.click();
        Thread.sleep(3000);
        expectedTitle = "Tablets";
        actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Beklenen sayfa başlığı bulunamadı.");

        driver.navigate().back();

        WebElement componentsMenuLink = driver.findElement(By.xpath("//a[contains(text(), 'Components')]"));
        componentsMenuLink.click();
        Thread.sleep(3000);
        expectedTitle = "Components";
        actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Beklenen sayfa başlığı bulunamadı.");


        driver.navigate().back();
        Thread.sleep(3000);
        WebElement desktopsMenuLink = driver.findElement(By.id("menu-option-3"));
        desktopsMenuLink.click();

        expectedTitle = "Desktops";
        actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Beklenen sayfa başlığı bulunamadı.");
        Thread.sleep(3000);

    }


}



//Hata Tanımı: "testNavigationMenu" senaryosu başarısız oldu; sayfa başlığı beklenen değeri "Laptops & Notebooks" yerine
// "Your Store" olarak döndürdü.
































