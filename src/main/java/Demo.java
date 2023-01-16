import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Demo {
    public String baseUrl = "https://glab-v2.khgc.dev/admin/dashboard";
    String driverPath = "D:\\seleniumChrome\\chromedriver.exe";
    private WebDriver driver ;
    @BeforeTest
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",driverPath);
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
    public void Coupon() throws InterruptedException, IOException {
        for (int i = 0; i<1;i++){
            Thread.sleep(2000);
            subCoupon(String.valueOf(i));
        }
    }
    private void subCoupon(String stt) throws InterruptedException, IOException {
//        String stt = null;
//        String idCode = "tuankiet";
        WebElement coupon = driver.findElement(By.xpath("//span[contains(text(),'Tiếp Thị')]"));
        coupon.click();
        WebElement crCoupon = driver.findElement(By.id("item8"));
        crCoupon.click();
        WebElement clickCreate = driver.findElement(By.xpath("//a[contains(text(),'Tạo Mới')]"));
        clickCreate.click();
        WebElement code = driver.findElement(By.id("sCode"));
        code.sendKeys("tuankiet" + stt);
        Thread.sleep(2000);
        code.sendKeys(Keys.ENTER);
        TakesScreenshot scrShot = ((TakesScreenshot) driver) ;
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File LinkImg = new File("D:\\Downloads\\test.png");
        FileUtils.copyFile(SrcFile,LinkImg);
//        WebElement event = driver.findElement(By.xpath("//body/div[@id='container']/div[@id='content']/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[3]/div[1]/div[1]/button[1]"));
//        event.click();
//        WebElement subEvent = driver.findElement(By.xpath("//body/div[@id='container']/div[@id='content']/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/a[3]/span[1]"));
//        subEvent.click();
//        WebElement limit = driver.findElement(By.id("sLimit"));
//        limit.sendKeys("10");
//        WebElement amount = driver.findElement(By.id("sAmount"));
//        amount.sendKeys("10");
    }
//    public void openWindow(){
//        String mainWindow = driver.getWindowHandle();
//        WebElement openWindow = driver.findElement(By.id("openwindow"));
//        openWindow.click();
//        for(String secondWindow : driver.getWindowHandles()){
//            driver.switchTo().window(secondWindow);
//        }
//        driver.close();
//// Switch back to original browser (first window)
//        driver.switchTo().window(mainWindow);
//
//    }
//    @Test(priority = 2)
//    public void inputName() throws InterruptedException {
//        WebElement inputName = driver.findElement(By.id("name"));
//        inputName.sendKeys("Hà Tuấn Kiệt");
//        Thread.sleep(2000);
//        WebElement clickAlert = driver.findElement(By.xpath("//input[@id='alertbtn']"));
//        clickAlert.click();
//        Thread.sleep(2000);
//        Alert alert = driver.switchTo().alert();
//        alert.accept();
//    }
//    @Test(priority = 3)
//    public void selectOpt(){
//        Select dropdown = new Select(driver.findElement(By.id("multiple-select-example")));
//        dropdown.selectByValue("orange");
//        dropdown.selectByValue("peach");
//
//    }
//    @Test(priority = 4)
//    public void mouseMove (){
//        WebElement placeMouse = driver.findElement(By.id("mousehover"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(placeMouse).perform();
////        actions.contextClick(placeMouse).perform();
//    }
//    @Test(priority = 5)
//    public void iFrame () throws InterruptedException {
//        int frameTotal = driver.findElements(By.tagName("iframe")).size();
//        System.out.println(frameTotal);
//        driver.switchTo().frame(0);
//        WebElement rightClick = driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]"));
//        System.out.println(rightClick.getText());
//        System.out.println(rightClick.getLocation());
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView();", rightClick);
//        Thread.sleep(2000);
//        Actions actions = new Actions(driver);
//        actions.contextClick(rightClick).perform();
//    }
////    @Test(priority = 6)
////    public void rightClick(){
////        WebElement clickRight = driver.findElement(By.id("courses-iframe"));
////        System.out.println(clickRight.getLocation());
////        Actions actions = new Actions(driver);
////        actions.moveToElement(clickRight).perform();
////        actions.contextClick(clickRight).perform();
////    }
////    @Test(priority = 7)
////    public void BT_02() {
////        driver.get("https://courses.letskodeit.com/practice");
////        List<WebElement> items = driver.findElements(By.xpath("//table[@id='product']//td[@class='course-name']"));
////        System.out.println("Courses:");
////        for (WebElement item : items) {
////            String text = new String();
////            text = item.getText();
////            System.out.println(text);
////        }
////    }
//
////    @AfterTest
////    public void setDown(){
////        driver.quit();
////    }
}
