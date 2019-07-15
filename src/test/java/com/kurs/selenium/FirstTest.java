package com.kurs.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver",
                "src/test/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://www.google.com");
    }

    @Test
    public void testGoogleSearch() {
        WebElement element = driver.findElement(By.name("q"));
        element.clear();
        element.sendKeys("Testowanie Selenium");
        element.submit();
    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
    }

}