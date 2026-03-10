package another.com.demoqa.tests.dropdown;

import another.com.demoqa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTest extends BaseTest {

    @Test
    public void selectDropDownItemTest() {
        homePage.clickOnDropDownPage();
        String selectedOption = dropDownPage.selectDropDownItem("Jeep");
        Assert.assertEquals(selectedOption, "Jeep");
    }

    @Test
    public void iterateRadioButtons() throws InterruptedException {
        homePage.clickOnDropDownPage();
        dropDownPage.iterateRadioButtonsTest();
    }
}
