package com.demoqa.pages;

import com.ecommerce.pages.BasePage;
import org.openqa.selenium.By;

public class SubmitFormsPage extends BasePage {

    private By successMessage = By.xpath("//div[@id='main']/div[@class='inner']//h3[.='Thank you for your mail!']");
    private By invalidFields = By.cssSelector("body");


    public boolean verifySuccessMessage() {
        return find(successMessage).isDisplayed();
    }

    public boolean verifyFailureMessage() {
        return find(invalidFields).getText().contains(" Error: all fields are required");
    }
}
