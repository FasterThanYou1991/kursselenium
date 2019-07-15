package com.kurs.selenium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WikipediaTest {

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver",
                "src/test/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void WikipediaTest () {

        driver.get("https://pl.wikipedia.org/");
        WebElement element = driver.findElement(By.id("main-page-column1"));
        System.out.println(element.getText());

        driver.get("https://pl.wikipedia.org/");
        String atrybut = driver.findElement(By.id("main-page-content")).getAttribute("class");
        System.out.println(atrybut);

        driver.get("https://pl.wikipedia.org/");
        String tag = driver.findElement(By.id("main-page-content")).getTagName();
        System.out.println(tag);

        driver.get("https://pl.wikipedia.org/");
        WebElement search = driver.findElement(By.id("searchInput"));
        if(search.isEnabled()) {
            search.sendKeys("Selenium");
            search.submit();
        }else {
            Assert.fail();

            driver.get("https://pl.wikipedia.org/");
            WebElement search1 = driver.findElement(By.id("searchInput"));
            if(search.isDisplayed()) {
                search1.sendKeys("Selenium");
                search1.submit();
            }else {
                Assert.fail();
            }
        }
    }
}
