package pageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseModel {
    WebDriver webDriver;
    WebDriverWait wait;

    public BaseModel(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait=new WebDriverWait(webDriver,10);
    }
    public void elementClickable(By byElement){
        wait.until(ExpectedConditions.elementToBeClickable(byElement));
    }
    public boolean enableElement(By byElement){
        return webDriver.findElement(byElement).isEnabled();
    }
    public void elementAppear(By byElement){
        wait.until(ExpectedConditions.presenceOfElementLocated(byElement));
    }
    public WebElement findElement(By byElement){
        elementAppear(byElement);
        return webDriver.findElement(byElement);
    }
    public void setWait(int wait) throws InterruptedException {
        Thread.sleep(wait);
    }
    public void clickElement(By byElement){
        elementClickable(byElement);
        findElement(byElement).click();
    }
    public String getText (By byElement){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(byElement)).getText();
    }
    public void sendKeys(By byElement,String text){
        elementClickable(byElement);
        findElement(byElement).sendKeys(text);
    }
    public List<WebElement> findAll(By locator){
        return webDriver.findElements(locator);
    }
    public String checkUrl() throws InterruptedException {
        setWait(5000);
        String url= webDriver.getCurrentUrl();
        return url;
    }
}
