package com.telran.demoqa.tests;

import com.telran.demoqa.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class TestBase {

//		public WebDriver driver;
	public EventFiringWebDriver driver;

	Logger logger = LoggerFactory.getLogger(TestBase.class);

	public static class MyListener extends AbstractWebDriverEventListener {

		Logger logger = LoggerFactory.getLogger(TestBase.class);

		@Override
		public void beforeFindBy(By by, WebElement element, WebDriver driver) {
			logger.info("Start search " + by);
		}

		@Override
		public void afterFindBy(By by, WebElement element, WebDriver driver) {
			logger.info(by + " found.");
		}

		@Override
		public void onException(Throwable throwable, WebDriver driver) {
			logger.error(throwable.toString());
		}
	}

	@BeforeMethod
	public void setUp(Method m) {
		logger.info("Start test " + m.getName());
		driver = new EventFiringWebDriver(new ChromeDriver());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demoqa.com");

		driver.register(new MyListener());
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
