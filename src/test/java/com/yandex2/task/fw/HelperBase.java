package com.yandex2.task.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBase {
    WebDriver wd;
    public HelperBase(WebDriver wd) {
        this.wd=wd;
    }


    public void type(By locator, String text) {
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }
    //[name='Цена от']   [id='glpricefrom'] #glpricefrom//#glpriceto
    public void click(By locator) {
        wd.findElement(locator).click();
    }
    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }
}
