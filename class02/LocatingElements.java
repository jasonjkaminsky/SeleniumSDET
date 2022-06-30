package com.syntax.class02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;


public class LocatingElements {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
                WebDriver driver = new ChromeDriver();
                driver.get("https://fb.com");
        driver.findElement(By.id("email")).sendKeys("syntax@threjhrhuitr.com");
        driver.findElement(By.id("pass")).sendKeys("whatever");
        driver.findElement(By.name("login")).click();
        Thread.sleep(2000);
//        driver.findElement(By.linkText("Forgot password?")).click();
        driver.findElement(By.partialLinkText("Forgot")).click();
        driver.quit();


    }

}
