package com.telran.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowPage extends PageBase {
	public WindowPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "tabButton")
	WebElement tabBtn;

	public WindowPage clickOnNewTabButton() {
		click(tabBtn);
		List<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		return this;
	}

	@FindBy(id = "sampleHeading")
	WebElement sampleText;

	public String getTextFromNewTab() {
		return sampleText.getText();
	}

	@FindBy(id = "windowButton")
	WebElement windowBtn;

	public WindowPage clickOnNewWindowButton() {
		click(windowBtn);
		List<String> windows = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		return this;
	}

	@FindBy(id = "messageWindowButton")
	WebElement windowMsgButton;

	@FindBy(xpath = "//body")
	WebElement bigText;

	public WindowPage clickOnNewWindowMessageButton() {
		click(windowBtn);
//		click(windowMsgButton);

		String MainWindow = driver.getWindowHandle();
		System.out.println("Main window handle is " + MainWindow);

		Set<String> s1 = driver.getWindowHandles();
		System.out.println("Child window handle is" + s1);

		for (String ChildWindow : driver.getWindowHandles()) {
			if (!MainWindow.contentEquals(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
//				WebElement text = driver.findElement(By.xpath("//body"));
				WebElement text = driver.findElement(By.id("sampleHeading"));
				System.out.println("Heading of child window is " + text.getText());
				break;
			}
		}

//		Iterator<String> i1 = s1.iterator();

//		while (i1.hasNext()) {
//			String ChildWindow = i1.next();
//			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
//				driver.switchTo().window(ChildWindow);
//				WebElement text = driver.findElement(By.id("sampleHeading"));
////				WebElement text = driver.findElement(By.xpath("//body"));
//				System.out.println("Heading of child window is " + text.getText());
//				driver.close();
//				System.out.println("Child window closed");
//			}
//		}
//
// 		Iterator<String> itr = driver.getWindowHandles().iterator();
//		String lastElement = null;
//		while (itr.hasNext()) {
//			lastElement = itr.next();
//		}
//		driver.switchTo().window(lastElement);

		return this;
	}

	public String getTextFromNewWindow() {
		pause(3000);
		System.out.println(bigText.getText());
		return bigText.getText();
	}
}
