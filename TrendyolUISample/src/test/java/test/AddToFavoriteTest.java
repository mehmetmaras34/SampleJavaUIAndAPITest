package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageModel.AddToBasketModel;
import pageModel.AddToFavoriteModel;
import pageModel.LoginPageModel;

public class AddToFavoriteTest extends BaseTest {

    @Test
    public void AddToFavorite() throws InterruptedException{
        LoginPageModel loginPageModel = new LoginPageModel(webDriver);
        AddToBasketModel addToBasketModel = new AddToBasketModel(webDriver);
        AddToFavoriteModel addToFavoriteModel = new AddToFavoriteModel(webDriver);
        loginPageModel.clickLoginPageBtn();
        loginPageModel.setEmail("bultorupsa@vusra.com");
        loginPageModel.setPassword("test123456");
        loginPageModel.clickLoginBtn();
        Assert.assertTrue(loginPageModel.checkUrl().contains("https://www.trendyol.com/butik"),"Giriş yapılamadı.");
        addToBasketModel.setProduct("Gömlek");
        addToFavoriteModel.addFavorite();
    }
}