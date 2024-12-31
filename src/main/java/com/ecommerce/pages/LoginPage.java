package com.ecommerce.pages;

import org.openqa.selenium.By;


public class LoginPage extends BasePage {

    private By usernameInput = By.id("field-email");
    private By passwordInput = By.id("field-password");
    private By submitButton = By.id("submit-login");
    private By errorMessage = By.cssSelector(".alert-danger");

    public void setUsername(String username) {
        set(usernameInput, username);
    }

    public void setPassword(String password) {
        set(passwordInput, password);
    }

    // Transition method
    public StorePage clickLoginButton() {
        click(submitButton);
        return new StorePage();
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