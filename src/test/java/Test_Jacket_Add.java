import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import pages.*;

import java.io.IOException;

public class Test_Jacket_Add extends BaseTest {
    HomePage homePage;
    ProductsPage productsPage;
    SearchBox searchBox;
    CartPage cartPage;

    @Test
    @Order(1)
    //Urun arama
    public void searchProduct() {
        homePage = new HomePage(webDriver);
        searchBox = new SearchBox(webDriver);
        String url = homePage.getCurrentUrl();
        Assertions.assertEquals(url, "https://www.network.com.tr/",
                "Wrong URL");
        homePage.acceptCookies();
        searchBox.search("ceket" + "\n");
    }

    //Scroll
    @Test
    @Order(2)
    public void scrollDown() throws InterruptedException {
        searchBox.scroll();
    }

    //Daha fazla göster butonu
    @Test
    @Order(3)
    public void goNextPage() throws InterruptedException {
        productsPage = new ProductsPage(webDriver);
        productsPage.goNext();
        String url = homePage.getCurrentUrl();
        Assertions.assertEquals(url, "https://www.network.com.tr/search?searchKey=ceket&page=2",
                "Wrong Url");

    }

    //Sepete ekle
    @Test
    @Order(4)
    public void addToChart() throws InterruptedException {
        productsPage = new ProductsPage(webDriver);
        productsPage.selectProduct();
    }

    // Sepete Git
    @Test
    @Order(5)
    public void goCart() throws InterruptedException {
        cartPage = new CartPage(webDriver);
        cartPage.goToCart();
    }

    //Sepet Devam Et
    @Test
    @Order(6)
    public void continueCart() throws InterruptedException {
        cartPage.continueCart();
    }

    //Csv uzantılı dosyadan verileri çekme
    @Test
    @Order(7)
    public void EmailFromCsv() throws CsvValidationException, IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.getEmailPasswordFromCsv();
    }

    // Anasayfaya geri dönme
    @Test
    @Order(8)
    public void homePage() {
        homePage.clickGoHomePage();
    }
    /*@Test //Sepet buton referans path'ine ulaşamadığım için çalıştıramadım
    @Order(9)
    public void removeCart() throws InterruptedException {
        cartPage.removeItemFromCart();
    }*/
}
