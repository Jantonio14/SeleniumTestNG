package com.demoqa.pages;

import com.ecommerce.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactFormPage extends BasePage {
    private By firstNameField = By.cssSelector("[name=\"first_name\"]");
    private By lastNameField = By.cssSelector("[name=\"last_name\"]");
    private By emailField = By.cssSelector("[name=\"email\"]");
    private By commentField = By.cssSelector("[name=\"message\"]");
    private By resetFieldsBtn = By.cssSelector("[type='reset']");
    private By submitBtn = By.cssSelector("[type='submit']");

    public void setFirstNameField(String firstName) {
        set(firstNameField, firstName);
    }

    public void setLastNameField(String lastName) {
        set(lastNameField, lastName);
    }

    public void setEmailField(String email) {
        set(emailField, email);
    }

    public void setCommentField(String comment) {
        set(commentField, comment);
    }

    public void fillAllFields(String firstName, String lastName, String email, String comment) {
        set(firstNameField, firstName);
        set(lastNameField, lastName);
        set(emailField, email);
        set(commentField, comment);
    }

    public void resetAllFields() {
        click(resetFieldsBtn);
    }

    public boolean verifyEmptyFields() {
        List<By> textFieldLocators = List.of(
                firstNameField,
                lastNameField,
                emailField,
                commentField
        );
        for (By locator : textFieldLocators) {
            WebElement textField = find(locator);
            if (!textField.getAttribute("value").isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public SubmitFormsPage clickSubmitBtn() {
        click(submitBtn);
        return new SubmitFormsPage();
    }

}
