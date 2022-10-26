package org.example.pageobject.pages;

import org.example.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "login_field")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(name = "commit")
    private WebElement sighInButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage open() {
        webDriver.get("https://www.github.com/login");
        return this;
    }

    public HomePage login(String username, String pass) {
        loginField.sendKeys(username);
        passwordField.sendKeys(pass);
        sighInButton.click();

        return new HomePage(webDriver);
    }

    public void fillIncorrectData(String username, String pass) {
        loginField.sendKeys(username);
        passwordField.sendKeys(pass);
    }

    public String clickSighInButtonAndReceiveErrorMessage() {
        sighInButton.click();
        return webDriver.findElement(By.id("js-flash-container")).getText();
    }

}
