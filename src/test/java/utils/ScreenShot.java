package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShot {
    private WebDriver driver;
    /**
     * Hàm xây dựng: Hàm dùng để khai báo driver của class này = driver mình truyền vào
     * cụ thể ở đây là driver của file baseSetup
     * */
    public ScreenShot(WebDriver driver) {
        this.driver = driver;
    }
    public void ScreenShot() throws IOException {
    TakesScreenshot scrShot = ((TakesScreenshot) driver) ;
    File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
    File LinkImg = new File("D:\\Downloads\\demo.png");
    FileUtils.copyFile(SrcFile,LinkImg);
    }

}
