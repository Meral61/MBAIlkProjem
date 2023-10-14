package com.masterbranchacademy.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ImageSliderTest {

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
    public void testImageSlider() throws InterruptedException {
        driver.get("https://tutorialsninja.com/demo/");
        List<WebElement> sliderImage = driver.findElements(By.cssSelector(".swiper-slide img"));
        Assert.assertTrue(sliderImage.size() > 0, "Görüntü kaydırıcısı bulunamadı");

        for (int i = 0; i < sliderImage.size(); i++) {
            WebElement currentImage = sliderImage.get(i);
            Thread.sleep(3000);


            boolean isDisplayed = (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", currentImage);

            Assert.assertTrue(isDisplayed, "Görüntü görüntülenemiyor");


            if (i < sliderImage.size() - 1) {
                WebElement nextButton = driver.findElement(By.cssSelector(".swiper-button-next"));
                nextButton.click();
                Thread.sleep(3000);
        }
    }

    }
}
