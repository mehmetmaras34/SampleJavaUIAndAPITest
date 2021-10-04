package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageModel.LoginPageModel;
import pageModel.AddToBasketModel;

public class AddToBasketTest extends BaseTest {

    @Test
    public void AddToBasket() throws InterruptedException{
        LoginPageModel loginPageModel = new LoginPageModel(webDriver);
        AddToBasketModel addToBasketModel = new AddToBasketModel(webDriver);
        loginPageModel.clickLoginPageBtn();
        loginPageModel.setEmail("bultorupsa@vusra.com");
        loginPageModel.setPassword("test123456");
        loginPageModel.clickLoginBtn();
        Assert.assertTrue(loginPageModel.checkUrl().contains("https://www.trendyol.com/butik"),"Giriş yapılamadı.");
        addToBasketModel.setProduct("Oyuncu Bilgisayarı");
        addToBasketModel.setBrand("Monster");
        addToBasketModel.selectAmount("3000","10000");
        addToBasketModel.addBasket();
    }
}
