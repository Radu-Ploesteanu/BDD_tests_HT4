package org.example.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.pageobject.modules.ProductManipulation;
import org.example.pageobject.pages.SearchPage;

import static org.example.stepdefinitions.BaseSteps.webDriver;
import static org.testng.Assert.assertEquals;

public class ProductListPageSteps {
    @And("User finds an item to be added to the cart")
    public void userFindsAnItemForCart() {
        ProductManipulation productManipulation = new ProductManipulation(webDriver);
        productManipulation.findItemForCart();
    }

    @Then("The User is met with an error message for the searched item {string}")
    public void theUserIsMetWithAnErrorMessageForTheSearchedItem(String actualResult) {
        SearchPage searchPage = new SearchPage(webDriver);
        String expectedResult = searchPage.validateResultText();

        assertEquals("No results for " + actualResult + ".", expectedResult, "The searched item does not exist");
    }
}
