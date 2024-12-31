package com.demoqa.pages;

import com.ecommerce.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class DropDownPage extends BasePage {

    private By carsDropDown = By.name("cars");
    private By firstRadioBtn = By.cssSelector("[for='demo-priority-low']");
    private By secondRadioBtn = By.cssSelector("[for='demo-priority-normal']");
    private By thirdRadioBtn = By.cssSelector("[for='demo-priority-high']");

    public void selectDropDownItem() {
        Select select = new Select(find(carsDropDown));
        String optionLabel = "Jeep";
        select.selectByVisibleText(optionLabel);
        Assert.assertTrue(select.getFirstSelectedOption().getText().equals(optionLabel));
    }

    public void iterateRadioButtonsTest() throws InterruptedException {
        List<By> radioButtons = new ArrayList<>();
        radioButtons.add(firstRadioBtn);
        radioButtons.add(secondRadioBtn);
        radioButtons.add(thirdRadioBtn);

        for (By radioButton : radioButtons) {
            Thread.sleep(3000);
            WebElement button = find(radioButton);
            button.click();
        }
    }
}
