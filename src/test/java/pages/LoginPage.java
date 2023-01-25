package pages;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPage {
    private WebDriver driver;
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

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String input) {
        username.sendKeys(input);
    }

    public void enterPassword(String input) {
        password.sendKeys(input);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void validUsernamePassword() {
        // checks if page url is redirected to inventory.html and products header is displayed,
        // if so, this means login is successful
        assertEquals(Constants.URL + "/inventory.html", driver.getCurrentUrl());
        assertEquals("PRODUCTS", productsHeader.getText());
    }

    public void invalidUsernamePassword() {
        assertEquals("Epic sadface: Username and password do not match any user in this service", loginErrorMessage.getText());
    }

    public void emptyUsername() {
        assertEquals("Epic sadface: Username is required", loginErrorMessage.getText());
    }

    public void emptyPassword() {
        assertEquals("Epic sadface: Password is required", loginErrorMessage.getText());
    }
}
