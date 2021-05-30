package driver.factory;

import driver.browser.ChromeBrowserDriver;
import driver.browser.FirefoxBrowserDriver;
import driver.manager.BrowserDriver;
import driver.manager.DriverProperty;

public class DriverFactory {
    public static BrowserDriver create(DriverProperty driverProperty) {
        BrowserDriver driver;

        switch (driverProperty.getBrowserType().toLowerCase()) {
            case "chrome":
                driver = new ChromeBrowserDriver();
                break;
            case "firefox":
                driver = new FirefoxBrowserDriver();
                break;
            default:
                throw new Error("Unexpected value: " + driverProperty.getBrowserType());
        }

        driver.init(driverProperty);
        return driver;
    }
}
