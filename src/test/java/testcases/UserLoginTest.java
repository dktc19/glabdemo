package testcases;

import base_setup.baseSetup;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages_object.userLogin.userLogin;
import utils.ScreenShot;

import java.io.IOException;
import java.text.ParseException;

public class UserLoginTest extends baseSetup {
    /**Hàm dựng*/
    public userLogin userLogin;
    public ScreenShot screenShot;
    @Test
    public void Login() throws IOException, ParseException {

        userLogin = new userLogin(driver);
        userLogin.clickiconUser();
        userLogin.inputEmail();
        userLogin.inputPassword();
        userLogin.clickBtnLogin();
        screenShot = new ScreenShot(driver);
        screenShot.ScreenShot();
        userLogin.quit();
    }
}
