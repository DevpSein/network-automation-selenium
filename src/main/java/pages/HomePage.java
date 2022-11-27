package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    SearchBox searchBox;
    By acceptCookiesLocator = By.id("onetrust-accept-btn-handler");
    By homePage = By.cssSelector("svg[class=headerCheckout__logo__img]");

    By cartUp = By.xpath("/html/body/div[2]/header/div/div/div[3]/div[2]/button/span");
    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }
    public SearchBox searchBox(){
        return this.searchBox;
    }
    public void clickGoHomePage (){
        WebElement goHomePage= find(homePage);
        goHomePage.click();
    }
    public void acceptCookies() {
        if (isDisplayed(acceptCookiesLocator)) {
            click(acceptCookiesLocator);
        }
    }
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
}
