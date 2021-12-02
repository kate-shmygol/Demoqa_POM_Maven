package com.telran.demoqa.tests;

import com.telran.demoqa.pages.MainPage;
import com.telran.demoqa.pages.SelectMenuPage;
import com.telran.demoqa.pages.SidePanelPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.text.Style;
import java.awt.*;

public class SelectMenuTests extends TestBase {

	@BeforeMethod
	public void ensurePreconditions() {
		new MainPage(driver).getWidgets();
		new SidePanelPage(driver).selectSelectMenu();
	}

	@Test
	public void clickOnOldStyleTest() {
		new SelectMenuPage(driver).clickOnOldStyle("Blue");
	}
}
