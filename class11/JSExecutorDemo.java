package com.syntax.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSExecutorDemo {

    public static String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("Hum@nhrm123");

        JavascriptExecutor js = (JavascriptExecutor) driver;  //downcast the interface JavascriptExecutor creating an object js
        js.executeScript("arguments[0].style.backgroundColor='yellow'", username);
        js.executeScript("arguments[0].style.backgroundColor='chartreuse'", password);
        //"arguments[0].style.backgroundColor='yellow'   built in script

        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        //loginButton.click();
        js.executeScript("arguments[0].click()", loginButton);

    }
}