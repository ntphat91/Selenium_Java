package page;

import element.DefaultElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class HomePage {
    private final DefaultElement btnAllowAllCookies = new DefaultElement(By.xpath("//button[@class='stick-footer-panel__link']"));
    private final DefaultElement divLoadingIcon = new DefaultElement(By.xpath("//div[@aria-label='Loading']"));
    private final DefaultElement txtSearch = new DefaultElement(By.xpath("//div[@id='desktop-menu']//form[@role='search']//input[@type='text']"));

    public void allowAllCookies() {
        waitForLoadingCompleted();
        btnAllowAllCookies.click();
    }

    public void waitForLoadingCompleted() {
        divLoadingIcon.waitForInvisibility();
    }

    public SearchResultPage searchWeatherInCity(String city) {
        txtSearch.sendKeys(city);
        txtSearch.sendKeys(Keys.ENTER);
        SearchResultPage searchResultPage = new SearchResultPage();
        searchResultPage.waitForSearchResults();
        return searchResultPage;
    }
}
