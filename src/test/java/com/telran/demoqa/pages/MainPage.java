package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageBase {

	public MainPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = ".card:nth-child(6) h5")
	WebElement bookStoreBtn;

	@FindBy(id = "login")
	WebElement loginBtn;

	public MainPage goToBookStorePage() {
		bookStoreBtn.click();
		return new MainPage(driver);
	}

	public LoginPage goToLoginPage() {
		loginBtn.click();
		return new LoginPage(driver);
	}
}
