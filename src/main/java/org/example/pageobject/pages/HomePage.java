package org.example.pageobject.pages;

import org.example.pageobject.modules.ProductManipulation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.example.pageobject.utils.TypesOfData.*;

public class HomePage extends BasePage {
    @FindBy(id = "nav-global-location-popover-link")
    protected WebElement deliverField;

    @FindBy(id = "nav-cart")
    protected WebElement cartButton;

    @FindBy(xpath = "//div[@id='desktop-grid-2']//a")
    protected WebElement categoryPage;

    public HomePage(WebDriver webDriver)
    {
        super(webDriver);
    }

    public HomePage openPage()
    {
        webDriver.get("https://www.amazon.com/");

        String wrongPageID = "//a[@id='nav-bb-logo']";
        if (!webDriver.findElements(By.xpath(wrongPageID)).isEmpty())
        {
            webDriver.navigate().refresh();
        }
        return this;
    }

    public HomePage startPage()
    {
        deliverField.click();
        selectRegionFromDropDown().click();

        WebElement doneButton = getElementBy(NAME, "glowDoneButton", 10);
        doneButton.click();
        webDriver.navigate().refresh();

        return this;
    }

    public ProductPage openCategory()
    {
        categoryPage.click();
        return new ProductPage(webDriver);
    }

    public HomePage applyZipCode(String zipCode)
    {
        deliverField.click();
        WebElement zipCodeField = getElementBy(ID, "GLUXZipUpdateInput", 10);
        zipCodeField.sendKeys(zipCode);

        WebElement applyButton = getElementBy(XPATH, "//div[@class='a-column a-span4 a-span-last']", 10);
        applyButton.click();

        WebElement applyZipCodePopUpButton = getElementBy(XPATH, "//div[@class='a-popover-footer']/span", 10);
        applyZipCodePopUpButton.click();

        webDriver.navigate().refresh();

        return this;
    }
    public String zipCodeAddressUpdated()
    {
        WebElement deliverFieldUpdated = getElementBy(ID, "glow-ingress-line2", 10);

        return deliverFieldUpdated.getText().replaceAll("\\D", "");
    }
    public String isRegionPresent()
    {
        deliverField.click();
        return selectRegionFromDropDown().getText();
    }

    private WebElement selectRegionFromDropDown()
    {
        WebElement dropDownButton = getElementBy(ID, "GLUXCountryListDropdown", 10);
        dropDownButton.click();
        return getElementBy(XPATH, "//a[text()='"+ COUNTRY +"']", 10);
    }

    public SignInPage signIn()
    {
        deliverField.click();

        WebElement signInButton = getElementBy(ID,"GLUXSignInButton",10);
        signInButton.click();

        return new SignInPage(webDriver);
    }

    public CartPage openCart() {
        this.cartButton.click();
        return new CartPage(webDriver);
    }

    public HomePage searchForProduct() {
        WebElement searchBar = getElementBy(ID, "twotabsearchtextbox", 10);
        searchBar.click();
        searchBar.sendKeys("Wireless Charging Station");

        return this;
    }

    public ProductManipulation search() {
        WebElement searchButtonWithDelay = getElementBy(ID, "nav-search-submit-button", 15);
        searchButtonWithDelay.click();

        return new ProductManipulation(webDriver);
    }

    public HomePage fillInSearchField(String input) {
        WebElement searchBar = getElementBy(ID, "twotabsearchtextbox", 10);
        searchBar.click();
        searchBar.sendKeys(input);
        return this;
    }

    public SearchPage searchBtn(){
        WebElement searchButton = getElementBy(ID, "nav-search-submit-text", 10);
        searchButton.click();
        return new SearchPage(webDriver);
    }
}
