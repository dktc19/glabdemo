package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
//    DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
//    LocalDateTime now = LocalDateTime.now();
//    System.out.println(dateTime.format(now));
//    String DateTimeNow = dateTime.format(now);
//    SimpleDateFormat dateFormat = new SimpleDateFormat(DateTimeNow);
    String nameIMG = "GLAB";
    TakesScreenshot scrShot = ((TakesScreenshot) driver) ;
    File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
    //File LinkImg = new File("D:\\Downloads\\"+nameIMG+DateTimeNow+".png");
    File LinkImg = new File("D:\\Downloads\\"+nameIMG+".png");
    FileUtils.copyFile(SrcFile,LinkImg);
    }

}
