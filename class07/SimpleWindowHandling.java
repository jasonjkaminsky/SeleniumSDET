package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class SimpleWindowHandling {

    public static String url = "http://accounts.google.com/signup";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        String mainPageHandle = driver.getWindowHandle();
        System.out.println(mainPageHandle);

        WebElement helpLink = driver.findElement(By.linkText("Ayuda"));
        helpLink.click();

        Set<String> allWindowHandles = driver.getWindowHandles(); //store all the handles inside the set (set doesn't allow duplicate values)
        System.out.println(allWindowHandles.size());

        Iterator<String> it = allWindowHandles.iterator(); // have an iterator in order to iterate thru the handles
        mainPageHandle = it.next();  // take first step and assign the main page handle
        String childHandle = it.next(); // take the 2nd step and make "child handle"

        System.out.println(childHandle);
        Thread.sleep(2000);
        driver.switchTo().window(childHandle);
        driver.close();
        driver.switchTo().window(mainPageHandle);
        helpLink.click();

        driver.quit();

    }
}
