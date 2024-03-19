package org.ilab.adactin.hotel.web.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitMethods {
    protected WebDriver driver;

    public WaitMethods(WebDriver driver){
        this.driver = driver;
    }

    public void waitForElementToDisplay(WebElement element,long timeOutInSeconds){
        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
