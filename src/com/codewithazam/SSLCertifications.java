package com.codewithazam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SSLCertifications {

    public static void main(String[] args) {

        DesiredCapabilities ch = new DesiredCapabilities();
        //ch.acceptInsecureCerts();
        ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
        ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);

        ChromeOptions c = new ChromeOptions();
        c.merge(ch);

        System.setProperty("webdriver.chrome.driver", "/Users/codewithazam/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver(c);


    }
}
