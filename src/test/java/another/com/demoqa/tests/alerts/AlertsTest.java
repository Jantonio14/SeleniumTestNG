package another.com.demoqa.tests.alerts;

import another.com.demoqa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTest extends BaseTest {

    @Test
    public void triggerAndAcceptAlert() {
        homePage.clickOnPopUpPage();
        String alertText = popupAlertPage.acceptAlert();
        Assert.assertTrue(alertText.contains("You have triggered the alert!"));
    }

    @Test
    public void triggerAndClosePopUp() {
        homePage.clickOnPopUpPage();
        int windowCount = popupAlertPage.closePopUp();
        Assert.assertEquals(windowCount, 1);
    }
}
