package com.yandex2.task.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    MainPageHelper mainPage;
    MarketItemHelper marketItem;
    MarketHeaderHelper marketHelper;

    public MainPageHelper getMainPage() {
        return mainPage;
    }

    public MarketItemHelper getMarketItem() {
        return marketItem;
    }

    public MarketHeaderHelper getMarketHelper() {
        return marketHelper;
    }

    public void init() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        openSite("https://yandex.ru/");

        mainPage = new MainPageHelper(wd);
        marketItem = new MarketItemHelper(wd);
        marketHelper = new MarketHeaderHelper(wd);
    }
    public void openSite(String url) {
        wd.navigate().to(url);
    }

    public void stop() {
        wd.quit();
    }



    }




