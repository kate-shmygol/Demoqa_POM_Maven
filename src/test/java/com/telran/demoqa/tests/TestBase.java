package com.telran.demoqa.tests;

import com.telran.demoqa.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class TestBase {

	public WebDriver driver;

	Logger logger = LoggerFactory.getLogger(TestBase.class);

	@BeforeMethod
	public void setUp(Method m) {
		logger.info("Start test " + m.getName());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demoqa.com");
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
//		logger.info("Stop test " + m.getName()); // in signature - 'Method m' (import java.lang.reflect.Method;)
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
