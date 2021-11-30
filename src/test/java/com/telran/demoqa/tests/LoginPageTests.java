package com.telran.demoqa.tests;

import com.telran.demoqa.pages.LoginPage;
import com.telran.demoqa.pages.MainPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginPageTests extends TestBase {

	@BeforeMethod
	public void ensurePreconditions() {
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demoqa.com");

		new MainPage(driver).goToBookStorePage();
	}

	@Test
	public void isLoginBtnPresent() {
		new MainPage(driver).closeBanner();
		new MainPage(driver).goToBookStorePage();
		new MainPage(driver).goToLoginPage();
	}

	@Test
	public void loginPositiveTest() {
		new LoginPage(driver).closeBanner();
		new LoginPage(driver).login("world", "demoqa.World123$")
				.verifyUserName("world").logout();
	}
}
