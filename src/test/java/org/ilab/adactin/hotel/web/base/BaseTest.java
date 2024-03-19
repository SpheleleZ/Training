package org.ilab.adactin.hotel.web.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected WebDriver driver;

    public BaseTest(WebDriver driver){
        this.driver = driver;
    }

    public void openPage(String url){
        driver.get(url);
    }
}
