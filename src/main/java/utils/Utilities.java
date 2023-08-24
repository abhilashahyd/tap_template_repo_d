package utils;

import java.util.Date;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.FileInputStream;
public class Utilities{
  public void takeScreenShot() throws IOException {

        Date currentDate = new Date();
        String screenShotFileName = currentDate.toString().replace(" ", "_").replace(":", "_");

        File screenshotFile = (((TakesScreenshot) driver)).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(FilePath.screenshotpath + screenShotFileName + ".png"));
    }
}
