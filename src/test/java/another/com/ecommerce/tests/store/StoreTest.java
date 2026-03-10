package another.com.ecommerce.tests.store;

import another.com.ecommerce.base.BaseTest;
import com.ecommerce.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class StoreTest extends BaseTest {


    @Test
    public void verifyStoreHeaderIsDisplayed()  {
        Assert.assertTrue(storePage.isStoreHeaderDisplayed());
    }

    @Test
    public void verifyDefaultBanner() {
        Assert.assertTrue(storePage.isStoreBannerDisplayed());
    }

    @Test
    public void addProductToWishList() {
        Assert.assertTrue(storePage.isStoreProductHeaderDisplayed());
        String modalText = storePage.clickWishlistAndGetModalText();
        Assert.assertTrue(modalText.toLowerCase().contains("wishlist"));
    }

    @Test
    public void testRelativeXpath() {
        String headerText = storePage.getStoreProductHeaderText();
        Assert.assertEquals(headerText, "POPULAR PRODUCTS");
    }
}
