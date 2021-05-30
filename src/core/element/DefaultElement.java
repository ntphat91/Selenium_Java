package element;

import driver.manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DefaultElement implements Element {
    private By byLocator;
    private long timeOut = 60;

    public DefaultElement() {
    }

    public DefaultElement(By byLocator) {
        this.byLocator = byLocator;
    }

    @Override
    public WebElement getRawElement() {
        return DriverManager.get().findElement(byLocator);
    }

    @Override
    public List<WebElement> getRawElements() {
        return DriverManager.get().findElements(byLocator);
    }

    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public String getAttribute(String name) {
        return getRawElement().getAttribute(name);
    }

    @Override
    public String getText() {
        return getRawElement().getText();
    }

    @Override
    public String getCssValue(String propertyName) {
        return null;
    }

    @Override
    public void click() {
        getRawElement().click();
    }

    @Override
    public void click(int x, int y) {

    }

    @Override
    public void doubleClick() {

    }

    @Override
    public void submit() {

    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        getRawElement().sendKeys(keysToSend);
    }

    @Override
    public void clear() {

    }

    @Override
    public void scrollToView() {

    }

    @Override
    public void moveTo() {

    }

    @Override
    public void focus() {

    }

    public void waitForInvisibility() {
        WebDriverWait wait = new WebDriverWait(DriverManager.get(), timeOut);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
    }

    public void waitForVisibility() {
        WebDriverWait wait = new WebDriverWait(DriverManager.get(), timeOut);
        wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
    }
}
