package com.ecommerce.pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



public class StorePage extends BasePage {

    private By storeHeader = By.cssSelector("img[alt='Test Store']");
    private By signOutBtn = By.cssSelector(".hidden-sm-down.logout");
    private By signInBtn = By.cssSelector(".user-info .hidden-sm-down");
    private By defaultStoreBanner = By.cssSelector("img[alt='sample-1']");
    private By productItemOne = By.cssSelector(".products.row [data-id-product='1']");
    private By wishlistButton = By.cssSelector(".products.row [data-id-product='1'] [class='wishlist-button-add']");
    private By wishlistModal = By.cssSelector(".show .modal-content");
    private By cancelModalBtn = By.cssSelector(".show .btn-secondary");
    private By storeProductHeader = By.xpath("//h2[contains(text(), 'Popular Products')]");

    public boolean isSignOutButtonDisplayed() {
        return !driver.findElements(signOutBtn).isEmpty();
    }

    public void signOutIfLoggedIn() {
        if (isSignOutButtonDisplayed()) {
            clickOnSignOutBtn();
        }
    }

    public boolean isStoreHeaderDisplayed() {
        return find(storeHeader).isDisplayed();
    }

    public boolean isStoreProductHeaderDisplayed() {
        return find(storeProductHeader).isDisplayed();
    }

    public StorePage clickOnSignOutBtn() {
        click(signOutBtn);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement signIn = find(signInBtn);
        wait.until(ExpectedConditions.visibilityOf(signIn));
        return new StorePage();
    }

    public LoginPage clickOnSignInBtn() {
        click(signInBtn);
        return new LoginPage();
    }

    public boolean verifySignInBtn() {
        return find(signInBtn).getText().contains("Sign in");
    }

    public boolean isStoreBannerDisplayed() {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        WebElement bannerOne = wait.until(ExpectedConditions
                .presenceOfElementLocated(defaultStoreBanner));
        return bannerOne.isDisplayed();
    }

    public String getStoreProductHeaderText() {
        return find(storeProductHeader).getText();
    }

    public String clickWishlistAndGetModalText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        click(wishlistButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(wishlistModal));
        return find(wishlistModal).getText();
    }

    public void closeWishlistModal() {
        click(cancelModalBtn);
    }
}
