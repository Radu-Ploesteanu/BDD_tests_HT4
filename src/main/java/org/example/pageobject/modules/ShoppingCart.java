package org.example.pageobject.modules;

import org.example.pageobject.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.example.pageobject.utils.TypesOfData.ID;

public class ShoppingCart extends BasePage {

    public ShoppingCart(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean confirmAddedItem() {
        WebElement confirmationMessage = getElementBy(ID, "NATC_SMART_WAGON_CONF_MSG_SUCCESS", 15);

        return confirmationMessage.getText().equals("Added to Cart");
    }
}
