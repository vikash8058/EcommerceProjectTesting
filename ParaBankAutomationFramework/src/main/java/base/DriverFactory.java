package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverFactory {

	private static WebDriver driver;

	// This method CREATES driver
	public static WebDriver initDriver() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://parabank.parasoft.com/");

		return driver;
	}

	// This method RETURNS existing driver
	public static WebDriver getDriver() {
		return driver;
	}

	// This method CLOSES browser
	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
