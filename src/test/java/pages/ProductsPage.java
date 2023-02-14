package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Sets up Page Objects and actions for the Products Page.
 * @author Hudson Pierce
 */
public class ProductsPage {
    // Web elements
    @FindBy(css = "#header_container > div.header_secondary_container > span")
    private WebElement productsHeader;

    @FindBy(xpath = "//*[@id='header_container']/div[2]/div[2]/span/select")
    private WebElement sortDropdown;

    @FindBy(css = "#item_4_title_link > div")
    private WebElement backpackName;

    @FindBy(css = "#item_0_title_link > div")
    private WebElement bikeLightName;

    @FindBy(css = "#inventory_container > div > div:nth-child(1) > div.inventory_item_description > div.pricebar > div")
    private WebElement backpackPrice;

    @FindBy(css = "#inventory_container > div > div:nth-child(2) > div.inventory_item_description > div.pricebar > div")
    private WebElement bikeLightPrice;

    @FindBy(css = "#inventory_container > div > div:nth-child(1) > div.inventory_item_description > div.inventory_item_label > div")
    private WebElement backpackDescription;

    @FindBy(css = "#inventory_container > div > div:nth-child(2) > div.inventory_item_description > div.inventory_item_label > div")
    private WebElement bikeLightDescription;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement backpackAddToCart;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement backpackRemoveFromCart;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement bikeLightAddToCart;

    @FindBy(id = "remove-sauce-labs-bike-light")
    private WebElement bikeLightRemoveFromCart;

    @FindBy(css = "#shopping_cart_container > a > span")
    private WebElement cartIcon;

    /** Constructor method for setting up ProductsPage with driver and web elements. */
    public ProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //Actions
    /** Add backpack to cart. */
    public void addBackpackToCart() {
        backpackAddToCart.click();
    }

    /** Add bike light to cart. */
    public void addBikeLightToCart() {
        bikeLightAddToCart.click();
    }

    /** Remove backpack from cart. */
    public void removeBackpackFromCart() {
        backpackRemoveFromCart.click();
    }

    /** Remove bike light from cart. */
    public void removeBikeLightFromCart() {
        bikeLightRemoveFromCart.click();
    }

    /** Navigate to Cart Page */
    public void goToCart() {
        cartIcon.click();
    }

    //Assertions
    /** Checks that backpack exists on the page. */
    public void checkBackpackOnPage() {
        assertEquals("Sauce Labs Backpack", backpackName.getText());
        assertEquals("$29.99", backpackPrice.getText());
        assertEquals("carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.", backpackDescription.getText());
    }

    /** Checks that bike light exists on the page. */
    public void checkBikeLightOnPage() {
        assertEquals("Sauce Labs Bike Light", bikeLightName.getText());
        assertEquals("$9.99", bikeLightPrice.getText());
        assertEquals("A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.", bikeLightDescription.getText());
    }

    /** 
    * Checks that the specified number of items are added to the cart. 
    * @param items The number of items added to the cart.
    */
    public void checkItemsAddedToCart(int items) {
        assertEquals(String.valueOf(items), cartIcon.getText());
    }
}
