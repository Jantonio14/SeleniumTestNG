package another.com.demoqa.tests.alerts;

import another.com.demoqa.base.BaseTest;
import org.testng.annotations.Test;

public class AlertsTest extends BaseTest {

    @Test
    public void triggerAndAcceptAlert() {
        homePage.clickOnPopUpPage();
        popupAlertPage.acceptAlert();
    }

    @Test
    public void triggerAndClosePopUp() throws InterruptedException {
        homePage.clickOnPopUpPage();
        popupAlertPage.closePopUp();
    }
}
