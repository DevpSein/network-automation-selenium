package pages;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class BasePage {

    WebDriver driver;

    CSVReader reader;


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public void JSExcecuter(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);

    }

    public List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    public void click(By locator) {
        find(locator).click();
    }

    public void type(By locator, String text) {
        find(locator).sendKeys(text);
    }

    public void hover(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).click().perform();
    }

    public Boolean isDisplayed(By locator) {
        return find(locator).isDisplayed();
    }

    public void getCSV() throws IOException {
        FileReader fileReader = new FileReader("requirements/network.csv");
        reader = new CSVReader(fileReader);
    }

}
