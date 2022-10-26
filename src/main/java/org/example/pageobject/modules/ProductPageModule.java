package org.example.pageobject.modules;

import org.example.pageobject.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.example.pageobject.utils.TypesOfData.XPATH;

public class ProductPageModule extends BasePage {

    public ProductPageModule(WebDriver webDriver) {
        super(webDriver);
    }

    public ShoppingCart addToCart() {
        WebElement addToCartBtn = getElementBy(XPATH, "//input[@id='add-to-cart-button']", 10);
        addToCartBtn.click();

        return new ShoppingCart(webDriver);
    }
}
