package com.yandex2.task.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MarketHeaderHelper extends HelperBase {

    public MarketHeaderHelper(WebDriver wd) {
        super(wd);
    }

    public void selectComputersDept(By locator) throws InterruptedException {
        click(locator);
        pause(200);
        if (isElementPresent(By.cssSelector("button[data-text='Принять все']"))) {
            click(By.cssSelector("button[data-text='Принять все']"));
        }
    }
    public void searchItemFromSearchBox(String itemName) {
        type(By.cssSelector("#header-search"), itemName);
        click(By.cssSelector("[type=submit]"));
    }
    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

}
