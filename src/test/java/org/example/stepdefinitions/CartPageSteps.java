package org.example.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.pageobject.modules.ShoppingCart;
import org.example.pageobject.pages.CartPage;
import org.testng.Assert;

import static org.example.stepdefinitions.BaseSteps.webDriver;

public class CartPageSteps {
    @Then("Cart Page is displayed")
    public void cartPageIsDisplayed() {
        CartPage cartPage = new CartPage(webDriver);
        Boolean cartPageValidation = cartPage.checkPageTitle();

        Assert.assertTrue(cartPageValidation, "The accessed page is not the Shopping Cart");
    }

    @Then("The selected item should be present in the cart")
    public void theSelectedItemShouldBePresentInTheCart() {
        ShoppingCart shoppingCart = new ShoppingCart(webDriver);
        Boolean itemIsAdded = shoppingCart.confirmAddedItem();

        Assert.assertTrue(itemIsAdded, "The confirmation messages do not match or the item was not added to the cart.");
    }

    @And("User click on Delete button")
    public void userClickOnDeleteButton() {
        CartPage cartPage = new CartPage(webDriver);
        cartPage.deleteItems();
    }

    @Then("The item is removed from the cart")
    public void theItemIsRemovedFromTheCart() {
        CartPage cartPage = new CartPage(webDriver);
        String deleteConfirmation = cartPage.getDeleteMessage();

        Assert.assertTrue(deleteConfirmation.contains("Your Amazon Cart is empty"), "Not all items were deleted -> " +
                "check your method");
    }

    @And("The User is presented with the confirmation message")
    public void theUserIsPresentedWithTheConfirmationMessage() {
        CartPage cartPage = new CartPage(webDriver);
        String emptyCartMessage = cartPage.getEmptyCartMessage();

        Assert.assertEquals(emptyCartMessage, "Your Amazon Cart is empty", "The strings don't match / cart not empty");
    }
}
