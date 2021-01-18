package com.codewithazam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BrokenLinksSelenium {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "/Users/codewithazam/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        //String url = driver.findElement(By.cssSelector("a[href*='appium']")).getAttribute("href");

        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert softAssert = new SoftAssert();
        for (WebElement link : links) {
            String url = link.getAttribute("href");

            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int respCode = conn.getResponseCode();
            System.out.println(respCode);
            softAssert.assertTrue(respCode<400,"Link" + link.getText() + " " + respCode + " is broken.");
           /* if (respCode > 400) {
                System.out.println("Link " + link.getText() + " " + respCode + " is broken.");
                Assert.assertTrue(false);
            }*/
        }
        softAssert.assertAll();
    }
}
