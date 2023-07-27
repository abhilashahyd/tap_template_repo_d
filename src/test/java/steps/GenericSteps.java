package Steps;

import Actions.GenericAction;
import io.cucumber.java.en.Given;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GenericSteps {

    Properties prop;

    public GenericAction genericAction=new GenericAction();

    @Given("user login to the application")
    public void user_enter_url() throws IOException {
        String propertyFile = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "data.properties";
        prop = new Properties();
        FileInputStream fis = new FileInputStream(propertyFile);

        prop.load(fis);
        genericAction.initialize();
        genericAction.enterUsername(prop.getProperty("username"));
        genericAction.enterPassword(prop.getProperty("password"));
        genericAction.clickOnSignInBtn();
    }



}
