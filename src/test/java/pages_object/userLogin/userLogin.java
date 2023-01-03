package pages_object.userLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    public void verifyLogin(){
        String actualPage = driver.getCurrentUrl();
        String expectPage = "https://glab-v2.khgc.dev/";
        if (actualPage == expectPage){
            System.out.println("Login Successfully");
        }else {
            System.out.println("Login Fail");
        }
    }
}
