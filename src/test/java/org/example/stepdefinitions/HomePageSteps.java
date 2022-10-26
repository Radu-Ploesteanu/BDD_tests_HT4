package org.example.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.pageobject.pages.HomePage;

import static org.example.stepdefinitions.BaseSteps.webDriver;

public class HomePageSteps {
    @Given("User is on Home Page")
    public void userIsOnHomePage() {
        HomePage homePage =  new HomePage(webDriver);
        homePage.openPage();
    }

    @When("User click on Cart Button")
    public void userClickOnCartButton() {
        HomePage homePage =  new HomePage(webDriver);
        homePage.openCart();
    }

    @When("User searches for an item")
    public void userSearchesForAnItem() {
        HomePage homePage = new HomePage(webDriver);
        homePage.searchForProduct();
    }

    @And("User clicks on search button")
    public void userClicksOnSearchButton() {
        HomePage homePage = new HomePage(webDriver);
        homePage.searchBtn();
    }

    @When("User searches for an item named {string}")
    public void userSearchesForAnItemNamed(String wrongItem) {
        HomePage homePage = new HomePage(webDriver);
        homePage.fillInSearchField(wrongItem);
    }
}
