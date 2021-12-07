package com.telran.demoqa.tests;

import com.telran.demoqa.data.DataProviders;
import com.telran.demoqa.data.StudentData;
import com.telran.demoqa.pages.FormsPage;
import com.telran.demoqa.pages.MainPage;
import com.telran.demoqa.pages.SidePanelPage;
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
				.fillPersonalData(
						StudentData.FIRST_NAME,
						StudentData.LAST_NAME,
						StudentData.E_MAIL,
						StudentData.PHONE)
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

	@Test(dataProvider = "newStudent", dataProviderClass = DataProviders.class)
	public void fillStudentRegFormFromDataProviderTest(
			String fName, String lName, String email, String phone,
			String gend, String bDay, String[] subj, String[] hobb, String file,
			String addr, String state, String city) {
		new FormsPage(driver)
				.fillPersonalData(fName, lName, email, phone)
				.selectGender(gend)
				.typeOfDate(bDay)
				.addSubject(subj)
				.chooseHobbies(hobb)
				.uploadFile(file);
//				.typeAddress(addr)
//				.inputState(state)
//				.inputCity(city)
//				.clickOnSubmitButton();
//		new FormsPage(driver).closeSuccessDialog();
	}

//	@Test(dataProvider = "newStudentFromCSV", dataProviderClass = DataProviders.class)
//	public void fillStudentRegFormFromCSVTest(StudentData student) {
//		new FormsPage(driver)
//				.fillPersonalData(student)
//				.selectGender(gend)
//				.typeOfDate(bDay)
//				.addSubject(subj)
//				.chooseHobbies(hobb)
//				.uploadFile(file);
//				.typeAddress(addr)
//				.inputState(state)
//				.inputCity(city)
//				.clickOnSubmitButton();
//		new FormsPage(driver).closeSuccessDialog();
//	}
}
