package another.com.ecommerce.tests.login;

import another.com.ecommerce.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void testLoginErrorMessage() throws InterruptedException {
        storePage.signOutIfLoggedIn();
        storePage.isStoreHeaderDisplayed();
        storePage.clickOnSignInBtn();
        loginPage.setUsername(testUser);
        loginPage.setPassword(testPass + "Wrong");
        loginPage.clickLoginButton();
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertTrue(actualMessage.contains("Authentication failed"));
    }

    @Test
    public void testShowPassword() {
        storePage.signOutIfLoggedIn();
        storePage.isStoreHeaderDisplayed();
        storePage.clickOnSignInBtn();

        loginPage.showPassword();

        String actualText = loginPage.getVisiblePasswordButtonText();
        Assert.assertEquals(actualText, "HIDE");
    }

    @Test
    public void successfulLogin() {
        storePage.signOutIfLoggedIn();
        storePage.isStoreHeaderDisplayed();
        storePage.clickOnSignInBtn();
        loginPage.setUsername(testUser);
        loginPage.setPassword(testPass); // real pw: admin123
        loginPage.clickLoginButton();
        storePage.isStoreHeaderDisplayed();
    }

    @Test
    public void logoutTest() throws InterruptedException {
        storePage.isStoreHeaderDisplayed();
        storePage.clickOnSignOutBtn();
        Thread.sleep(3000);
        storePage.verifySignInBtn();
    }
}
