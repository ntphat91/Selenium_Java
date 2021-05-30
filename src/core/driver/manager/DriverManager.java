package driver.manager;

import driver.factory.DriverFactory;

import java.util.HashMap;

public class DriverManager {
    private static final ThreadLocal<HashMap<String, BrowserDriver>> driverBank = new ThreadLocal<>();
    private static String defaultName = "default";

    public static BrowserDriver get(String driverName) {
        if (isNameExisted(driverName)) {
            return driverBank.get().get(driverName);
        }
        return null;
    }

    public static BrowserDriver get() {
        return get(defaultName);
    }

    public static BrowserDriver create(String driverName, DriverProperty driverProperty) {
        checkAndInitBank();
        BrowserDriver driver = DriverFactory.create(driverProperty);
        driverBank.get().put(driverName, driver);
        return driver;
    }

    public static BrowserDriver create(DriverProperty driverProperty) {
        String driverName = defaultName;
        if (isNameExisted(driverName)) {
            driverName = defaultName + "-" + driverBank.get().size();
            defaultName = driverName;
        }
        return create(driverName, driverProperty);
    }

    private static boolean isNameExisted(String driverName) {
        if (driverBank.get() == null || driverBank.get().size() < 1) {
            return false;
        }
        return driverBank.get().containsKey(driverName);
    }

    private static void checkAndInitBank() {
        if (driverBank.get() == null) {
            driverBank.set(new HashMap<>());
        }
    }
}
