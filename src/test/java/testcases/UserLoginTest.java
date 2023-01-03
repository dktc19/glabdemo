package testcases;

import base_setup.baseSetup;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages_object.userLogin.userLogin;

public class UserLoginTest extends baseSetup {
    public userLogin userLogin;
    @Test
    public void Login(){
        userLogin = new userLogin(driver);
        userLogin.clickiconUser();
        userLogin.inputEmail();
        userLogin.inputPassword();
        userLogin.clickBtnLogin();
        userLogin.verifyLogin();
    }
}
