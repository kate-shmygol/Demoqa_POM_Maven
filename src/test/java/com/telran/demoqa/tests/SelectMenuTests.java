package com.telran.demoqa.tests;

import com.telran.demoqa.pages.MainPage;
import com.telran.demoqa.pages.SelectMenuPage;
import com.telran.demoqa.pages.SidePanelPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

	@Test
	public void clickMultiSelectDropDownTest() {
		new SelectMenuPage(driver).clickMultiSelectDropDown("Red").deselect();
		new SelectMenuPage(driver).clickMultiSelectDropDown1("Red", "Blue", "Green");
	}

	@Test
	public void standardMultiSelectTest() {
		new SelectMenuPage(driver).clickStandardMultiSelect();
	}
}
