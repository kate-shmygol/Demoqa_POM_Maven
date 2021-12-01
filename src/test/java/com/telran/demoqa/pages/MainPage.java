package com.telran.demoqa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageBase {

	public MainPage(WebDriver driver) {
		super(driver);
	}

//	@FindBy(css = ".card:nth-child(6) h5")
//	@FindBy(xpath = "//div[@class='category-cards']/div[.='Book Store Application']")
	@FindBy(xpath = "//div[@class='category-cards']/div[6]")
	WebElement bookStoreBtn;

	public BookStorePage getBookStore() {
//		clickWithAction(bookStoreBtn);
		clickWithJSExecutor(bookStoreBtn, 0, 300);
		return new BookStorePage(driver);
	}

	public void clickWithAction(WebElement element) {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		element.click();
	}
}
