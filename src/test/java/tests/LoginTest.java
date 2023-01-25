package tests;

import pages.LoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import utils.Drivers;

/**
 * @author Hudson Pierce
 * Test suite for the Login page
 */
public class LoginTest {
    WebDriver driver;
    private LoginPage loginPage;

    private static String VALID_USERNAME = "standard_user";
    private static String VALID_PASSWORD = "secret_sauce";
    private static String INVALID_USERNAME = "invalid_user";
    private static String INVALID_PASSWORD = "invalid_password";

    /** Sets up driver and login page before each test. */
    @BeforeEach
    public void setup() {
        driver = (new Drivers()).setup();
        loginPage = new LoginPage(driver);
    }

    /** Closes the driver after each test. */
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

        loginPage.checkLoginSuccess();
    }

    /** Verifies that inputting invalid username and invalid password displays an error message. */
    @Test
    public void loginInvalidUsernamePassword() {
        loginPage.enterUsername(INVALID_USERNAME);
        loginPage.enterPassword(INVALID_PASSWORD);
        loginPage.clickLogin();

        loginPage.checkLoginFailedInvalidUsernamePassword();
    }

    /** Verifies that leaving username field empty displays an error message. */
    @Test
    public void loginUsernameEmpty() {
        loginPage.enterPassword(VALID_PASSWORD);
        loginPage.clickLogin();
        loginPage.checkLoginFailedEmptyUsername();
    }

    /** Verifies that leaving password field empty displays an error message. */
    @Test
    public void loginPasswordEmpty() {
        loginPage.enterUsername(VALID_USERNAME);
        loginPage.clickLogin();
        loginPage.checkLoginFailedEmptyPassword();
    }
}
