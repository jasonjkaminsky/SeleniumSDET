package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HW2 {

    public static String url = "http://www.facebook.com";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/jasonkaminsky/IdeaProjects/Selenium/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement createAcctButton = driver.findElement(By.partialLinkText("Create"));
        createAcctButton.click();

        Thread.sleep(3000);

        WebElement firstNameInput = driver.findElement(By.xpath("//input[@name = 'firstname']"));
        firstNameInput.sendKeys("Brad");
        WebElement lastNameInput = driver.findElement(By.xpath("//input[@name = 'lastname']"));
        lastNameInput.sendKeys("Stevens");

        WebElement emailInput = driver.findElement(By.xpath("//input[@name = 'reg_email__']"));
        emailInput.sendKeys("Brad.Stevens26@gmail.com");

        WebElement emailConfirmInput = driver.findElement(By.xpath("//input[@name = 'reg_email_confirmation__']"));
        emailConfirmInput.sendKeys("Brad.Stevens26@gmail.com");

        WebElement passwordInput = driver.findElement(By.id("password_step_input"));
        passwordInput.sendKeys("minombreesBr@d");

        WebElement yearsDD = driver.findElement(By.id("year"));
        Select select = new Select(yearsDD);
        select.selectByVisibleText("1969");

        WebElement gender = driver.findElement(By.xpath("//input[@value = '-1']"));
        gender.click();
        WebElement genderDD = driver.findElement(By.xpath("//select[@aria-label = 'Select your pronoun']"));
        Select select2 = new Select(genderDD);
        select2.selectByValue("6");

        WebElement submitButton = driver.findElement(By.xpath("//button[@name = 'websubmit']"));
        submitButton.click();
    }
}
