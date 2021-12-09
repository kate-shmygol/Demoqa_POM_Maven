package com.telran.demoqa.tests;

import com.telran.demoqa.helpers.MyListener;
import com.telran.demoqa.pages.PageBase;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class TestBase {

	Logger logger = LoggerFactory.getLogger(TestBase.class);

//	public WebDriver driver;
	public EventFiringWebDriver driver;

	@BeforeMethod
	public void setUp(Method m, Object[] param) {
		logger.info("Start test " + m.getName() + " with data: " + Arrays.asList(param));
		driver = new EventFiringWebDriver(new ChromeDriver());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demoqa.com");

		driver.register(new MyListener());
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.isSuccess()) {
			logger.info("PASSED: test method - " + result.getMethod().getMethodName());
		} else {
			logger.error("FAILED: test method - " + result.getMethod().getMethodName());
			new PageBase(driver).takeScreenshot();
		}
		logger.info("======================================");
		driver.quit();
	}
}
