package testcases;

import base_setup.baseSetup;
import org.testng.annotations.Test;
import pages_object.loginPage.loginPage;
import pages_object.userLogin.userLogin;

public class loginTest extends baseSetup {
     public userLogin userLogin;

    @Test
    public void Login(){
        userLogin = new userLogin(driver);
        userLogin.clickiconUser();
        userLogin.inputEmail();
        userLogin.inputPassword();
        userLogin.clickBtnLogin();
    }
}
