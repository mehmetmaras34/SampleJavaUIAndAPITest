package test;

import org.testng.annotations.Test;
import pageModel.CheckProductImageModel;

public class CheckProductImageTest extends BaseTest {

    @Test
    public void CheckProductImage() throws InterruptedException{
        CheckProductImageModel checkProductImageModel = new CheckProductImageModel(webDriver);
        checkProductImageModel.CheckProductImage();
    }
}