package constants;

/** 
 * Defines constants to be used across test cases.
 * @author Hudson Pierce
 */
public class Constants {
    /** the base url of the application */
    public static String URL = "https://www.saucedemo.com";
    /** the browser to run tests on */
    public static String BROWSER = "chrome"; // other options "firefox", "edge", "safari"
    /** whether or not to run the browser in headless mode */
    public static boolean HEADLESS = true;
    /** default valid login username */
    public static String VALID_USERNAME = "standard_user";
    /** default valid login password */
    public static String VALID_PASSWORD = "secret_sauce";
}
