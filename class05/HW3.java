package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HW3 {

    public static String url = "http://www.ebay.com";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/jasonkaminsky/IdeaProjects/Selenium/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement categoriesDD = driver.findElement(By.id("gh-cat"));
        Select select = new Select(categoriesDD);
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            String optionText = option.getText();
            System.out.println(optionText);
        }

        select.selectByValue("58058"); // selecting Comps/Tablets & Networking category

        WebElement searchButton = driver.findElement(By.xpath("//input[@value = 'Buscar']"));
        searchButton.click();

        Thread.sleep(2000);

        WebElement header = driver.findElement(By.xpath("//span[text() = 'Computadoras y Accesorios']"));
        System.out.println("Is header present ? : " + header.isDisplayed());

    }
}
