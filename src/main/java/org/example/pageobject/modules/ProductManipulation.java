package org.example.pageobject.modules;

import org.example.pageobject.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.example.pageobject.utils.TypesOfData.*;

public class ProductManipulation extends BasePage {

    public ProductManipulation(WebDriver webDriver) {
        super(webDriver);
    }

    public String getBrandName() {
        WebElement brand = getElementBy(XPATH, "//span[text()='Featured Brands']/../following-sibling::ul/li[2]//a", 10);
        return brand.getText();
    }

    public Boolean checkProductsInPriceRange(WebElementsList listOfPrices) {
        WebElement highPrice = getElementBy(ID, "high-price", 10);
        WebElement lowPrice = getElementBy(ID, "low-price", 10);

        double high = listOfPrices.getPrice(highPrice, "value");
        double low = listOfPrices.getPrice(lowPrice, "value");

        return listOfPrices.checkIfPriceInRange(high, low);
    }

    public ProductManipulation sortPricesLowToHigh() {
        WebElement sortDropdownButton = getElementBy(XPATH, "//span[@class='a-dropdown-container']", 10);
        sortDropdownButton.click();

        WebElement lowHigh = getElementBy(ID, "s-result-sort-select_1", 10);
        lowHigh.click();

        return new ProductManipulation(webDriver);
    }

    public Boolean checkIfSorted(WebElementsList listOfPrices) {
        return listOfPrices.sortedPrices("//span[@class='a-price-whole']");
    }

    public ProductPageModule findItemForCart() {
        WebElement availableProduct = getElementBy(XPATH, "//span[contains(text(),'Ships to')]/../../../../../..//a[contains(@class,'a-link-normal')]", 15);
        availableProduct.click();

        return new ProductPageModule(webDriver);
    }

    public Boolean deliveryAddressUpdated()
    {
        WebElement regionSelect = getElementBy(XPATH,"//div[@id='contextualIngressPtLabel_deliveryShortLine']/span[2]",
                10);
        return COUNTRY.equals(regionSelect.getText());
    }
}
