package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchResultPage;

public class WeatherTestCases extends TestBase {
    HomePage homePage = new HomePage();
    SearchResultPage searchResultPage;

    @DataProvider(name = "dpTC01", parallel = true)
    public Object[][] dpTC01() {
        return new Object[][]{
                {"London, GB"},
                {"London, US"},
                {"Ha Noi, VN"}
        };
    }

    @Test(dataProvider = "dpTC01")
    public void TC01(String cityName) {
        // Step 1: Navigate to https://openweathermap.org/
        // Step 2: On the top left corner, click on the weather search box
        // Step 3: Enter some specific city name and country code: London, GB; London, US; Ha Noi, VN… then press Enter on keyboard.
        searchResultPage = homePage.searchWeatherInCity(cityName);

        // Verify Point: There is only one result display with correct city name and country code as input before
        Assert.assertEquals(searchResultPage.getSearchResultsRows(), 1);
        Assert.assertEquals(searchResultPage.getResultsCityName(1), cityName);
    }

    @DataProvider(name = "dpTC02", parallel = true)
    public Object[][] dpTC02() {
        return new Object[][]{
                {"London"},
                {"Ha Noi"},
                {"Sydney"}
        };
    }

    @Test(dataProvider = "dpTC02")
    public void TC02(String cityName) {
        // Step 1: Navigate to https://openweathermap.org/
        // Step 2: On the top left corner, click on the weather search box
        // Step 3: Enter some city name: London; Ha Noi; Sydney… then press Enter on keyboard.
        searchResultPage = homePage.searchWeatherInCity(cityName);

        // Verify Point: The results should be displayed correctly with contain city name as input before
        Assert.assertTrue(searchResultPage.verifyAllResultsDisplaysCorrect(cityName));
    }
}
