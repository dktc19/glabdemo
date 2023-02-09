package testcases;

import base_setup.baseSetup;
import org.testng.annotations.Test;
import pages_object.Products.searchProduct;
import pages_object.userLogin.userLogin;



public class ProductTest extends baseSetup {
    public searchProduct searchProduct;
    public userLogin userLogin;
    @Test
    public void searchProduct() throws InterruptedException {
        userLogin = new userLogin(driver);
        userLogin.clickiconUser();
        userLogin.inputEmail();
        userLogin.inputPassword();
        userLogin.clickBtnLogin();
        searchProduct = new searchProduct(driver);
        searchProduct.clickbtnSearch();
        searchProduct.chooseProduct();
    }
}
