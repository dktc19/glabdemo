import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class bt5 {
    public WebDriver driver ;
    String driverPath = "D:\\seleniumChrome\\chromedriver.exe";
    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver = new ChromeDriver();
    }
    @Test
    public void bt5() throws InterruptedException {
        for (int i = 0;i<4;i++){
            subBT5();
        }
    }

    private void subBT5() throws InterruptedException {
        driver.get("https://css-tricks.com/examples/DynamicPage/#index.php");
        WebElement printP = driver.findElement(By.xpath("//body/div[@id='page-wrap']/section[@id='main-content']/div[@id='guts']/p[2]"));
        System.out.println(printP.getText());
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'Contact')]")).click();
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='main-content']")));
        driver.switchTo().frame(0);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Field1\"]")));
        driver.findElement(By.xpath("//*[@id=\"Field1\"]")).click();
        driver.findElement(By.id("Field1")).sendKeys("Kiet");
        driver.findElement(By.id("Field2")).sendKeys("Ha Tuan");
        driver.findElement(By.id("Field3")).sendKeys("kietht@gmail.com");
        driver.findElement(By.id("Field4")).sendKeys("Message");
        driver.findElement(By.id("saveForm")).submit();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("wufoo")));
        Assert.assertEquals(driver.findElement(By.className("wufoo")).getText(),"Success! Thanks for filling out my form!");
    }
}
