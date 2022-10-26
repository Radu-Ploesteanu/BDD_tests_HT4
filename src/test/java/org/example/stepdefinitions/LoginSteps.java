package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageobject.pages.LoginPage;
import org.testng.Assert;

//import static org.example.props.Properties.GIT_HUB_PASSWORD;
import static org.example.stepdefinitions.BaseSteps.PAGES_STORAGE;
import static org.example.stepdefinitions.BaseSteps.webDriver;

public class LoginSteps {

    @Given("User is on {string}")
    public void userIsOnLoginPage(String pageName) {
        LoginPage loginPage = new LoginPage(webDriver);
        PAGES_STORAGE.put(pageName, loginPage);
        loginPage.open();
    }

    @When("User enters username as {string} and password on {string}")
    public void userEntersUsernameAsAndPasswordAs(String login, String pageName) {
        PAGES_STORAGE.put("Home Page", ((LoginPage) PAGES_STORAGE.get(pageName)).login(login, GIT_HUB_PASSWORD));
    }

    @When("User enters username as {string} and password as {string} on {string}")
    public void userEntersUsernameAsAndPasswordAsOn(String login, String pass, String pageName) {
        ((LoginPage) PAGES_STORAGE.get(pageName)).fillIncorrectData(login, pass);
    }

    @Then("User gets error message {string} on {string}")
    public void userGetsErrorMessage(String errorMessage, String pageName) {
        Assert.assertEquals(((LoginPage) PAGES_STORAGE.get(pageName)).clickSighInButtonAndReceiveErrorMessage(), errorMessage,
        "");
    }
}
