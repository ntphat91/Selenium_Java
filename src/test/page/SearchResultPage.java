package page;

import element.DefaultElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage {
    private final DefaultElement trSearchRows = new DefaultElement(By.xpath("//div[@id='forecast_list_ul']/table//tr"));
    private final DefaultElement tbSearchResults = new DefaultElement(By.xpath("//div[@id='forecast_list_ul']/table"));
    private final String dymCityResultName = "(//div[@id='forecast_list_ul']//a[contains(@href, 'city')])[%s]";

    public void waitForSearchResults() {
        tbSearchResults.waitForVisibility();
    }

    public int getSearchResultsRows() {
        trSearchRows.waitForVisibility();
        List<WebElement> searchRows = trSearchRows.getRawElements();
        return searchRows.size();
    }

    public String getResultsCityName(int index) {
        DefaultElement lnkCityName = new DefaultElement(By.xpath(String.format(dymCityResultName, index)));
        lnkCityName.waitForVisibility();
        return lnkCityName.getText();
    }

    public boolean verifyAllResultsDisplaysCorrect(String cityName) {
        boolean checkResult = true;
        trSearchRows.waitForVisibility();
        List<WebElement> searchRows = trSearchRows.getRawElements();
        for (int i = 0; i < searchRows.size(); i++) {
            DefaultElement lnkCityName = new DefaultElement(By.xpath(String.format(dymCityResultName, i + 1)));
            lnkCityName.waitForVisibility();
            if (!lnkCityName.getText().contains(cityName)) {
                checkResult = false;
                break;
            }
        }
        return checkResult;
    }
}
