package org.example.stepdefinitions;

import io.cucumber.java.en.And;
import org.example.pageobject.modules.ProductPageModule;

import static org.example.stepdefinitions.BaseSteps.webDriver;

public class ProductPageSteps {

    @And("User adds the item to the cart")
    public void userAddsTheItemToTheCart() {
        ProductPageModule productPageModule = new ProductPageModule(webDriver);
        productPageModule.addToCart();
    }
}
