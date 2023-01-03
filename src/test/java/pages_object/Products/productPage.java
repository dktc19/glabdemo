package pages_object.Products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class productPage {
    private WebDriver driver;
    public productPage(WebDriver driver) {
        this.driver = driver;
    }
    public void chooseProduct() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement product = driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/a[6]/img[1]"));
        actions.moveToElement(product);
        Thread.sleep(2000);

    }
    public void inputEmail(){

    }
    public void inputPassword(){

    }
    public void clickBtnLogin(){

    }
}
