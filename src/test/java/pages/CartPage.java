package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Sets up Page Objects and actions for the Cart page.
 * @author Hudson Pierce
 */
public class CartPage {
    // Web elements
    @FindBy(css = "#header_container > div.header_secondary_container > span")
    private WebElement cartHeader;

    @FindBy(css = "#item_4_title_link > div")
    private WebElement backpackName;

    @FindBy(css = "#item_0_title_link > div")
    private WebElement bikeLightName;

    @FindBy(css = "#cart_contents_container > div > div.cart_list > div.cart_item > div.cart_item_label > div.item_pricebar > div")
    private WebElement backpackPrice;

    @FindBy(css = "#cart_contents_container > div > div.cart_list > div:nth-child(4) > div.cart_item_label > div.inventory_item_desc")
    private WebElement bikeLightPrice;

    @FindBy(css = "#cart_contents_container > div > div.cart_list > div.cart_item > div.cart_item_label > div.inventory_item_desc")
    private WebElement backpackDescription;

    @FindBy(css = "#cart_contents_container > div > div.cart_list > div:nth-child(4) > div.cart_item_label > div.item_pricebar > div")
    private WebElement bikeLightDescription;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement backpackRemoveFromCart;

    @FindBy(id = "remove-sauce-labs-bike-light")
    private WebElement bikeLightRemoveFromCart;

    @FindBy(id = "cart_item")
    private WebElement cartItem;

    /** Constructor method for setting up CartPage with driver and web elements. */
    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //Actions
    /** Remove backpack from cart. */
    public void removeBackpackFromCart() {
        backpackRemoveFromCart.click();
    }

    /** Remove bike light from cart. */
    public void removeBikeLightFromCart() {
        bikeLightRemoveFromCart.click();
    }

    //Assertions
    /** Checks that the backpack has been added to the cart. */
    public void checkBackpackInCart() {
        assertEquals("Sauce Labs Backpack", backpackName.getText());
        assertEquals("$29.99", backpackPrice.getText());
        assertEquals("carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.", backpackDescription.getText());
    }

    /** Checks that the bike light has been added to the cart. */
    public void checkBikeLightInCart() {
        assertEquals("Sauce Labs Bike Light", bikeLightName.getText());
        assertEquals("$9.99", bikeLightPrice.getText());
        assertEquals("A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.", bikeLightDescription.getText());
    }

    /** Checks that the cart is empty. */
    public void checkCartIsEmpty() {
        assertThrows(NoSuchElementException.class, () -> cartItem.isDisplayed());
    }
}
