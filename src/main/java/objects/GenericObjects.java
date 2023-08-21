package pageObjects;

import Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GenericObjects extends BaseClass {
    public WebElement emailField() {
        WebElement emailFeild=driver.findElement(By.xpath("//*[@id=\"email\"]"));
     return emailFeild;
    }

    public WebElement passwordField() {
        WebElement passwordFeild=driver.findElement(By.xpath("//*[@id=\"password\"]"));
        return passwordFeild;
    }

    public WebElement signInBtn() {
        WebElement signInButton=driver.findElement(By.xpath("//*[contains(text(),'Sign in')]//parent::button"));
        return signInButton;
    }
    public WebElement signInButton() {
        WebElement signInButton=driver.findElement(By.xpath("//a[contains(text(),' Sign in')]"));
        return signInButton;
    }
}
