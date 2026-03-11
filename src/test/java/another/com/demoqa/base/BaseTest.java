package another.com.demoqa.base;

import com.demoqa.pages.*;
import com.ecommerce.pages.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    private WebDriver driver;
    protected BasePage basePage;
    protected HomePage homePage;
    protected ContactFormPage contactFormPage;
    protected DropDownPage dropDownPage;
    protected SubmitFormsPage submitFormsPage;
    protected PopupAlertPage popupAlertPage;
    protected FilePage filePage;
    private String demoQA_Url = "https://automationtesting.co.uk/index.html";

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        if (System.getenv("CI") != null) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
        }
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void loadApplication() {
        driver.get(demoQA_Url);
        basePage = new BasePage();
        basePage.setDriver(driver);
        homePage = new HomePage();
        contactFormPage = new ContactFormPage();
        dropDownPage = new DropDownPage();
        submitFormsPage = new SubmitFormsPage();
        popupAlertPage = new PopupAlertPage();
        filePage = new FilePage();
        homePage.dismissCookieBanner();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
