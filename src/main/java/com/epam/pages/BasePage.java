package com.epam.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    WebDriver driver;

    public void waitFor(long seconds) throws InterruptedException {
        synchronized (driver) {
            driver.wait(seconds * 1000L); // Wait for 100ms
        }
    }

}
