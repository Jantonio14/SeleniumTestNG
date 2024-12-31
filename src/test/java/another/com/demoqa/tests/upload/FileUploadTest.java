package another.com.demoqa.tests.upload;

import another.com.demoqa.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class FileUploadTest extends BaseTest {

    @Test
    public void fileUploadOne() throws IOException {
        homePage.clickOnFilePage();
        filePage.uploadFile();
    }
}
