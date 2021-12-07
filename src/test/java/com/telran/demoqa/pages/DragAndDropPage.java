package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends PageBase {
	public DragAndDropPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "draggable")
	WebElement dragMe;

	@FindBy(id = "droppable")
	WebElement dropHere;

	public DragAndDropPage actionDragMe() {
		Actions actions = new Actions(driver);
		pause(2000);
		actions.dragAndDrop(dragMe, dropHere).build().perform();

		String text = dropHere.getText();
		if (text.equals("Dropped!")) {
			System.out.println("PASS: Source is dropped to target as expected");
		} else {
			System.out.println("FAIL: Source couldn't be drop to target as expected");
		}
		return this;
	}

	public DragAndDropPage dragAndDropBy() {
		Actions actions = new Actions(driver);
//		pause(2000);

		int x = dragMe.getLocation().getX();
		int y = dragMe.getLocation().getY();
		System.out.println("x --> " + x + "y --> " + y);

		int xOffSet = dropHere.getLocation().getX();
		int yOffSet = dropHere.getLocation().getY();
		System.out.println("xOffSet --> " + xOffSet + "yOffSet --> " + yOffSet);

		xOffSet = (xOffSet - x) + 50;
		yOffSet = (yOffSet - y) + 100;
		pause(1000);
		actions.dragAndDropBy(dragMe, xOffSet, yOffSet).build().perform();

		String text = dropHere.getText();
		if (text.equals("Dropped!")) {
			System.out.println("PASS: Source is dropped to target as expected");
		} else {
			System.out.println("FAIL: Source couldn't be drop to target as expected");
		}
		return this;
	}

	public DragAndDropPage dragAndDropBy100() {
		Actions actions = new Actions(driver);
		pause(2000);
		actions.dragAndDropBy(dragMe, 100, 100).build().perform();
		return this;
	}

	@FindBy(id = "droppableExample-tab-accept")
	WebElement tabAccept;

	@FindBy(id = "acceptable")
	WebElement acceptable;

	@FindBy(xpath = "//div[@id='acceptDropContainer']/div[2]")
	WebElement dropHereAccept;

	public DragAndDropPage dragAndDropAccept() {
		click(tabAccept);
		Actions actions = new Actions(driver);
		pause(3000);
		actions.dragAndDrop(acceptable, dropHereAccept).build().perform();

		String text = dropHereAccept.getText();
		if (text.equals("Dropped!")) {
			System.out.println("PASS: Acceptable source is dropped to target as expected");
		} else {
			System.out.println("FAIL: Acceptable source couldn't be drop to target as expected");
		}
		return this;
	}

	@FindBy(id = "notAcceptable")
	WebElement notAcceptable;

	public DragAndDropPage dragAndDropNotAccept() {
		click(tabAccept);
		Actions actions = new Actions(driver);
		pause(2000);
		actions.dragAndDrop(notAcceptable, dropHereAccept).build().perform();

		String text = dropHereAccept.getText();
		if (text.equals("Dropped!")) {
			System.out.println("FAIL: Acceptable source is here and not acceptable source couldn't be dropped to target as expected");
		} else {
			System.out.println("PASS: Not acceptable source couldn't be dropped to target as expected");
		}
		return this;
	}

	@FindBy(id = "droppableExample-tab-revertable")
	WebElement tabRevert;

	@FindBy(id = "revertable")
	WebElement revertable;

	@FindBy(id = "notRevertable")
	WebElement notRevertable;

	@FindBy(xpath = "//div[@id='revertableDropContainer']/div[2]")
	WebElement dropHereRevert;

	public DragAndDropPage dragAndDropWillRevert() {
		click(tabRevert);
		Actions actions = new Actions(driver);
		pause(2000);
		actions.dragAndDrop(revertable, dropHereRevert).build().perform();

		String text = dropHereRevert.getText();
		if (text.equals("Dropped!")) {
			System.out.println("PASS: Reversible source is not here and not reversible source dropped to target as expected");
		} else {
			System.out.println("FAIL: Not reversible source couldn't be dropped to target as expected");
		}
		return this;
	}

	public DragAndDropPage dragAndDropNotRevert() {
		click(tabRevert);
		Actions actions = new Actions(driver);
		pause(2000);
		actions.dragAndDrop(notRevertable, dropHereRevert).build().perform();

		String text = dropHereRevert.getText();
		if (text.equals("Dropped!")) {
			System.out.println("PASS: Reversible source is not here and not reversible source dropped to target as expected");
		} else {
			System.out.println("FAIL: Not reversible source couldn't be dropped to target as expected");
		}
		return this;
	}
}
