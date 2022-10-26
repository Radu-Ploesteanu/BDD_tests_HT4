package org.example.pageobject.modules;

import org.example.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfileDropDownModule extends BasePage {
    private WebElement userInfo;

    public ProfileDropDownModule(WebDriver webDriver) {
        super(webDriver);
    }

    public String getUserNameInfo() {
        userInfo = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//strong[text()=\"juliaHrabovska\"]")));
        return userInfo.getText();
    }
}
