package tests;

import constants.Constants;
import pages.LoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver driver;
    private LoginPage loginPage;

    private static String VALID_USERNAME = "standard_user";
    private static String VALID_PASSWORD = "secret_sauce";
    private static String INVALID_USERNAME = "invalid_user";
    private static String INVALID_PASSWORD = "invalid_password";

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Constants.URL);

        loginPage = new LoginPage(driver);
    }

    @AfterEach
    public void teardown() {
        driver.close();
    }

    /** Verifies that inputting valid username and password logs user in. */
    @Test
    public void loginValidUsernamePassword() {
        loginPage.enterUsername(VALID_USERNAME);
        loginPage.enterPassword(VALID_PASSWORD);
        loginPage.clickLogin();

        loginPage.validUsernamePassword();
    }

    /** Verifies that inputting invalid username and invalid password displays an error message. */
    @Test
    public void loginInvalidUsernamePassword() {
        loginPage.enterUsername(INVALID_USERNAME);
        loginPage.enterPassword(INVALID_PASSWORD);
        loginPage.clickLogin();

        loginPage.invalidUsernamePassword();
    }

    /** Verifies that leaving username field empty displays an error message. */
    @Test
    public void loginUsernameEmpty() {
        loginPage.enterPassword(VALID_PASSWORD);
        loginPage.clickLogin();
        loginPage.emptyUsername();
    }

    /** Verifies that leaving password field empty displays an error message. */
    @Test
    public void loginPasswordEmpty() {
        loginPage.enterUsername(VALID_USERNAME);
        loginPage.clickLogin();
        loginPage.emptyPassword();
    }
}
