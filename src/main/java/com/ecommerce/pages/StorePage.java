package com.ecommerce.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class StorePage extends BasePage {

    private By storeHeader = By.cssSelector("img[alt='Test Store']");
    private By signOutBtn = By.cssSelector(".hidden-sm-down.logout");
    private By signInBtn = By.cssSelector(".user-info .hidden-sm-down");
    private By defaultStoreBanner = By.cssSelector("img[alt='sample-1']");
    private By productItemOne = By.cssSelector(".products.row [data-id-product='1']");
    private By wishlistButton = By.cssSelector(".products.row [data-id-product='1'] [class='wishlist-button-add']");
    private By wishlistModal = By.cssSelector(".show .modal-content");
    private By cancelModalBtn = By.cssSelector(".show .btn-secondary");

    public boolean isStoreHeaderDisplayed() {
        return find(storeHeader).isDisplayed();
    }

    public StorePage clickOnSignOutBtn() {
        click(signOutBtn);
        return new StorePage();
    }

    public LoginPage clickOnSignInBtn() {
        click(signInBtn);
        return new LoginPage();
    }

    public boolean verifySignInBtn() {
        return find(signInBtn).getText().contains("Sign in");
    }

    public void storeBannerTest() {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        WebElement bannerOne = wait.until(ExpectedConditions
                .presenceOfElementLocated(defaultStoreBanner));
        Assert.assertTrue(bannerOne.isDisplayed());
    }

    public void wishListTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        click(wishlistButton);
        WebElement modal = find(wishlistModal);
        wait.until(ExpectedConditions.visibilityOf(modal));
        String modalText = modal.getText();
        Assert.assertEquals(modal.getText(), modalText);
    }
}
