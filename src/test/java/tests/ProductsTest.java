package tests;

import pages.LoginPage;
import pages.ProductsPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import constants.Constants;
import utils.Drivers;

/**
 * Test suite for the Products page
 * @author Hudson Pierce
 */
public class ProductsTest {
    WebDriver driver;
    private ProductsPage productsPage;

    /** Sets up driver and products page before each test. */
    @BeforeEach
    public void setup() {
        driver = (new Drivers()).setup();
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

    /** Verifies that an item is added to the cart. */
    @Test
    public void addItemToCart() {
        productsPage.checkBackpackOnPage();
        productsPage.addBackpackToCart();
        productsPage.checkItemsAddedToCart(1);
    }

    /** Verifies that multiple items are added to the cart. */
    @Test
    public void addMultipleItemsToCart() {
        // add backpack
        productsPage.checkBackpackOnPage();
        productsPage.addBackpackToCart();
        productsPage.checkItemsAddedToCart(1);

        // add bike light
        productsPage.checkBikeLightOnPage();
        productsPage.addBikeLightToCart();
        productsPage.checkItemsAddedToCart(2);
    }

    /** Verifies that an item is removed from the cart. */
    @Test
    public void removeItemFromCart() {
        // add backpack
        productsPage.checkBackpackOnPage();
        productsPage.addBackpackToCart();
        productsPage.checkItemsAddedToCart(1);

        // remove backpack
        productsPage.removeBackpackFromCart();
        productsPage.checkItemsAddedToCart(0);
    }

    /** Verifies that multiple items are removed from the cart. */
    @Test
    public void removeMultipleItemsFromCart() {
        // add backpack
        productsPage.checkBackpackOnPage();
        productsPage.addBackpackToCart();
        productsPage.checkItemsAddedToCart(1);

        // add bike light
        productsPage.checkBikeLightOnPage();
        productsPage.addBikeLightToCart();
        productsPage.checkItemsAddedToCart(2);

        // remove backpack
        productsPage.removeBackpackFromCart();
        productsPage.checkItemsAddedToCart(1);

        // remove bike light
        productsPage.removeBikeLightFromCart();
        productsPage.checkItemsAddedToCart(0);
    }
}
