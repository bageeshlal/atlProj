package com.webdriver.tests;

import com.webdriver.pages.BlankPage;
import com.webdriver.pages.Navigation;
import com.webdriver.pages.PublishedPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class CreatePageTest extends TestBase {

    // Tests that a page is created using the quick create function in Confluence
    @Test
    public void testCreatePage() throws InterruptedException {

        // Log In
        String username = "bageeshlal@gmail.com";
        String password = "B@geeshl2l";

        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login")).click();
        Thread.sleep(2000);

        // Go to Create Page
        Navigation nav = PageFactory.initElements(driver, Navigation.class);
        nav.selectQuickCreateButton();
        Thread.sleep(2000);

        // Add content to the page & save
        String[] testData = {"test page title", "{status:colour=Green|title=Testing Create Page|subtle=true}"};
        BlankPage page = PageFactory.initElements(driver, BlankPage.class);
        page.fillTitleBar(testData[0]);
        driver.switchTo().frame("wysiwygTextarea_ifr");
        page.fillBody(testData[1]);
        driver.switchTo().defaultContent();
        page.selectSaveButton();
        Thread.sleep(5000);

        // Check creating the page worked
        PublishedPage newPage = PageFactory.initElements(driver, PublishedPage.class);
        newPage.validatePageCreated(testData);

        // Check the comment box functionality
        newPage.enterEmphasisedCommentInCommentBox("test comment $@%");
        newPage.validateCommentBoxTextIsEmphasised("test comment $@%");

    }


}

