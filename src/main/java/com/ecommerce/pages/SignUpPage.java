package com.ecommerce.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SignUpPage extends BasePage {

    private By socialTitleMr = By.id("field-id_gender-1");
    private By socialTitleMrs = By.id("field-id_gender-2");
    private By firstNameField = By.id("field-firstname");
    private By lastNameField = By.id("field-lastname");
    private By email = By.id("field-email");
    private By password = By.id("field-password");
    private By accountProfile = By.xpath("//div[@class='hidden-sm-down']");
    private By policyCheck = By.cssSelector("[name=\"psgdpr\"]");
    private By saveBtn = By.cssSelector("[data-link-action=\"save-customer\"]");


    public String fillSignUpInfo() {
        Faker faker = new Faker();
        String name = faker.name().firstName();
        String lastName = faker.name().lastName();
        String fullName = name + " " + lastName;

        click(socialTitleMr);
        set(firstNameField, name);
        set(lastNameField, lastName);
        set(email, faker.internet().emailAddress());
        set(password, faker.internet().password());

        createAccount();

        return fullName;
    }

    public void createAccount() {
        find(policyCheck).click();
        find(saveBtn).click();
    }

    public boolean isProfileNameDisplayed(String fullName) {

        List<WebElement> items = findAll(accountProfile);

        for (WebElement el : items) {
            if (el.getText().contains(fullName)) {
                return true;
            }
        }
        return false;
    }

}
