package com.telran.demoqa.pages;

import com.telran.demoqa.pages.bookStorePages.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanelPage extends PageBase {

	public SidePanelPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = ".show #item-3")
	WebElement profile;

	public ProfilePage selectProfile() {
		clickWithJSExecutor(profile, 0, 500);
		return new ProfilePage(driver);
	}

	@FindBy(xpath = "//span[.='Alerts']")
	WebElement alerts;

	public AlertPage selectAlert() {
		clickWithJSExecutor(alerts, 0, 300);
		return new AlertPage(driver);
	}

	@FindBy(xpath = "//span[.='Browser Windows']")
	WebElement browserWindows;

	public WindowPage selectBrowserWindows() {
		clickWithJSExecutor(browserWindows, 0, 300);
		return new WindowPage(driver);
	}

	@FindBy(xpath = "//span[.='Select Menu']")
	WebElement selectMenu;

	public SelectMenuPage selectSelectMenu() {
		clickWithJSExecutor(selectMenu, 0, 500);
		return new SelectMenuPage(driver);
	}

	@FindBy(xpath = "//span[.='Practice Form']")
	WebElement practiceForm;

	public FormsPage selectPracticeForm() {
		click(practiceForm);
		return new FormsPage(driver);
	}

	@FindBy(xpath = "//span[.='Droppable']")
	WebElement droppable;

	public DragAndDropPage selectDroppable() {
		clickWithJSExecutor(droppable, 0, 500);
		return new DragAndDropPage(driver);
	}

	@FindBy(xpath = "//span[.='Text Box']")
	WebElement textBox;

	public ElementsPage selectTextBox() {
		click(textBox);
		return new ElementsPage(driver);
	}

	@FindBy(xpath = "//span[.='Links']")
	WebElement selectLinks;

	public BrokenLinksImagesPage selectLinks() {
		clickWithJSExecutor(selectLinks, 0, 700);
		return new BrokenLinksImagesPage(driver);
	}

	@FindBy(xpath = "//span[.='Broken Links - Images']")
	WebElement selectBrokenLinksAndImages;

	public BrokenLinksImagesPage selectBrokenLinks() {
		clickWithJSExecutor(selectBrokenLinksAndImages, 0, 700);
		return new BrokenLinksImagesPage(driver);
	}
}
