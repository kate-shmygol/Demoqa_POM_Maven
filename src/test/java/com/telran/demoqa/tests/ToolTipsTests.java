package com.telran.demoqa.tests;

import com.telran.demoqa.pages.MainPage;
import com.telran.demoqa.pages.SidePanelPage;
import com.telran.demoqa.pages.ToolTipsPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ToolTipsTests extends TestBase {

	MainPage home;
	SidePanelPage sidePanel;
	ToolTipsPage toolTips;

	@BeforeMethod
	public void init() {
		home = PageFactory.initElements(driver, MainPage.class);
		sidePanel = PageFactory.initElements(driver, SidePanelPage.class);
		toolTips = PageFactory.initElements(driver, ToolTipsPage.class);

		home.getWidgets();
		sidePanel.selectToolTips();
	}

	@Test
	public void hoverToolTipsWithAttributeTest() {
		toolTips.hoverToolTipsWithAttribute();
	}

	@Test
	public void toolTipsWithTextTest() {
		toolTips.hoverOnInputToSee();
	}
}
