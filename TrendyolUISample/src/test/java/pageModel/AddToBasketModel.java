package pageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AddToBasketModel extends BaseModel {

    By txtBrand=By.xpath("//input[@class='fltr-srch-inpt' and @placeholder='Marka ara']");
    By txtSearch=By.className("search-box");
    By txtMinAmount=By.xpath("//*[@class='fltr-srch-prc-rng-input min' and @placeholder='En Az']");
    By txtMaxAmount=By.xpath("//*[@class='fltr-srch-prc-rng-input max' and @placeholder='En Çok']");
    By btnAmountSearch=By.className("fltr-srch-prc-rng-srch");
    By btnAddBasket=By.className("add-to-basket");
    By cbBrand=By.xpath("//*[@id='sticky']/div/div[3]/div[2]/a/div[1]");
    By btnLaptop=By.xpath("//div[@class='image-overlay-body']");

    public AddToBasketModel(WebDriver webDriver) {
        super(webDriver);
    }
    public void setProduct(String product) throws InterruptedException {
        setWait(2000);
        clickElement(txtSearch);
        sendKeys(txtSearch,product);
        findElement(txtSearch).sendKeys(Keys.ENTER);
    }
    public void setBrand(String brand) throws InterruptedException {
        setWait(1000);
        clickElement(txtBrand);
        sendKeys(txtBrand,brand);
        clickElement(cbBrand);
        setWait(1000);
    }
    public void selectAmount(String minAmount,String maxAmount) throws InterruptedException {
        clickElement(txtMinAmount);
        sendKeys(txtMinAmount,minAmount);
        setWait(1000);
        clickElement(txtMaxAmount);
        sendKeys(txtMaxAmount,maxAmount);
        setWait(1000);
        clickElement(btnAmountSearch);
        setWait(1000);
        clickElement(btnLaptop);
        setWait(1000);
    }
    public void addBasket() throws InterruptedException {
        setWait(1000);
        ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(1));
        clickElement(btnAddBasket);
        setWait(2000);
    }
}
