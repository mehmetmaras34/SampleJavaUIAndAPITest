package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageModel.LoginPageModel;

public class LoginPageTest extends BaseTest {
    @Test
    public void InvalidEmail(){
        LoginPageModel loginPageModel = new LoginPageModel(webDriver);
        loginPageModel.clickLoginPageBtn();
        loginPageModel.setEmail("ASD");
        loginPageModel.clickLoginBtn();
        Assert.assertTrue(loginPageModel.checkErrorMessage().contains("Lütfen geçerli bir e-posta adresi giriniz."),"Hata mesajı yanlış geliyor.");

    }
    @Test
    public void InvalidPassword(){
        LoginPageModel loginPageModel = new LoginPageModel(webDriver);
        loginPageModel.clickLoginPageBtn();
        loginPageModel.setEmail("bultorupsa@vusra.com");
        loginPageModel.setPassword("tsadasdas");
        loginPageModel.clickLoginBtn();
        Assert.assertTrue(loginPageModel.checkErrorMessage().contains("E-posta adresiniz ve/veya şifreniz hatalı."),"Hata mesajı yanlış geliyor.");
    }
    @Test
    public void SuccessfulLogin() throws InterruptedException{
        LoginPageModel loginPageModel = new LoginPageModel(webDriver);
        loginPageModel.clickLoginPageBtn();
        loginPageModel.setEmail("bultorupsa@vusra.com");
        loginPageModel.setPassword("test123456");
        loginPageModel.clickLoginBtn();
        Assert.assertTrue(loginPageModel.checkUrl().contains("https://www.trendyol.com/butik"),"Giriş yapılamadı.");
    }

    @Test
    public void UsedEmail() {
        LoginPageModel loginPageModel = new LoginPageModel(webDriver);
        loginPageModel.clickLoginPageBtn();
        loginPageModel.clickSignInTabBtn();
        loginPageModel.setRegisterEmail("tidrujiste@vusra.com");
        loginPageModel.clickRegisterPassword();
        Assert.assertTrue(loginPageModel.checkErrorMessage().contains("Bu e-posta adresi kullanılamaz. Lütfen başka bir e-posta adresi deneyiniz."),"Hata mesajı yanlış geliyor.");
    }
    @Test
    public void CreatingPasswordWithMissingCharacter() throws InterruptedException{
        LoginPageModel loginPageModel = new LoginPageModel(webDriver);
        loginPageModel.clickLoginPageBtn();
        loginPageModel.clickSignInTabBtn();
        loginPageModel.setRegisterEmail("verzazekki@vusra.com");
        loginPageModel.setRegisterPassword("123");
        loginPageModel.clickMaleGender();
        Assert.assertTrue(loginPageModel.checkErrorMessage().contains("Şifreniz 7 ile 15 karakter arasında olmalıdır."),"Hata mesajı yanlış geliyor.");
    }
    @Test
    public void MaximumPasswordLength() throws InterruptedException{
        LoginPageModel loginPageModel = new LoginPageModel(webDriver);
        loginPageModel.clickLoginPageBtn();
        loginPageModel.clickSignInTabBtn();
        loginPageModel.setRegisterEmail("verzazekki@vusra.com");
        loginPageModel.setRegisterPassword("123456789101112312");
        loginPageModel.clickMaleGender();
        Assert.assertTrue(loginPageModel.checkErrorMessage().contains("Şifreniz 7 ile 15 karakter arasında olmalıdır."),"Hata mesajı yanlış geliyor.");
    }
    @Test
    public void CreatingPasswordWithoutUsingLetters() throws InterruptedException{
        LoginPageModel loginPageModel = new LoginPageModel(webDriver);
        loginPageModel.clickLoginPageBtn();
        loginPageModel.clickSignInTabBtn();
        loginPageModel.setRegisterEmail("verzazekki@vusra.com");
        loginPageModel.setRegisterPassword("12345678");
        loginPageModel.clickMaleGender();
        Assert.assertTrue(loginPageModel.checkErrorMessage().contains("Şifreniz en az 1 harf içermelidir."),"Hata mesajı yanlış geliyor.");
    }

    @Test
    public void SuccessfulSignUp() throws InterruptedException{
        LoginPageModel loginPageModel = new LoginPageModel(webDriver);
        loginPageModel.clickLoginPageBtn();
        loginPageModel.clickSignInTabBtn();
        loginPageModel.setRegisterEmail("ledrekospi@vusra.com");
        loginPageModel.setRegisterPassword("Test123456789");
        loginPageModel.clickMaleGender();
        loginPageModel.clickEnlightenmentText();
        loginPageModel.clickLoginBtn();
        Assert.assertTrue(loginPageModel.checkEmailVerifyPopup().contains("E-POSTA DOĞRULAMA"),"E-Posta Doğrulama Popup'ı Açılmadı.");
    }
}
