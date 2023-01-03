import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;



import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class bt4 {
    String driverPath = "D:\\seleniumChrome\\chromedriver.exe";
    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver = new ChromeDriver();
    }
    public WebDriver driver ;
    @Test
    public void closeSmall() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/modal-dialogs");
        driver.manage().window().maximize();
        WebElement clickSmall = driver.findElement(By.id("showSmallModal"));
        clickSmall.click();
        Thread.sleep(2000);
        WebElement close = driver.findElement(By.id("closeSmallModal"));
        close.click();
    }
    @Test
    public void openWindow() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");
        WebElement clicknewMessage = driver.findElement(By.id("messageWindowButton"));
        clicknewMessage.click();
        Thread.sleep(2000);
        String mainWindow = driver.getWindowHandle();
        for(String secondWindow : driver.getWindowHandles()){
            driver.switchTo().window(secondWindow);
        }
        driver.close();
        driver.switchTo().window(mainWindow);
    }
    @Test
    public void switchIframe(){
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/nestedframes");
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println(size);
        driver.switchTo().frame(2);
        System.out.println (driver.getPageSource());
        size = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Iframe con " +size);
        driver.switchTo().frame(0);
        System.out.println (driver.getPageSource());
        WebElement print = driver.findElement(By.xpath("/html/body/p"));
        String printChild = print.getText();
        System.out.println(printChild);

    }
    @Test
    public void switchIframe1(){
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/nestedframes");
        driver.switchTo().frame("frame1");
        driver.switchTo().frame(0);
        WebElement print = driver.findElement(By.xpath("/html/body/p"));
        String printChild = print.getText();
        System.out.println(printChild);
    }
    @Test
    public void promtPopup(){
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        WebElement clickPromt = driver.findElement(By.id("promtButton"));
        clickPromt.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Ha Tuan Kiet");
        alert.accept();
    }
    @Test
    public void Test_Chrome() throws InterruptedException, IOException {
        //Chrome setup
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("browserVersion", "97.0");
        chromeOptions.setCapability("platformName", "Linux");
        Proxy proxy = new Proxy();  proxy.setHttpProxy("proxy.hcm.fpt.vn:80");
        proxy.setSslProxy("proxy.hcm.fpt.vn:80");
        chromeOptions.setCapability("proxy", proxy);
        chromeOptions.addArguments("--no-default-browser-check");
        chromeOptions.addArguments("--no-sandbox");
        HashMap<String, Object> chromePreferences = new HashMap<>();
        chromePreferences.put("profile.password_manager_enabled",false);
        chromeOptions.setExperimentalOption("prefs",           chromePreferences);
        //Call Chrome browser
        driver = new RemoteWebDriver(new URL("http://seleniumhub.fpt.net"), chromeOptions);
        driver.get("http://papertoilet.com");
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./image.png"));
        driver.quit();
    }
    @Test
    public void BT_5() throws InterruptedException {
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
        driver.findElement(By.id("Field1")).sendKeys("Kiet");
        driver.findElement(By.id("Field2")).sendKeys("Ha Tuan");
        driver.findElement(By.id("Field3")).sendKeys("kietht@gmail.com");
        driver.findElement(By.id("Field4")).sendKeys("Message");
        driver.findElement(By.id("saveForm")).submit();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("wufoo")));
        Assert.assertEquals(driver.findElement(By.className("wufoo")).getText(),"Success! Thanks for filling out my form!");
        driver.close();
    }
    @Test
    public void ABC(){
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//input[@type = 'text']")).sendKeys("abc");
    }
    }
