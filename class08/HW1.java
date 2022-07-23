package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HW1 {

//    go to https://the-internet.herokuapp.com/dynamic_controls
//    click on checkbox and click on remove
//    verify the text
//    click on enable verify the textbox is enabled
//    enter text and click disable
//    verify the textbox is disabled

    public static String url = "https://the-internet.herokuapp.com/dynamic_controls";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement checkBox = driver.findElement(By.xpath("//input[@label = 'blah']"));
        checkBox.click();

        WebElement removeButton = driver.findElement (By.xpath("//button[text() = 'Remove']"));
        removeButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p#message")));

        String expectedMessage = "It's gone!";

        WebElement message = driver.findElement(By.cssSelector("p#message"));
        String actualMessage = message.getText();

        if(expectedMessage.equals(actualMessage)){
            System.out.println("The message has been verified");
        } else {
            System.out.println("The message was NOT verified");
        }

        WebElement enableButton = driver.findElement(By.xpath("//button[text() = 'Enable']"));
        enableButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//input[@type = 'text']"))));

        WebElement textBox = driver.findElement(By.xpath("//input[@type = 'text']"));

        wait.until(ExpectedConditions.elementToBeClickable(textBox));

        System.out.println("The textbox is enabled? : " + textBox.isEnabled());

        textBox.click();
        textBox.sendKeys("blehBlehbleh");

        WebElement disableButton = driver.findElement(By.xpath("//button[text() = 'Disable']"));
        disableButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'disabled!')]")));

        System.out.println("Is the textbox enabled? : " + textBox.isEnabled());

    }
}
