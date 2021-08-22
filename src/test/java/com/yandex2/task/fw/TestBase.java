package com.yandex2.task.fw;

import com.yandex2.task.fw.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {
    protected static ApplicationManager app = new ApplicationManager();
    WebDriver wd;

    @BeforeClass
    public void setUp() {
        app.init();
    }

    @AfterClass(enabled = false)
    public void tearDown() {
        app.stop();
    }

}
