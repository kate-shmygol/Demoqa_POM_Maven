package com.telran.demoqa.tests;

import com.telran.demoqa.data.StudentData;
import com.telran.demoqa.data.UserData;
import com.telran.demoqa.pages.ElementsPage;
import com.telran.demoqa.pages.FormsPage;
import com.telran.demoqa.pages.MainPage;
import com.telran.demoqa.pages.SidePanelPage;
import com.telran.demoqa.pages.bookStorePages.BookStorePage;
import org.testng.annotations.Test;

public class JsExecutorTests extends TestBase {

	@Test
	public void executorTest() {
		new MainPage(driver).getElementsPage();
		new SidePanelPage(driver).selectTextBox();
		new ElementsPage(driver)
				.typeUserDataWithJS(UserData.USER_NAME, StudentData.E_MAIL)
				.clickOnSubmitWithJS();
	}

	@Test
	public void checkBoxAndAlertsWithJSTest() {
		new MainPage(driver).getForms();
		new SidePanelPage(driver).selectPracticeForm();
		new FormsPage(driver)
				.checkBoxJS()
//				.alertWithJS()
				.refreshBrowserJS()
				.getTitlePageWithJS();
	}

	@Test
	public void getTitleAndUrlWithJSTest() {
		new MainPage(driver).getBookStore();
		new FormsPage(driver)
				.getTitlePageWithJS()
				.getUrlWithJS()
				.getTitlePageWithJS();
	}
}
