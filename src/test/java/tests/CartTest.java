package tests;

import pages.LoginPage;
import pages.ProductsPage;
import pages.CartPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import constants.Constants;
import utils.Drivers;

/**
 * Test suite for the Cart page
 * @author Hudson Pierce
 */
public class CartTest {
    WebDriver driver;
    private CartPage cartPage;
    private ProductsPage productsPage;

    /** Sets up driver and cart page before each test. */
    @BeforeEach
    public void setup() {
        driver = (new Drivers()).setup();
        cartPage = new CartPage(driver);
        productsPage = new ProductsPage(driver);

        // login to access products page
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);
    }

    /** Closes the driver after each test. */
    @AfterEach
    public void teardown() {
        driver.close();
    }

    /** Verifies that an item exists in the cart, */
    @Test
    public void itemExistsInCart() {
        // add backpack to cart
        productsPage.addBackpackToCart();

        // navigate to cart page
        productsPage.goToCart();

        // verify backpack is in cart
        cartPage.checkBackpackInCart();
    }

    /** Verifies that multiple items exist in the cart. */
    @Test
    public void multipleItemsExistInCart() {
        // add backpack and bike light to cart
        productsPage.addBackpackToCart();
        productsPage.addBikeLightToCart();

        // navigate to cart page
        productsPage.goToCart();

        // verify backpack and bike light are in cart
        cartPage.checkBackpackInCart();
        cartPage.checkBikeLightInCart();
    }

    /** Verifies that all items are removed from cart. */
    @Test
    public void removeAllItemsFromCart() {
        // add backpack and bike light to cart
        productsPage.addBackpackToCart();
        productsPage.addBikeLightToCart();

        // navigate to cart page
        productsPage.goToCart();

        // verify backpack and bike light are in cart
        cartPage.checkBackpackInCart();
        cartPage.checkBikeLightInCart();

        // remove backpack and bike light from cart
        cartPage.removeBackpackFromCart();
        cartPage.removeBikeLightFromCart();

        // verify cart is empty
        cartPage.checkCartIsEmpty();
    }
}
