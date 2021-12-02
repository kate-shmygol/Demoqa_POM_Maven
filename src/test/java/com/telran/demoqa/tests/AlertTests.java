package com.telran.demoqa.tests;

import com.telran.demoqa.pages.AlertPage;
import com.telran.demoqa.pages.MainPage;
import com.telran.demoqa.pages.SidePanelPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTests extends TestBase {

	@BeforeMethod
	public void ensurePreconditions() {
		new MainPage(driver).getAlertsFrameAndWindows();
		new SidePanelPage(driver).selectAlert();
	}

	@Test
	public void alertWaitTest() {
		new AlertPage(driver).clickTimerAlertBtn();
	}

	@Test
	public void cancelAlertTest() {
		new AlertPage(driver).clickAlertBtn3().clickOnConfirmButton("Cancel");
		Assert.assertTrue(new AlertPage(driver).getConfirmResult().contains("Cancel"));
	}

	@Test
	public void alertSendTextTest() {
		new AlertPage(driver).clickMessageAlertBtn().sendTextAlert("Hello World!");
		Assert.assertTrue(new AlertPage(driver).getConfirmMessageResult().contains("Hello"));
	}
}
