package org.example.pageobject.modules;

import org.example.pageobject.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.example.pageobject.utils.TypesOfData.VALID_INPUT;

public class WebElementsList extends BasePage {
    private Boolean isTrue = true;

    public WebElementsList(WebDriver webDriver) {
        super(webDriver);
    }

    public Boolean sortedPrices(String xpath) {
        List<WebElement> prices = new ArrayList<>(new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))));

        List<Double> priceList = priceListMaker(prices);

        for (int i = 1; i < priceList.size(); i++) {
            if (priceList.get(i) < priceList.get(i - 1)) {
                isTrue = false;
                break;
            }
        }

        return isTrue;
    }

    public Boolean checkIfPriceInRange(double high, double low) {
        List<WebElement> prices = new ArrayList<>(new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='a-price-whole']"))));

        List<Double> priceList = priceListMaker(prices);

        for (Double doublePrice : priceList) {
            if ((doublePrice > high) || (doublePrice < low)) {
                isTrue = false;
                break;
            }
        }

        return isTrue;
    }

    public Boolean checkKeywordAppearancesInList(String keyword) {
        List<WebElement> items = new ArrayList<>(new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"))));

        int counter = 0;
        for (WebElement item : items) {
            if (item.getText().toLowerCase().contains(keyword.toLowerCase())) {
                counter += 1;
            }
        }

        return counter == items.size();
    }

    public Boolean checkAtLeastOneInput(String xpath) {
        List<WebElement> items = new ArrayList<>(new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))));

        int counter = 0;
        for (WebElement item : items) {
            if (item.getText().toLowerCase().contains(VALID_INPUT)) {
                counter++;
            }
        }

        return counter > 0;
    }


    public double getPrice(WebElement price, String htmlAttribute) {

        return doubleMaker(price.getAttribute(htmlAttribute));
    }

    private Double doubleMaker(String toBeConverted) {
        return Double.parseDouble(toBeConverted);
    }

    private List<Double> priceListMaker(List<WebElement> prices) {
        List<Double> priceList = new ArrayList<>();

        for (WebElement price : prices) {
            priceList.add(doubleMaker(price.getText()));
        }
        return priceList;
    }
}
