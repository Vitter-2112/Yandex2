package com.yandex2.task.tests;

import com.yandex2.task.model.Item;
import com.yandex2.task.fw.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchItemTest extends TestBase {
    /*
3.	Перейти на Яндекс Маркет
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
    @Test
    public void searchItemTest() throws InterruptedException {
        app.getMainPage().goToMarket(By.cssSelector("[data-id='market']"));
        app.getMarketItem().switchToNextTab();
        app.getMarketHelper().selectComputersDept(By.cssSelector("[href*='/catalog--elektronika']"));
        //metod kak prokrutit stranicu wniz!!!
        //Actions actions= new Actions(wd);
        //actions.sendKeys(Keys.PAGE_DOWN).build().perform();

        app.getMarketItem().filterItem(new Item()
                .setPriceFrom("20000")
                .setPriceTo("40000")
                .setBrand("Apple"));
        String item = app.getMarketItem().getItemNameFromListByOrder(2);


        System.out.println(item);
        String itemName = app.getMarketItem().getItemNameFromListByOrder(2);
        app.getMarketHelper().searchItemFromSearchBox(itemName);
        app.getMainPage().pause(300);
        String foundItem = app.getMarketItem().getItemNameFromListByOrder(1);
        Assert.assertEquals(foundItem, itemName);
    }

}







