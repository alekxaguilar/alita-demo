package com.epam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    // Locators
    private final By inventoryContainer = By.id("inventory_container");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isInventoryDisplayed() {
        return driver.findElement(inventoryContainer).isDisplayed();
    }
}
