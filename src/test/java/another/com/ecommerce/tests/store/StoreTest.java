package another.com.ecommerce.tests.store;

import another.com.ecommerce.base.BaseTest;
import com.ecommerce.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class StoreTest extends BaseTest {


    @Test
    public void verifyStoreHeaderIsDisplayed()  {
        StorePage storePage = loginPage.loginToApp("testing@mail.com", "admin123");
        Assert.assertTrue(storePage.isStoreHeaderDisplayed());
    }

    @Test
    public void verifyDefaultBanner() throws InterruptedException {
        StorePage storePage = loginPage.loginToApp("testing@mail.com", "admin123");
        Thread.sleep(3000);
        storePage.storeBannerTest();
    }

    @Test
    public void addProductToWishList() {
        storePage.isStoreHeaderDisplayed();
        storePage.wishListTest();
    }
}
