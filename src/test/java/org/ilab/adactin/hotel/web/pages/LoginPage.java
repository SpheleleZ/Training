package org.ilab.adactin.hotel.web.pages;

import org.ilab.adactin.hotel.web.utils.SelectMethods;
import org.ilab.adactin.hotel.web.utils.WaitMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WaitMethods wait;

    SelectMethods select;
    private final WebDriver driver;

    @FindBy(id = "username")
    @CacheLookup
    WebElement usernameInputField;

    @FindBy(id = "password")
    @CacheLookup
    WebElement passwordInputField;

    @FindBy(id = "login")
    @CacheLookup
    WebElement loginButton;

    @FindBy(xpath = "//b[text()=\"Invalid Login details or Your Password might have expired. \"]")
    @CacheLookup
    WebElement verifyUnsuccessfulLogin;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        wait = new WaitMethods(driver);
        select = new SelectMethods(driver);
        PageFactory.initElements(driver,this);
    }

    public void setUsernameInputField(String username){
        wait.waitForElementToDisplay(usernameInputField,20);
        usernameInputField.clear();
        usernameInputField.sendKeys(username);
    }

    public void setPasswordInputField(String password){
        wait.waitForElementToDisplay(passwordInputField,20);
        passwordInputField.clear();
        passwordInputField.sendKeys(password);
    }

    public HomePage setLoginButton(){
        wait.waitForElementToDisplay(loginButton,20);
        loginButton.click();
        return new HomePage(driver);
    }

    public String verifyUserLoginUnsuccessfully(){
        wait.waitForElementToDisplay(verifyUnsuccessfulLogin,20);
        return verifyUnsuccessfulLogin.getText();
    }
}
