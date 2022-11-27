package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }
    By cartOpen = By.xpath("/html/body/div[3]/header/div/div/div[3]/div[3]/a/span");
    By continueButton = By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[2]/div/div[2]/button");
    By removeItem = By.xpath("/html/body/div[2]/header/div/div/div[3]/div[2]/div/div/div[2]/div/div[3]/svg/use");
    public void goToCart() throws InterruptedException {
        driver.get("https://www.network.com.tr/cart");
        Thread.sleep(1500);
    }
    public void continueCart() throws InterruptedException {
        WebElement devamEt = find(continueButton);
        JSExcecuter(devamEt);
        Thread.sleep(1500);
    }
    public void removeItemFromCart() throws InterruptedException {
        WebElement removeButton = find(removeItem);
        WebElement cartButton = find(cartOpen);
        JSExcecuter(cartButton);
        Thread.sleep(2000);
        JSExcecuter(removeButton);
    }
}
