package testcases;

import base_setup.baseSetup;
import org.testng.annotations.Test;
import pages_object.loginPage.loginPage;

public class loginTest extends baseSetup {
     public loginPage loginPage;

    @Test
    public void Login(){
        loginPage = new loginPage(driver);
        loginPage.enterEmail();
        loginPage.enterPassword();
        loginPage.clickLogin();
    }
}
