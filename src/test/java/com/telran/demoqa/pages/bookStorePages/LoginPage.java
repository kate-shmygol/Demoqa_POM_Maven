package com.telran.demoqa.pages.bookStorePages;

import com.telran.demoqa.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "userName")
	WebElement userName;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "login")
	WebElement loginBtn;

	public ProfilePage login(String userNameText, String passwordText) {
		type(userName, userNameText);
		type(password, passwordText);
		loginBtn.click();
		return new ProfilePage(driver); // initialize class 'ProfilePage'
	}

	public LoginPage loginNegative(String userNameText, String passwordText) {
		type(userName, userNameText);
		type(password, passwordText);
		loginBtn.click();
		return this;
	}
}
