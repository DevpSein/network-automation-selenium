package pages;

import org.openqa.selenium.*;

import javax.xml.namespace.QName;

public class SearchBox extends BasePage {
    By searchBoxFinder = By.id("search");
    JavascriptExecutor js = (JavascriptExecutor) driver;


    public SearchBox(WebDriver driver) {
        super(driver);
    }

    public void search(String text) {
        WebElement searchSpace = driver.findElement(searchBoxFinder);
        searchSpace.click();
        searchSpace.sendKeys(text);
    }

    public void scroll() {
        js.executeScript("window.scroll(0,17500)");

    }


}
