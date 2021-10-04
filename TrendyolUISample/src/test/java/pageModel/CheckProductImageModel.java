package pageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CheckProductImageModel extends BaseModel {
    By btnTabs=By.xpath("//li[@class='tab-link']");
    By btnComponent=By.xpath("//*[@id='browsing-gw-homepage']/div/div[2]/div[1]/div[1]/article[1]/a/span");
    By btnProductImage=By.xpath("//div[@class='image-container']/img");

    public CheckProductImageModel(WebDriver webDriver) {
        super(webDriver);
    }
    private List<WebElement>getAllProducts() {
       return findAll(btnTabs);
    }
    private List<WebElement>getAllComponent() {
        return findAll(btnComponent);
    }
    private List<WebElement>getAllImage() {
        return findAll(btnProductImage);
    }
    public void CheckProductImage() throws InterruptedException {
        for (int i=0; i<=9;i++){
            getAllProducts().get(i).click();
            setWait(2000);;
            getAllComponent().get(0).click();
            setWait(2000);
               for (int k=1; k<=4;k++){
                   Assert.assertTrue(getAllImage().get(k).isEnabled(),"Ürünün resmi mevcut değil.");
                }
            }
        }
    }





