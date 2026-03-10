package com.demoqa.pages;

import com.ecommerce.pages.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage extends BasePage {

    private By contactFormsNavBtn = By.linkText("CONTACT US FORM TEST");
    private By popUpAlertNavBtn = By.linkText("POP UPS & ALERTS");
    private By loaderNavBtn = By.linkText("LOADER");
    private By fileUploadNavBtn = By.linkText("FILE UPLOAD");
    private By tablesNavBtn = By.linkText("TABLES");
    private By dropdownNavBtn = By.linkText("DROPDOWN CHECKBOX RADIO");
    private By cookieBanner = By.cssSelector("[class=\"close-cookie-warning\"]");


    public void dismissCookieBanner() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement cookieBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(cookieBanner)
            );
            cookieBtn.click();
        } catch (TimeoutException | NoSuchElementException | ElementNotInteractableException e) {
            // banner not present or interactable, continue
        }
    }


    public ContactFormPage clickOnContactForms() {
        click(contactFormsNavBtn);
        return new ContactFormPage();
    }

    public PopupAlertPage clickOnPopUpPage() {
        click(popUpAlertNavBtn);
        return new PopupAlertPage();
    }

    public LoaderPage clickOnLoaderPage() {
        click(loaderNavBtn);
        return new LoaderPage();
    }

    public FilePage clickOnFilePage() {
        click(fileUploadNavBtn);
        return new FilePage();
    }

    public TablesPage clickOnTablesPage() {
        click(tablesNavBtn);
        return new TablesPage();
    }

    public DropDownPage clickOnDropDownPage() {
        click(dropdownNavBtn);
        return new DropDownPage();
    }

}
