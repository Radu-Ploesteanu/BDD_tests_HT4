package org.example.pageobject.utils;

import org.openqa.selenium.WebElement;

import java.text.DecimalFormat;

public class ConvertToDouble {

    public Double convertToDouble(WebElement price) {
        double doubleValueOfPrice = Double.parseDouble(price
                .getText()
                .substring(1)
                .replaceAll(",", ""));
        return getRoundNumber(doubleValueOfPrice);
    }

    private Double getRoundNumber (Double nr) {
        DecimalFormat df = new DecimalFormat("0.00");
        return Double.parseDouble(df.format(nr));
    }
}
