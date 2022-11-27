package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ProductsPage extends BasePage {
    By dahaFazla = By.xpath("//*[@id=\"pagedListContainer\"]/div[2]/div[2]/button");
    By productList = By.cssSelector("div[class=product__header]");
    By discountedProductList = By.cssSelector("div[class=product__discountPercent]");
    By productSize = By.xpath("//*[@id=\"product-133233\"]/div/div[1]/div/div/div/div[4]/label");//

    By productPrize = By.xpath("//*[@id=\"header__desktopBasket\"]/div/div[2]/div/div[2]/span[1]");

    By cartPrize = By.xpath("//*[@id=\"header__desktopBasket\"]/div/div[3]/div/p");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    //Sonra ki sayfaya ilerleme
    public void goNext() throws InterruptedException {
        WebElement nextPage = find(dahaFazla);
        nextPage.click();
        Thread.sleep(2500);

    }

    //Urun secilmesi
    public void selectProduct() throws InterruptedException {
        WebElement element = find(productSize);//.findElement(productSize).click();
        hover(element);
        Thread.sleep(3500);
        compareTwoItem();


    }



    //Sepetteki ürünün fiyat kiyaslamasi
    public boolean compareTwoItem() {
        WebElement urunFiyat = find(productPrize);
        WebElement sepetFiyat = find(cartPrize);
        boolean count = true;
        if (!urunFiyat.getText().equals(sepetFiyat.getText())) {
            count = false;
        }
        return count;
    }

}
