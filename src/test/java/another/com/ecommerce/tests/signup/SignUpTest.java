package another.com.ecommerce.tests.signup;

import another.com.ecommerce.base.BaseTest;
import com.ecommerce.pages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SignUpTest extends BaseTest {

    @Test
    public void signUpTest() {
        storePage.clickOnSignOutBtn();
        Assert.assertTrue(storePage.isStoreHeaderDisplayed());

        storePage.clickOnSignInBtn();
        loginPage.clickSignUpLink();

        String fullName = signupPage.fillSignUpInfo();

        Assert.assertTrue(
                signupPage.isProfileNameDisplayed(fullName),
                "Expected profile name to contain: " + fullName
        );
    }
}
