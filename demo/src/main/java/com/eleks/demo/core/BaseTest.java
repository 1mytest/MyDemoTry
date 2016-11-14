package com.eleks.demo.core;
import static com.eleks.demo.core.DriverMaster.getDriver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public abstract class BaseTest {
	protected WebDriver driver;

	@BeforeSuite(alwaysRun = true)
	@Parameters("browser")
	public void setUp(String browser) {
		driver = getDriver(browser);
	}

	@AfterTest(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
}
