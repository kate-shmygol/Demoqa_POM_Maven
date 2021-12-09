package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ToolTipsPage extends PageBase {
	public ToolTipsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "toolTipButton")
	WebElement toolTipBtn;

	@FindBy(id = "buttonToolTip")
	WebElement toolTip;

	public ToolTipsPage hoverToolTipsWithAttribute() {
		click(toolTipBtn);

		String expectedToolTip = toolTip.getAttribute("id");
		System.out.println("Retrieved tool tip as: " + expectedToolTip);
		return this;
	}

	@FindBy(id = "toolTipTextField")
	WebElement hoverMeToSee;

	@FindBy(id = "textFieldToolTip")
	WebElement textFieldToolTip;

	public ToolTipsPage hoverOnInputToSee() {
		Actions actions = new Actions(driver);
		actions.moveToElement(hoverMeToSee).build().perform();

		String expectedToolTipText = textFieldToolTip.getText();

		System.out.println("ToolTipText ---> " + expectedToolTipText);

		if (expectedToolTipText.equalsIgnoreCase("You hovered over the text field")) {
			System.out.println("PASS: ToolTip is matching expected value");
		} else {
			System.out.println("FAIL: ToolTip is NOT matching expected value");
		}
		return this;
	}
}
