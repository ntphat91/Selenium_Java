package tests;

import driver.manager.DriverManager;
import driver.manager.DriverProperty;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import page.HomePage;

public class TestBase {
    HomePage homePage = new HomePage();

    @Parameters({"browser"})
    @BeforeMethod()
    public void beforeMethod(String browser) {

        DriverProperty property = new DriverProperty();
        switch (browser.toLowerCase()) {
            case "chrome":
                property.setBrowserType("chrome");
                property.setDriverExecutable(System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");
                break;
            case "firefox":
                property.setBrowserType("firefox");
                property.setDriverExecutable(System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\geckodriver.exe");
                break;
            default:
                throw new Error("Unexpected value: " + browser);
        }
        DriverManager.create(property);
        DriverManager.get().manage().window().maximize();
        DriverManager.get().get("https://openweathermap.org/");
        homePage.allowAllCookies();
    }

    @AfterMethod()
    public void afterMethod() {
        DriverManager.get().quit();
    }
}
