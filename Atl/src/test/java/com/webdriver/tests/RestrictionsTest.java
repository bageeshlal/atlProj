package com.webdriver.tests;

import com.webdriver.pages.PublishedPage;
import com.webdriver.pages.Navigation;
import com.webdriver.pages.RestrictionsDialog;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.junit.Test;

public class RestrictionsTest extends TestBase {

    private String username = "bageeshlal@gmail.com";
    private String password = "B@geeshl2l";

    // Tests that restricting a page works when set to the current user
    @Test
    public void Test1() throws InterruptedException {

        // Log In
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login")).click();
        Thread.sleep(2000);

        // Open Existing Page
        Navigation nav = PageFactory.initElements(driver, Navigation.class);
        nav.openExistingPage();
        Thread.sleep(2000);

        // Open Restrictions Dialog
        PublishedPage page = PageFactory.initElements(driver, PublishedPage.class);
        page.selectRestrictionIcon();
        Thread.sleep(3000);

        // Select Restriction Type
        RestrictionsDialog dialog = PageFactory.initElements(driver, RestrictionsDialog.class);
        dialog.setEditPermissions();
        dialog.selectCancelButton();

    }

    // Tests that restricting a page works when set to a different user
    @Test
    public void Test2() throws InterruptedException {

        // Log In
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login")).click();
        Thread.sleep(2000);

        // Open Existing Page
        Navigation nav = PageFactory.initElements(driver, Navigation.class);
        nav.openExistingPage();
        Thread.sleep(2000);

        // Open Restrictions Dialog
        PublishedPage page = PageFactory.initElements(driver, PublishedPage.class);
        page.selectRestrictionIcon();
        Thread.sleep(3000);

        // Select Restriction Type
        RestrictionsDialog dialog = PageFactory.initElements(driver, RestrictionsDialog.class);
        dialog.setViewEditPermissions();
        dialog.searchUser("System Administrator");
        dialog.selectCancelButton();

    }

    // Tests that restricting a page works when set to a group
    @Test
    public void Test3() throws InterruptedException {

        // Log In
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login")).click();
        Thread.sleep(2000);

        // Open Existing Page
        Navigation nav = PageFactory.initElements(driver, Navigation.class);
        nav.openExistingPage();
        Thread.sleep(2000);

        // Open Restrictions Dialog
        PublishedPage page = PageFactory.initElements(driver, PublishedPage.class);
        page.selectRestrictionIcon();
        Thread.sleep(3000);

        // Select Restriction Type
        RestrictionsDialog dialog = PageFactory.initElements(driver, RestrictionsDialog.class);
        dialog.setViewEditPermissions();
        dialog.searchUser("confluence-users");
        dialog.selectCancelButton();

        // Remove existing page
        Thread.sleep(2000);
        page.deletePage();

    }

}

