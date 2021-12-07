package com.telran.demoqa.tests;

import com.telran.demoqa.data.StudentData;
import com.telran.demoqa.pages.FormsPage;
import com.telran.demoqa.pages.MainPage;
import com.telran.demoqa.pages.SidePanelPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StudentRegistrationTests extends TestBase {

	@BeforeMethod
	public void ensurePreconditions() {
		new MainPage(driver).getForms();
		new SidePanelPage(driver).selectPracticeForm();
	}

	@Test
	public void fillStudentRegFormTest() {
		new FormsPage(driver)
				.fillPersonalData(StudentData.FIRST_NAME, StudentData.LAST_NAME, StudentData.E_MAIL, StudentData.PHONE)
				.selectGender(StudentData.GENDER)
				.typeOfDate(StudentData.B_DAY)
				.addSubject(StudentData.SUBJECTS)
				.chooseHobbies(StudentData.HOBBIES)
				.uploadFile(StudentData.FILE);
//				.typeAddress(StudentData.ADDRESS)
//				.inputState(StudentData.STATE)
//				.inputCity(StudentData.CITY)
//				.clickOnSubmitButton();
//		Assert.assertTrue(new FormsPage(driver).getTitleFormDialog());
//		new FormsPage(driver).closeSuccessDialog();
	}
}
