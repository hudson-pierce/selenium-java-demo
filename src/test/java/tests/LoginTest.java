package tests;

import pages.LoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import utils.Drivers;
import constants.Constants;

/**
 * Test suite for the Login page
 * @author Hudson Pierce
 */
public class LoginTest {
    WebDriver driver;
    private LoginPage loginPage;

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
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);
        loginPage.checkLoginSuccess();
    }

    /** Verifies that inputting invalid username and invalid password displays an error message. */
    @Test
    public void loginInvalidUsernamePassword() {
        loginPage.login(INVALID_USERNAME, INVALID_PASSWORD);
        loginPage.checkLoginFailedInvalidUsernamePassword();
    }

    /** Verifies that leaving username field empty displays an error message. */
    @Test
    public void loginUsernameEmpty() {
        loginPage.login("", Constants.VALID_PASSWORD);
        loginPage.checkLoginFailedEmptyUsername();
    }

    /** Verifies that leaving password field empty displays an error message. */
    @Test
    public void loginPasswordEmpty() {
        loginPage.login(Constants.VALID_USERNAME, "");
        loginPage.checkLoginFailedEmptyPassword();
    }
}
