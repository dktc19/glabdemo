package pages_object.Products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class searchProduct {
    private WebDriver driver;
    public searchProduct(WebDriver driver){
        this.driver = driver;
    }
    public void clickbtnSearch() throws InterruptedException {
        WebElement clickbtnSearch = driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/a[1]/i[1]"));
        clickbtnSearch.click();
    }
    public void chooseProduct (){
        WebElement inputNameProduct = driver.findElement(By.xpath("//body/div[@id='offcanvasSearchItem']/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]"));
        inputNameProduct.sendKeys("Human Made Tiger Graphic #11 T-Shirt Black");
        WebElement chooseProduct = driver.findElement(By.xpath("//body/div[@id='offcanvasSearchItem']/div[1]/div[1]/div[2]/div[1]/div[2]/a[1]"));
        chooseProduct.click();
    }
}
