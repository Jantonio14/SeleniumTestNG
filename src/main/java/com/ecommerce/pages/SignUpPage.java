package com.ecommerce.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

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


    public void fillSignUpInfo() {
        Faker faker = new Faker();
        String name = faker.name().firstName();
        String lastName = faker.name().lastName();
        String fullName = name + " " + lastName;

        find(socialTitleMr).click();
        set(firstNameField, name);
        set(lastNameField, lastName);
        set(email, faker.internet().emailAddress());
        set(password, faker.internet().password());
        createAccount();

        List<WebElement> items = findAll(accountProfile);
        boolean found = false;
        for (WebElement el : items) {
            if (el.getText().contains(fullName)) {
                Assert.assertTrue(el.getText().contains(fullName),
                        "Expected profile to show: " + fullName);
                found = true;
                break;
            }
        }
        Assert.assertTrue(found, "Full name not found in account profile");
    }

    public void createAccount() {
        find(policyCheck).click();
        find(saveBtn).click();
    }

}
