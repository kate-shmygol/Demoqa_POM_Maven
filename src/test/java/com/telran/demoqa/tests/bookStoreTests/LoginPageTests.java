package com.telran.demoqa.tests.bookStoreTests;

import com.telran.demoqa.data.UserData;
import com.telran.demoqa.pages.bookStorePages.BookStorePage;
import com.telran.demoqa.pages.bookStorePages.LoginPage;
import com.telran.demoqa.pages.MainPage;
import com.telran.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase {

	@BeforeMethod
	public void ensurePreconditions() {
		new MainPage(driver).getBookStore();
		new BookStorePage(driver).getLoginPage();
	}

	@Test(enabled = false)
	public void loginPositiveTest() {
		new LoginPage(driver).closeBanner();
		new LoginPage(driver).login(UserData.USER_NAME, UserData.USER_PASSWORD)
				.verifyUserName("world").logout();
	}

	@Test
	@Parameters({"name", "password"})
	public void loginPositiveParametersTest(String name, String password) {
		new LoginPage(driver).closeBanner();
		new LoginPage(driver).login(name, password)
				.verifyUserName(name).logout();
	}
}
