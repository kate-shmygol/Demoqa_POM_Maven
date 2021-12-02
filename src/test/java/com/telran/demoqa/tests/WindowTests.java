package com.telran.demoqa.tests;

import com.telran.demoqa.pages.MainPage;
import com.telran.demoqa.pages.SidePanelPage;
import com.telran.demoqa.pages.WindowPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowTests extends TestBase {

	@BeforeMethod
	public void ensurePreconditions() {
		new MainPage(driver).getAlertsFrameAndWindows();
		new SidePanelPage(driver).selectBrowserWindows();
	}

	@Test
	public void newTabTest() {
		new WindowPage(driver).clickOnNewTabButton();
		Assert.assertTrue(new WindowPage(driver).getTextFromNewTab()
				.contains("sample"));
	}

	@Test
	public void newWindowTest() {
		new WindowPage(driver).clickOnNewWindowButton();
		Assert.assertTrue(new WindowPage(driver).getTextFromNewTab()
				.contains("sample"));
	}

	@Test
	public void newWindowMessageTest() throws InterruptedException {
		new WindowPage(driver).clickOnNewWindowMessageButton();
//		new WindowPage(driver).getTextFromNewWindow();

//		Assert.assertTrue(new WindowPage(driver).getTextFromNewWindow()
//				.contains("sharing"));
	}


}
