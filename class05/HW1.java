package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HW1 {

    public static String url = "http://www.facebook.com";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/jasonkaminsky/IdeaProjects/Selenium/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement createAcctButton = driver.findElement(By.partialLinkText("Create"));
        createAcctButton.click();

        Thread.sleep(4000);

        WebElement monthsDD = driver.findElement(By.id("month"));
        Select selectMonths = new Select(monthsDD);

        List<WebElement> allOptionsMonths = selectMonths.getOptions();
        int sizeMonths = allOptionsMonths.size();
        System.out.println("The months dropdown has " + sizeMonths + " days");

        WebElement daysDD = driver.findElement(By.id("day"));
        Select selectDays = new Select(daysDD);

        List<WebElement> allOptionsDays = selectDays.getOptions();
        int sizeDays = allOptionsDays.size();
        System.out.println("The days dropdown has " + sizeDays + " months");

        WebElement yearsDD = driver.findElement(By.id("year"));
        Select selectYears = new Select(yearsDD);

        List<WebElement> allOptionsYears = selectYears.getOptions();
        int sizeYears = allOptionsYears.size();
        System.out.println("The years dropdown has " + sizeYears + " years");

        selectMonths.selectByValue("4");
        selectDays.selectByValue("19");
        selectYears.selectByValue("1983");

        Thread.sleep(2000);
        driver.quit();

    }
}
