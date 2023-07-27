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

public class DataFromExcel extends BaseClass {


    public void userEnterName() throws IOException {
        EmployeeObjects employeeObjects = new EmployeeObjects();
        FileInputStream file = new FileInputStream("src/test/resources/testDataFromExcel/excelData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        String cellValue = workbook.getSheet("TestSheet").getRow(0).getCell(1).getStringCellValue();
        WebElement lastNameField=employeeObjects.lasttNameField();
        lastNameField.sendKeys(cellValue);
    }



}

