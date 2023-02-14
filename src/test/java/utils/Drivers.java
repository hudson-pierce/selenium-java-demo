package utils;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

/** @author Hudson Pierce
 * Utility class for setting up WebDrivers
 */
public class Drivers {
    /**
     * Sets up the WebDriver instance based on the specified browser
     * @return WebDriver the WebDriver instance
     * @throws WebDriverException if an invalid browser is specified
     */
    public WebDriver setup() {
        WebDriver driver;

        if (Constants.BROWSER.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            if (Constants.HEADLESS) {
                options.addArguments("--headless");
            }
            driver = new ChromeDriver(options);
        }
        else if (Constants.BROWSER.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            if (Constants.HEADLESS) {
                options.addArguments("--headless");
            }
            driver = new FirefoxDriver(options);
        }
        else if (Constants.BROWSER.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            if (Constants.HEADLESS) {
                options.addArguments("--headless");
            }
            driver = new EdgeDriver(options);
        }
        else if (Constants.BROWSER.equalsIgnoreCase("safari")) {
            // note: headless mode is not currently supported in Safari
            driver = new SafariDriver();
        }
        else {
            throw new WebDriverException("Invalid browser was specified.");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Constants.URL);

        return driver;
    }
}
