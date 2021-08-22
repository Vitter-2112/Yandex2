package com.yandex2.task.fw;

import com.yandex2.task.model.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class MarketItemHelper extends HelperBase {
    public MarketItemHelper(WebDriver wd) {super(wd);
    }

    public void filterItem(Item item) {
        click(By.xpath("//div/div[2]/div[2]/ul/li[1]/div/a"));

        type(By.cssSelector("#glpricefrom"), item.getPriceFrom());
        type(By.cssSelector("#glpriceto"), item.getPriceTo());
//[name$='Apple']  //*[@id="7893318_153043"]
        click(By.xpath("//*[text()='"+ item.getBrand() +"']"));
    }
    //perekluchit na drugoj tab
    public void switchToNextTab() {
        List<String> availableTabs = new ArrayList<>(wd.getWindowHandles());
        if (!availableTabs.isEmpty()) {
            wd.switchTo().window(availableTabs.get(1));

        }
    }

    public String getItemNameFromListByOrder(int number) {
        return wd.findElement(By.xpath("//*[@data-autotest-id='product-snippet'][" + number + "]//h3")).getText();
    }

}
