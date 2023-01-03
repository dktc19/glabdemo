import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Glab_Demo {
    public String baseUrl = "https://glab-v2.khgc.dev/admin/dashboard";
    private static final String srcDir = System.getProperty("user.dir") + "/src\\main\\resources/";
    String driverPath = srcDir + "\\chromedriver.exe";
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
        WebElement product = driver.findElement(By.xpath("//span[contains(text(),'Sản Phẩm')]"));
        product.click();
        WebElement addProduct = driver.findElement(By.xpath("//a[contains(text(),'Sản Phẩm')]"));
        addProduct.click();
        WebElement clickCreate = driver.findElement(By.xpath("//a[contains(text(),'Tạo Mới')]"));
        clickCreate.click();
        WebElement btnX = driver.findElement(By.xpath("//body/div[4]/div[3]/div[2]/a[1]"));
        btnX.click();
        WebElement btnNext = driver.findElement(By.xpath("//a[contains(text(),'Next')]"));
        btnNext.click();
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.moveToElement(btnNext).click().perform();
        //Cách 1 để upload file ảnh
        WebElement clickUpload = driver.findElement(By.name("thumbnail_image"));
        clickUpload.sendKeys(srcDir + "\\kietgiay.png");
        //clickUpload.sendKeys("C:\\Users\\Admin\\OneDrive\\Desktop\\Ảnh Glab\\kietgiay.png");
        WebElement clickMutipleImg = driver.findElement(By.id("detailImagesInput"));
        clickMutipleImg.sendKeys(srcDir + "\\kietgiay.png");
        //Cách 2 để upload file ảnh



    }
}
