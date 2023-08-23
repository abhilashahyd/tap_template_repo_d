package hook;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import driverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class MyHook {
	WebDriver driver ;

	@Before
	public void browserSetup() {
		DriverFactory.initializeBrowser("chrome");
        driver = DriverFactory.getDriver();
        driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
