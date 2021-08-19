package com.yandex2.task;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchItemTest {
    WebDriver wd;

    @BeforeClass
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.navigate().to("https://yandex.ru/");
    }


    @AfterClass(enabled = false)
    public void tearDown() {
        wd.quit();
    }

    @Test
    /*3.	Перейти на Яндекс Маркет
4.	Выбрать раздел  Компьютеры
5.	 Выбрать раздел Планшеты
6.	Зайти в расширенный поиск
7.	Задать параметр поиска от 20000 до 35000 рублей.
8.	Выбрать производителя “Apple”
9.	Применить условия поиска
10.	Запомнить второй элемент в результатах поиска
11.	В поисковую строку ввести запомненное значение.
12.	Найти и проверить, что наименование товара соответствует запомненному значению."button[data-text='Принять все']"
*/
    public void searchItemTest() throws InterruptedException {
        click(By.cssSelector("[data-id='market']"));
        switchToNextTab();
        click(By.cssSelector("[href*='/catalog--elektronika']"));
        pause(200);
        if (isElementPresent(By.cssSelector("button[data-text='Принять все']"))) {
         click(By.cssSelector("button[data-text='Принять все']"));
        }
        //metod kak prokrutit stranicu wniz!!!
        //Actions actions= new Actions(wd);
        //actions.sendKeys(Keys.PAGE_DOWN).build().perform();

        click(By.xpath("//div/div[2]/div[2]/ul/li[1]/div/a"));

        type(By.cssSelector("#glpricefrom"), "20000");
        type(By.cssSelector("#glpriceto"), "40000");
//[name$='Apple']  //*[@id="7893318_153043"]
        click(By.xpath("//*[text()='Apple']"));
        String item = wd.findElement(By.xpath("//*[@data-autotest-id='product-snippet'][2]//h3")).getText();
        System.out.println(item);
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
//perekluchit na drugoj tab
    public void switchToNextTab() {
        List<String> availableTabs = new ArrayList<>(wd.getWindowHandles());
        if (!availableTabs.isEmpty()) {
            wd.switchTo().window(availableTabs.get(1));

        }
    }

    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }
}

