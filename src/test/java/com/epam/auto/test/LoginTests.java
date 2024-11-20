
import com.epam.pages.HomePage;
import com.epam.pages.LoginPage;
import com.epam.utils.WebDriverManagerUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoginTests {
    private WebDriver driver;
    private Properties config;
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeClass
    public void setUp() throws IOException {
        driver = WebDriverManagerUtil.getDriver();
        config = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new IOException("Unable to find config.properties");
            }
            config.load(input);
        }

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Test
    public void testValidLogin()  {
        driver.get(config.getProperty("base.url"));
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        Assert.assertTrue(homePage.isInventoryDisplayed(), "Inventory page is not displayed!");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
