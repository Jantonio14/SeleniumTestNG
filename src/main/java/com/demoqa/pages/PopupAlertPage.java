package com.demoqa.pages;

import com.ecommerce.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class PopupAlertPage extends BasePage {

    private By alertTrigger = By.cssSelector("[onclick='alertTrigger\\(\\)']");
    private By popUpTrigger = By.cssSelector("[onclick='popup\\(\\)']");

    public String acceptAlert() {
        click(alertTrigger);
        String alertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return alertText;
    }

    public int closePopUp() {
        click(popUpTrigger);
        String mainWindow = driver.getWindowHandle();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(d -> d.getWindowHandles().size() > 1);

        Set<String> handles = driver.getWindowHandles();

        for (String handle : handles) {
            if(!mainWindow.equals(handle)) {
                driver.switchTo().window(handle);
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);
        return driver.getWindowHandles().size();
    }
}
