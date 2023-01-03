package testcases;

import base_setup.baseSetup;
import org.testng.annotations.Test;
import pages_object.Products.productPage;
import pages_object.userLogin.userLogin;



public class ProductTest extends baseSetup {
    public productPage productPage;
    public userLogin userLogin;
    @Test
    public void productTest() throws InterruptedException {
        userLogin = new userLogin(driver);
        userLogin.clickiconUser();
        userLogin.inputEmail();
        userLogin.inputPassword();
        userLogin.clickBtnLogin();
        productPage = new productPage(driver);
        productPage.chooseProduct();
    }
}
