package Base;

import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
package Actions;

import Base.BaseClass;
import PageObjects.EmployeeObjects;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static WebDriver driver;
    public Properties prop;


    public WebDriver initializeDriver() throws IOException {

        String propertyFile = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "data.properties";
        prop = new Properties();
        FileInputStream fis = new FileInputStream(propertyFile);

        prop.load(fis);
        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome")) {
            driver = new ChromeDriver();
            // execute in chrome driver*/
        } else if (browserName.equals("firefox")) {
            driver = new FirefoxDriver();
            // firefox code
        } else if (browserName.equals("IE")) {
            driver = new EdgeDriver();
            // IE code
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    // public void takeScreenShot() throws IOException {

    //     Date currentDate = new Date();
    //     String screenShotFileName = currentDate.toString().replace(" ", "_").replace(":", "_");

    //     File screenshotFile = (((TakesScreenshot) driver)).getScreenshotAs(OutputType.FILE);
    //     FileUtils.copyFile(screenshotFile, new File("src\\test\\resources\\testData\\screenShot\\" + screenShotFileName + ".png"));
    // }
    public void userEnterFromExcel() throws IOException {
        EmployeeObjects employeeObjects = new EmployeeObjects();
        FileInputStream file = new FileInputStream("src/test/resources/testDataFromExcel/excelData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        String cellValue = workbook.getSheet("TestSheet").getRow(0).getCell(1).getStringCellValue();
       }

//
//    @After
//    public void teardown() {
//        if(driver!=null) {
//            driver.close();
//        }
//    }

}
