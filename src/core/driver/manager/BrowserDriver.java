package driver.manager;

import org.openqa.selenium.WebDriver;

public interface BrowserDriver extends WebDriver {
    void init(DriverProperty driverProperty);

}
