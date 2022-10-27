package org.example.pageobject.pages;

import org.example.pageobject.modules.WebElementsList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.example.pageobject.utils.TypesOfData.*;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean validateResult() {
        WebElement errorMessage = webDriver.findElement(By.xpath("//div[contains(@class,'a-row')]"));
        String errorText = errorMessage.getText();

        return errorText.equals(String.format("No results for %s.", WRONG_INPUT));
    }

    public String validateResultText() {
        WebElement errorMessage = getElementBy(XPATH, "//span[text()='No results for ']/..", 10);

        return errorMessage.getText();
    }

    public boolean checkPresentInput() {
        WebElement searchedWord = webDriver.findElement(By.xpath("//span[@class=\"a-color-state a-text-bold\"]"));
        String word = searchedWord.getText();

        return (String.format("\"%s\"", VALID_INPUT)).equals(word);
    }

    public boolean checkIfKeywordIsPresent(WebElementsList itemsList) {
        return itemsList.checkAtLeastOneInput("//span[@class='a-size-medium a-color-base a-text-normal']");
    }
}
