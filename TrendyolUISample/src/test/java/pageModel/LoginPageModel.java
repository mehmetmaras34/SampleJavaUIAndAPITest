package pageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPageModel extends BaseModel {
    By btnLoginPage=By.xpath("//p[@class='link-text' and text()='Giriş Yap']");
    By txtEmail=By.id("login-email");
    By txtPassword=By.id("login-password-input");
    By btnLogin=By.xpath("//button[@class='q-primary q-fluid q-button-medium q-button submit']");
    By btnSignInTab=By.xpath("//button[@class='q-secondary q-button-medium q-button tab button right ']/span[text()='Üye Ol']");
    By txtRegisterEmail=By.id("register-email");
    By txtRegisterPassword=By.id("register-password-input");
    By selectMaleGender=By.xpath("//button[@class='q-gray q-fluid q-button-medium q-button male  ']");
    By txtErrorMessage=By.xpath("//*[@id='error-box-wrapper']/span[@class='message']");
    By pageEmailVerify=By.xpath("//div[@class='evm-descs']/span[1]");
    By cbxEnlightenmentText=By.xpath("//*[name()='svg']");


    public LoginPageModel(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickLoginPageBtn() {
        clickElement(btnLoginPage);
    }
    public void setEmail(String email){
        clickElement(txtEmail);
        sendKeys(txtEmail,email);
    }
    public void setPassword(String password){
        clickElement(txtPassword);
        sendKeys(txtPassword,password);
    }
    public void clickLoginBtn() {
        clickElement(btnLogin);
    }
    public void clickSignInTabBtn(){
        clickElement(btnSignInTab);
    }
    public void setRegisterEmail(String registerEmail){
        clickElement(txtRegisterEmail);
        sendKeys(txtRegisterEmail,registerEmail);
    }
    public void clickRegisterPassword(){
        clickElement(txtRegisterPassword);
    }
    public void setRegisterPassword(String registerPassword){
        clickRegisterPassword();
        sendKeys(txtRegisterPassword,registerPassword);
    }
    public void clickMaleGender(){
        clickElement(selectMaleGender);
    }

    public String checkErrorMessage(){
        String message=getText(txtErrorMessage);
        return message;
    }
    private List<WebElement> getAllCheckbox() {
        return findAll(cbxEnlightenmentText);
    }
    public void clickEnlightenmentText() throws InterruptedException {
        getAllCheckbox().get(1).click();
        setWait(1000);
    }
    public String checkEmailVerifyPopup() throws InterruptedException {
        setWait(3000);
        String message=getText(pageEmailVerify);
        return message;
    }

}
