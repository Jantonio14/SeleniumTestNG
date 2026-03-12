package another.com.ecommerce.base;

import com.ecommerce.pages.BasePage;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.SignUpPage;
import com.ecommerce.pages.StorePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected BasePage basePage;
    protected LoginPage loginPage;
    protected StorePage storePage;
    protected SignUpPage signupPage;
    private final String url = "https://teststore.automationtesting.co.uk/index.php?controller=authentication?back=https%3A%2F%2Fteststore.automationtesting.co.uk%2Findex.php";

    protected String testUser;
    protected String testPass;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();

        boolean isCi = System.getenv("CI") != null;

        ChromeOptions options = new ChromeOptions();

        if (isCi) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
        } else {
            options.addArguments("--start-maximized");
        }

        driver = new ChromeDriver(options);

        if (isCi) {
            driver.manage().window().setSize(new Dimension(1920, 1080));
        } else {
            driver.manage().window().maximize();
        }

        driver.get(url);

        basePage = new BasePage();
        basePage.setDriver(driver);

        loginPage = new LoginPage();
        loginPage.setDriver(driver);

        storePage = new StorePage();
        storePage.setDriver(driver);

        signupPage = new SignUpPage();
        signupPage.setDriver(driver);

        testUser = System.getenv().getOrDefault("TEST_USER", "cc.testing.jacil@gmail.com");
        testPass = System.getenv().getOrDefault("TEST_PASS", "!ghfyrh653@#$");

        if (testUser.isBlank() || testPass.isBlank()) {
            throw new IllegalStateException("Missing TEST_USER / TEST_PASS environment variables.");
        }

        loginPage.loginToApp(testUser, testPass);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
