package Actions;

import Base.BaseClass;
import PageObjects.GenericObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
// import org.testng.Assert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class GenericAction extends BaseClass {


    GenericObjects genericObjects=new GenericObjects();

    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        WebElement companyTitle=genericObjects.companyTitle();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Boolean result=companyTitle.isDisplayed();
        Assert.assertTrue(result);
    }

    public void enterUsername(String username) {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        WebElement usernameField= genericObjects.usernameField();
        usernameField.sendKeys(username);


    }

    public void enterPassword(String password) {
        WebElement passwordField= genericObjects.passwordField();
        passwordField.sendKeys(password);

    }

    public void clickOnSignInBtn() {
        WebElement signInBtn= genericObjects.signInBtn();
        signInBtn.click();

    }


}
