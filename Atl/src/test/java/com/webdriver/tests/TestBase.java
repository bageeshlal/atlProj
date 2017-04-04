package com.webdriver.tests;

// *********************************************************
//  Atlassian automation exercise webdriver tests
// *********************************************************

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class TestBase {

    WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        ChromeDriverManager.getInstance().setup();
    }

    @Before
    public void setupTest() {
        String siteUrl = "https://bageeshlal.atlassian.net/wiki";
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 850));
        driver.navigate().to(siteUrl);
    }

    @After
    public void tearDownTest() {
        driver.quit();
    }

}
