package driver.browser;

import driver.manager.DefaultBrowserDriver;
import driver.manager.DriverProperty;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxBrowserDriver extends DefaultBrowserDriver {
    @Override
    public void init(DriverProperty driverProperty) {
        System.setProperty("webdriver.gecko.driver", driverProperty.getDriverExecutable());
        FirefoxOptions firefoxOpts = new FirefoxOptions();
        if (driverProperty.getCapabilities() != null)
            firefoxOpts.merge(driverProperty.getCapabilities());
        rawWebDriver = new FirefoxDriver(firefoxOpts);
    }
}
