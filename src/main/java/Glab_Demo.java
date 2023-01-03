import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Glab_Demo {
    public String baseUrl = "https://glab-v2.khgc.dev/admin/dashboard";
    String driverPath = "D:\\seleniumChrome\\chromedriver.exe";
    public WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("kietht@glab.vn");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Kietht@123");
        driver.findElement(By.xpath("//button[contains(text(),'Log In')]")).click();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void Coupon() throws InterruptedException {
        WebElement coupon = driver.findElement(By.xpath("//span[contains(text(),'Tiếp Thị')]"));
        coupon.click();
        WebElement crCoupon = driver.findElement(By.id("item8"));
        crCoupon.click();
        for (int i = 0; i < 2; i++) {
            Thread.sleep(2000);
            subCoupon(String.valueOf(i));
        }
    }

    private void subCoupon(String stt) {
        WebElement clickCreate = driver.findElement(By.xpath("//a[contains(text(),'Tạo Mới')]"));
        clickCreate.click();
        WebElement code = driver.findElement(By.id("sCode"));
        code.sendKeys("skiet" + stt);
        WebElement event = driver.findElement(By.xpath("//body/div[@id='container']/div[@id='content']/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[3]/div[1]/div[1]/button[1]"));
        event.click();
        WebElement subEvent = driver.findElement(By.xpath("//body/div[@id='container']/div[@id='content']/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/a[3]/span[1]"));
        subEvent.click();
        WebElement limit = driver.findElement(By.id("sLimit"));
        limit.sendKeys("10");
        WebElement amount = driver.findElement(By.id("sAmount"));
        amount.sendKeys("10");
        WebElement btnCreate = driver.findElement(By.xpath("//button[contains(text(),'Tạo Mới')]"));
        btnCreate.click();
        driver.findElement(By.xpath("//button[contains(text(),'Cập Nhật')]")).isDisplayed();
        WebElement btnCancel = driver.findElement(By.xpath("//a[contains(text(),'Hủy Bỏ')]"));
        btnCancel.click();
    }
}
