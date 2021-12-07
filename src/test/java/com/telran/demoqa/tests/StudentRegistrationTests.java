package com.telran.demoqa.tests;

import com.telran.demoqa.data.StudentData;
import com.telran.demoqa.helpers.DataProviders;
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
				.fillPersonalData(
						StudentData.FIRST_NAME,
						StudentData.LAST_NAME,
						StudentData.E_MAIL,
						StudentData.PHONE)
				.selectGender(StudentData.GENDER)
//				.typeOfDate(StudentData.B_DAY)
				.chooseDate("September", "1987", "5")
				.addSubject(StudentData.SUBJECTS)
				.chooseHobbies(StudentData.HOBBIES)
				.uploadFile(StudentData.FILE)
				.typeAddress(StudentData.ADDRESS)
				.inputState(StudentData.STATE)
				.inputCity(StudentData.CITY)
				.clickOnSubmitButton();
		Assert.assertTrue(new FormsPage(driver)
				.getTitleFormDialog()
				.contains("Thanks for submitting the form"));
		new FormsPage(driver).closeSuccessDialog();
	}

	@Test(dataProvider = "newStudentFromCSV", dataProviderClass = DataProviders.class)
	public void fillStudentRegFormFromWithDataProviderCSVTest(
			String fName, String lName, String email, String phone,
			String file,  String addr, String state, String city) {
		new FormsPage(driver)
				.fillPersonalData(fName, lName, email, phone)
				.selectGender(StudentData.GENDER)
				.chooseDate("September", "1987", "5")
				.addSubject(StudentData.SUBJECTS)
				.chooseHobbies(StudentData.HOBBIES)
				.uploadFile(file)
				.typeAddress(addr)
				.inputState(state)
				.inputCity(city)
				.clickOnSubmitButton();
		new FormsPage(driver).closeSuccessDialog();
	}
}
