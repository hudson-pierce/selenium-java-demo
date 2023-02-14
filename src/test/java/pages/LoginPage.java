package pages;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** 
 * Sets up Page Objects and actions for the Login Page.
 * @author Hudson Pierce
 */
public class LoginPage {
    private WebDriver driver;

    // Web Elements
    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = "#login_button_container > div > form > div.error-message-container.error > h3")
    private WebElement loginErrorMessage;

    @FindBy(css = "#header_container > div.header_secondary_container > span")
    private WebElement productsHeader;

    /** Constructor method for setting up LoginPage with driver and web elements*/
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions
    /** Enters username into username field. */
    public void enterUsername(String input) {
        username.sendKeys(input);
    }

    /** Enters password into password field. */
    public void enterPassword(String input) {
        password.sendKeys(input);
    }

    /** Clicks login button. */
    public void clickLogin() {
        loginButton.click();
    }

    // Helper Methods
    /** Helper method for logging into the application. */
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    // Assertions
    /** Checks that the login was successful. */
    public void checkLoginSuccess() {
        // checks if page url is redirected to inventory.html and products header is displayed,
        // if so, this means login is successful
        assertEquals(Constants.URL + "/inventory.html", driver.getCurrentUrl());
        assertEquals("PRODUCTS", productsHeader.getText());
    }

    /** Checks that the login failed due to an invalid username and password. */
    public void checkLoginFailedInvalidUsernamePassword() {
        assertEquals("Epic sadface: Username and password do not match any user in this service", loginErrorMessage.getText());
    }

    /** Checks that the login failed due to an empty username. */
    public void checkLoginFailedEmptyUsername() {
        assertEquals("Epic sadface: Username is required", loginErrorMessage.getText());
    }

    /** Checks that the login failed due to an empty password. */
    public void checkLoginFailedEmptyPassword() {
        assertEquals("Epic sadface: Password is required", loginErrorMessage.getText());
    }
}
