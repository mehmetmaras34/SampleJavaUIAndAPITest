package pageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class AddToFavoriteModel extends BaseModel {
    By btnFirstAddBasket=By.className("//div[@class='add-to-basket-container']/div[@class='basket-button   ']");
    By btnFavorite=By.xpath("//div/p[text()='Favorilerim']");
    By btnFirstProductFavIcon=By.className("fvrt-btn-wrppr");
    By btnpopup=By.className("popup");

    public AddToFavoriteModel(WebDriver webDriver) {
        super(webDriver);
    }
    private List<WebElement> getAllListProduct() {
        return findAll(btnFirstProductFavIcon);
    }
    private List<WebElement> getAllListBasket() {
        return findAll(btnFirstAddBasket);
    }
    public void addFavorite() throws InterruptedException {
        setWait(5000);
        if (enableElement(btnpopup)){
            Actions builder = new Actions(webDriver);
            builder.moveToElement(findElement(btnpopup), 50, 70).click().build().perform();
            setWait(2000);
            ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
            webDriver.switchTo().window(tabs.get(0));
        }
        getAllListProduct().get(0).click();
        setWait(1000);
        clickElement(btnFavorite);
        setWait(3000);
        getAllListBasket().get(0).click();
        setWait(1000);
    }
}