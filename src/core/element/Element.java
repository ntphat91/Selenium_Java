package element;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface Element {
    // RETRIEVE INFO
    WebElement getRawElement();

    List<WebElement> getRawElements();

    String getTagName();

    String getAttribute(String name);

    String getText();

    String getCssValue(String propertyName);

    // ACTIONS
    void click();

    void click(int x, int y);

    void doubleClick();

    void submit();

    void sendKeys(CharSequence... keysToSend);

    void clear();

    void scrollToView();

    void moveTo();

    void focus();
}
