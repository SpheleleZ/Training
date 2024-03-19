package org.ilab.adactin.hotel.web.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.ilab.adactin.hotel.web.base.BaseTest;
import org.ilab.adactin.hotel.web.pages.HomePage;
import org.ilab.adactin.hotel.web.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class AdictinHotelStepsDefinition {

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    BaseTest base;


    @Before
    public void setUpMethod(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        base = new BaseTest(driver);
        System.out.println("Launch the Browser ...........");
    }

    @After
    public void tearDownMethod(){
        driver.quit();
        System.out.println("Close the Browser.........");
    }

    @Given("User navigate to login page {string} build two")
    public void user_navigate_to_login_page_build_two(String url) {
        base.openPage(url);
    }

    /**********************************************************************************
     * Login Steps definitions
     * ********************************************************************************
     */

    @When("^User enters valid username (.*)$")
    public void user_enters_valid_username_(String username) {
      loginPage.setUsernameInputField(username);
    }

    @And("^Enters valid password (.*)$")
    public void enters_valid_password_(String password) {
      loginPage.setPasswordInputField(password);
    }

    @Then("User should login successfully")
    public void user_should_login_successfully() {
        assertEquals(homePage.verifyUserLoggedInSuccessfully(),"Adactin.com - Search Hotel"
                ,"User login not successful");
    }

    @When("^User enters invalid username (.*)$")
    public void user_enters_invalid_username_(String username) {
      loginPage.setUsernameInputField(username);
    }

    @And("^Enters invalid password (.*)$")
    public void enters_invalid_password_(String password) {
      loginPage.setPasswordInputField(password);
    }

    @Then("User should get a proper warning message")
    public void user_should_get_a_proper_warning_message() {
        assertTrue(loginPage.verifyUserLoginUnsuccessfully().contains("Invalid Login details or Your Password might have expired")
                ,"Login message not correct");
    }

    @And("Click on login button")
    public void click_on_login_button() {
        homePage = loginPage.setLoginButton();
    }
}
