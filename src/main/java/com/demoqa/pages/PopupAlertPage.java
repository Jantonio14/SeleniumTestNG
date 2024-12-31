package com.demoqa.pages;

import com.ecommerce.pages.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class PopupAlertPage extends BasePage {

    private By alertTrigger = By.cssSelector("[onclick='alertTrigger\\(\\)']");
    private By popUpTrigger = By.cssSelector("[onclick='popup\\(\\)']");

    public void acceptAlert() {
        click(alertTrigger);
        String alertText = driver.switchTo().alert().getText();
        Assert.assertTrue(alertText.contains("You have triggered the alert!"));
        driver.switchTo().alert().accept();
    }

    public void closePopUp() throws InterruptedException {
        click(popUpTrigger);
        String mainWindow = driver.getWindowHandle();

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterate = handles.iterator();

        while(iterate.hasNext()) {
            String child = iterate.next();

            if(!mainWindow.equalsIgnoreCase(child)) {
                Thread.sleep(3000);
                driver.switchTo().window(child);
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);
        Assert.assertEquals(driver.getWindowHandles().size(), 1);
    }
}
