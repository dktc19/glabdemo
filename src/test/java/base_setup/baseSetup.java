package base_setup;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.nio.file.Files;
import java.util.concurrent.TimeUnit;

public class baseSetup {
    public String baseUrl = "https://glab-v2.khgc.dev/admin/dashboard";
//    public String baseUrl = "https://glab-v2.khgc.dev/";
    private static final String srcDir = System.getProperty("user.dir") + "/src\\main\\resources/";
    String driverPath = srcDir + "\\chromedriver.exe";
    public WebDriver driver;
//    public WebDriver getDriver(){
//        return this.driver;
//    }

    @BeforeSuite
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }
}
