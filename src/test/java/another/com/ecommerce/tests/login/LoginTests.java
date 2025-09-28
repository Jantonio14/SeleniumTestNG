package another.com.ecommerce.tests.login;

import another.com.ecommerce.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void testLoginErrorMessage() throws InterruptedException {
        storePage.clickOnSignOutBtn();
        storePage.isStoreHeaderDisplayed();
        storePage.clickOnSignInBtn();
        loginPage.setUsername("testing@mail.com");
        loginPage.setPassword("admin1244"); // real pw: admin123
        loginPage.clickLoginButton();
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertTrue(actualMessage.contains("Authentication failed"));
    }

    @Test
    public void testShowPassword() {
        storePage.clickOnSignOutBtn();
        storePage.isStoreHeaderDisplayed();
        storePage.clickOnSignInBtn();
        loginPage.showPassword();
        loginPage.verifyVisiblePassword();

    }

    @Test
    public void successfulLogin() {
        storePage.clickOnSignOutBtn();
        storePage.isStoreHeaderDisplayed();
        storePage.clickOnSignInBtn();
        loginPage.setUsername("testing@mail.com");
        loginPage.setPassword("admin123"); // real pw: admin123
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
