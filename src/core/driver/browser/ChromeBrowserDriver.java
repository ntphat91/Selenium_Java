package driver.browser;

import driver.manager.DefaultBrowserDriver;
import driver.manager.DriverProperty;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowserDriver extends DefaultBrowserDriver {
    @Override
    public void init(DriverProperty driverProperty) {
        System.setProperty("webdriver.chrome.driver", driverProperty.getDriverExecutable());
        ChromeOptions chromeOpts = new ChromeOptions();
        if (driverProperty.getCapabilities() != null)
            chromeOpts.merge(driverProperty.getCapabilities());
        rawWebDriver = new ChromeDriver(chromeOpts);
    }
}
