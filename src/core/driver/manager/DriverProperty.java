package driver.manager;

import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverProperty {
    private String remoteUrl;
    private String driverExecutable;
    private DesiredCapabilities capabilities;

    public String getBrowserType() {
        return browserType;
    }

    public void setBrowserType(String browserType) {
        this.browserType = browserType;
    }

    private String browserType;

    public DesiredCapabilities getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(DesiredCapabilities capabilities) {
        this.capabilities = capabilities;
    }

    public String getDriverExecutable() {
        return driverExecutable;
    }

    public void setDriverExecutable(String driverExecutable) {
        this.driverExecutable = driverExecutable;
    }

    public String getRemoteUrl() {
        return remoteUrl;
    }

    public void setRemoteUrl(String remoteUrl) {
        this.remoteUrl = remoteUrl;
    }
}
