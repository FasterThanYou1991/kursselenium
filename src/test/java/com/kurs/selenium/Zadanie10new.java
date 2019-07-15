package com.kurs.selenium;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Zadanie10new {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver",
                "src/test/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
    }
    @Test
    public void  TestKatalonForm() {
        WebElement firstNameElement = driver.findElement((By.id("first-name")));
        firstNameElement.click();
        firstNameElement.sendKeys("Jan");

        WebElement lastNameElement = driver.findElement(By.id("last-name"));
        lastNameElement.click();
        lastNameElement.sendKeys("Kowalski");

        List<WebElement> genders = driver.findElements(By.name("gender"));
        genders.get(0).click();

        WebElement DateOfBirth = driver.findElement(By.id("dob"));
        DateOfBirth.sendKeys("05/22/2010");

        WebElement Address = driver.findElement(By.id("address"));
        Address.sendKeys("ul.Karmelkowa 25/1");

        WebElement Email = driver.findElement(By.id("email"));
        Email.sendKeys("alejaja@wp.pl");

        WebElement Password = driver.findElement(By.id("password"));
        Password.sendKeys("1234");

        WebElement Company = driver.findElement(By.id("company"));
        Company.sendKeys("Black Panthers");

        Select roleSelect = new Select(driver.findElement(By.id("role")));
        roleSelect.selectByVisibleText("Manager");

        WebElement developmentWays = driver.findElement(By.cssSelector("div.col-sm-10.development-ways"));

        List<WebElement> checkboxElements = developmentWays.findElements(By.xpath(".//input"));
        checkboxElements.get(0).click();
        checkboxElements.get(1).click();


        /*Select Expectation = new Select(driver.findElement(By.id("expectation")));
        Expectation.selectByIndex(1);
        Expectation.selectByVisibleText("Good teamwork");*/

        List<WebElement> checkboxElement = driver.findElements(By.xpath("//div//label//input"));
        checkboxElement.get(5).click();

        WebElement Comment = driver.findElement(By.id("comment"));
        Comment.sendKeys("Ale jaja, mój pierwszy automat");

        WebElement Submit = driver.findElement(By.id("submit"));
        Submit.click();

        /*Rozbuduj swój kod z zadania 10 o następujące elementy:

    Przed każdym elementem sprawdź czy jest on widoczny lub dostępny aby wpisać do niego tekst.
    Przed każdym elementem odczytaj jego nazwę a następnie wyświetl ją w konsoli w formacie - nazwa pola : wpisywana wartość

*/
    }
}
