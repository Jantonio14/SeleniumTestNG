package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class LoginPage extends BasePage {

    private By usernameInput = By.id("field-email");
    private By passwordInput = By.id("field-password");
    private By submitButton = By.id("submit-login");
    private By errorMessage = By.cssSelector(".alert-danger");
    private By showPassBtn = By.cssSelector("[data-action=\"show-password\"]");
    private By signUpLink = By.cssSelector("[data-link-action=\"display-register-form\"]");

    public void setUsername(String username) {
        set(usernameInput, username);
    }

    public void setPassword(String password) {
        set(passwordInput, password);
    }

    public void showPassword() {
        setPassword("Test");
        find(showPassBtn);
        click(showPassBtn);
    }

    public String getVisiblePasswordButtonText() {
        WebElement element = find(showPassBtn);
        return element.getText();
    }

    public void verifyVisiblePassword() {
        WebElement element = find(showPassBtn);
        String actualText = element.getText();
        //Assert.assertEquals(actualText, "HIDE");
    }

    // Transition method
    public StorePage clickLoginButton() {
        click(submitButton);
        return new StorePage();
    }

    // Transition method
    public SignUpPage clickSignUpLink() {
        click(signUpLink);
        return new SignUpPage();
    }

    public String getErrorMessage() {
        return find(errorMessage).getText();
    }

    public StorePage loginToApp(String username, String password) {
        setUsername(username);
        setPassword(password);
        return clickLoginButton();
    }
}