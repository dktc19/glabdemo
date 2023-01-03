package pages_object.loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
    private WebDriver driver;
    public loginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterEmail(){
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("kietht@glab.vn");
    }
    public void enterPassword(){
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Kietht@123");
    }
    public void clickLogin(){
        WebElement btnLogin = driver.findElement(By.xpath("//button[contains(text(),'Log In')]"));
        btnLogin.click();
    }
}
