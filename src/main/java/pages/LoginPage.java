package pages;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileReader;
import java.io.IOException;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    By email = By.xpath("/html/body/div[4]/div/div/div/div/div[1]/div[1]/form/div[1]/div/input");
    By password = By.xpath("/html/body/div[4]/div/div/div/div/div[1]/div[1]/form/div[2]/div/input");
    public WebElement getEmailFromCsv() throws CsvValidationException, IOException {
        getCSV();
        WebElement eposta = find(email);
        String[] csvEposta;
        csvEposta = reader.readNext();
        eposta.sendKeys(csvEposta);
        return eposta;
    }
    public void getEmailPasswordFromCsv() throws CsvValidationException, IOException, InterruptedException {
        getCSV();
        WebElement sifre = find(password);
        WebElement eposta = find(email);
        String[] nextRecord;
        String[] csvEposta;
        csvEposta = reader.readNext();
        String csvSifre = null;
        while ((nextRecord = reader.readNext()) != null) {
            for (String cell : nextRecord) {
                csvSifre = cell;
            }
        }
        eposta.sendKeys(csvEposta);
        sifre.sendKeys(csvSifre);
        Thread.sleep(2000);
    }

}
