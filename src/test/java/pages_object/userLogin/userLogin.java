package pages_object.userLogin;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;


public class userLogin {
    private WebDriver driver;
    public userLogin(WebDriver driver) {
        this.driver = driver;
    }
    public void clickiconUser(){
        WebElement btnUser = driver.findElement(By.xpath("//body/nav[1]/div[1]/div[2]/a[4]"));
        btnUser.click();
    }
    public void inputEmail(){
        WebElement email = driver.findElement(By.id("emailInput"));
        email.sendKeys("kietht@glab.vn");
    }
    public void inputPassword(){
        WebElement password = driver.findElement(By.id("passwordInput"));
        password.sendKeys("Kietht@123");
    }
    public void clickBtnLogin(){
        WebElement btnLogin = driver.findElement(By.xpath("//button[contains(text(),'Đăng Nhập')]"));
        btnLogin.click();
    }
    public void quit(){
        driver.quit();
    }


}
