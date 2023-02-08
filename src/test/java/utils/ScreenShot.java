package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ScreenShot {
    private WebDriver driver;
    private static final String srcDir = System.getProperty("user.dir") + "/src\\test\\java\\ImgScreenShot\\";

    /**
     * Hàm xây dựng: Hàm dùng để khai báo driver của class này = driver mình truyền vào
     * cụ thể ở đây là driver của file baseSetup
     */
    public ScreenShot(WebDriver driver) {
        this.driver = driver;
    }

    public void ScreenShot() throws IOException, ParseException {
        int realtime = (int) new Date().getTime();
        String nameIMG = "GLAB";
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File LinkImg = new File(srcDir + nameIMG+ realtime + ".png");
        FileUtils.copyFile(SrcFile, LinkImg);
    }

}
