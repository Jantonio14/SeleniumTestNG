package another.com.ecommerce.tests.signup;

import another.com.ecommerce.base.BaseTest;
import com.ecommerce.pages.SignUpPage;
import org.testng.annotations.Test;


public class SignUpTest extends BaseTest {

    @Test
    public void signUpTest() {
        storePage.clickOnSignOutBtn();
        storePage.isStoreHeaderDisplayed();
        storePage.clickOnSignInBtn();
        loginPage.clickSignUpLink();
        signupPage.fillSignUpInfo();
    }
}
