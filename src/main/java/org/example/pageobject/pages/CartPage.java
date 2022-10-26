package org.example.pageobject.pages;

import org.example.pageobject.utils.ConvertToDouble;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.example.pageobject.utils.TypesOfData.XPATH;

public class CartPage extends BasePage {

    private final ConvertToDouble priceConverter = new ConvertToDouble();

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public Boolean checkPageTitle() {
        String pageTitleH1 = webDriver.getTitle();
        String expectedTitle = "Amazon.com Shopping Cart";

        return pageTitleH1.equals(expectedTitle);
    }

    public Integer getTotalItems() {
        WebElement totalItemInfo = getElementBy(XPATH, "//span[@id='sc-subtotal-label-activecart']", 5);
        return Integer.parseInt(totalItemInfo.getText().replaceAll("\\D", ""));
    }

    public Double getItemPrice() {
        WebElement priceOfItem = getElementBy(XPATH, "//span[contains(@class, 'sc-product-price')]", 15);

        return priceConverter.convertToDouble(priceOfItem);
    }

    public CartPage increaseQuantity(int amountOfProducts) {
        WebElement dropDownBtn = getElementBy(XPATH, "//*[@class='a-dropdown-label']", 15);
        dropDownBtn.click();

        String quantityXpath = "//a[@id='quantity_" + amountOfProducts + "']";

        WebElement newQuantity = getElementBy(XPATH, quantityXpath, 15);
        newQuantity.click();

        webDriver.navigate().refresh();

        return this;
    }

    public Double getTotalPrice() {
        WebElement totalPrice = getElementBy(XPATH, "//form[@id='activeCartViewForm']/div/span[@id='sc-subtotal-amount-activecart']/span", 10);

        return priceConverter.convertToDouble(totalPrice);
    }

    public String getDeleteMessage() {
        WebElement deleteConfirmation = getElementBy(XPATH, "//h2[contains(text(),'Cart is empty')]", 10);

        return deleteConfirmation.getText();
    }

    public CartPage deleteItems() {
        WebElement deleteItemBtn = getElementBy("xpath", "//input[@value='Delete']", 5);
        deleteItemBtn.click();

        webDriver.navigate().refresh();

        return this;
    }

    public String getEmptyCartMessage() {
        WebElement emptyCartConfirmation = getElementBy(XPATH, "//*[contains(text(),'Cart is empty')]", 10);
        if (emptyCartConfirmation.isDisplayed()) {
           return emptyCartConfirmation.getText();
        } else {
            return "Text not present - something went wrong";
        }
    }
}
