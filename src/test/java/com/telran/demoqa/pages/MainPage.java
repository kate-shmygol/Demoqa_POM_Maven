package com.telran.demoqa.pages;

import com.telran.demoqa.pages.bookStorePages.BookStorePage;
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
//	@FindBy(xpath = "//div[@class='category-cards']/div[6]")
	@FindBy(xpath = "//div[@class='category-cards']/div[.='Book Store Application']")
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

	@FindBy(xpath = "//div[@class='category-cards']/div[.='Alerts, Frame & Windows']")
	WebElement alertsFrameAndWindow;

	public SidePanelPage getAlertsFrameAndWindows() {
		clickWithJSExecutor(alertsFrameAndWindow, 0, 300);
		return new SidePanelPage(driver);
	}

	@FindBy(xpath = "//div[@class='category-cards']/div[.='Widgets']")
	WebElement widgets;

	public SidePanelPage getWidgets() {
		clickWithJSExecutor(widgets, 0, 300);
		return new SidePanelPage(driver);
	}

	@FindBy(xpath = "//div[@class='category-cards']/div[2]")
	WebElement form;

	public SidePanelPage getForms() {
		clickWithJSExecutor(form, 0, 300);
		return new SidePanelPage(driver);
	}

	@FindBy(xpath = "//h5[.='Interactions']")
	WebElement interactions;

	public SidePanelPage getInteractions() {
		clickWithJSExecutor(interactions, 0, 300);
		return new SidePanelPage(driver);
	}
}
