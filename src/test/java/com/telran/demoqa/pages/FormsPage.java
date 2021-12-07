package com.telran.demoqa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class FormsPage extends PageBase {
	public FormsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "firstName")
	WebElement firstName;

	@FindBy(id = "lastName")
	WebElement lastName;

	@FindBy(id = "userEmail")
	WebElement email;

	@FindBy(id = "userNumber")
	WebElement phone;

	public FormsPage fillPersonalData(String fName, String lName, String eM, String ph) {
		type(firstName, fName);
		type(lastName, lName);
		type(email, eM);
		type(phone, ph);
		return this;
	}

	@FindBy(xpath = "//label[@for='gender-radio-1']")
	WebElement maleBtn;

	@FindBy(xpath = "//label[@for='gender-radio-2']")
	WebElement femaleBtn;

	@FindBy(xpath = "//label[@for='gender-radio-3']")
	WebElement otherBtn;

	public FormsPage selectGender(String gender) {
		if (gender.equals("Male")) {
			click(maleBtn);
		} else if (gender.equals("Female")) {
			click(femaleBtn);
		} else {
			click(otherBtn);
		}
		return this;
	}

	@FindBy(id = "dateOfBirthInput")
	WebElement dateOfBirthBtn;

	public void clearWebField(WebElement element) {
		while (!element.getAttribute("value").equals("")) {
			element.sendKeys(Keys.BACK_SPACE);
		}
	}

	public void selectAndDeleteTextViaKeyboard() {
		selectTextViaKeyboard(dateOfBirthBtn);
		deleteViaKeyboard(dateOfBirthBtn);
	}

	public void deleteViaKeyboard(WebElement element) {
		Actions builder = new Actions(driver);
		builder.sendKeys(Keys.DELETE)
				.release().perform();
	}

	public void selectTextViaKeyboard(WebElement element) {
		Actions builder = new Actions(driver);
		Action select = builder
				.keyDown(Keys.CONTROL)
				.sendKeys("a")
				.keyUp(Keys.CONTROL)
				.build();
		select.perform();
	}

	public FormsPage typeOfDate(String bDay) {

		clickWithJSExecutor(dateOfBirthBtn, 0, 300); //		click(dateOfBirthBtn);
		String os = System.getProperty("os.name");
		System.out.println("OS: " + os);
		if (os.startsWith("Mac")) {
			dateOfBirthBtn.sendKeys(Keys.chord(Keys.COMMAND, "a"));
		} else if (os.startsWith("Linux")) {
//			clearWebField(dateOfBirthBtn);
//			selectAndDeleteTextViaKeyboard();
			pause(2000);
			dateOfBirthBtn.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.CONTROL + Keys.DELETE));
			pause(2000);
//			dateOfBirthBtn.click();
//			dateOfBirthBtn.clear();
//			dateOfBirthBtn.click();
		} else {
//			clearWebField(dateOfBirthBtn);
			dateOfBirthBtn.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		}
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("document.getElementById('dateOfBirthInput').value='23 Mar 1993';");
//		jse.executeScript("document.getElementById('dateOfBirthInput').setAttribute('value', '23 Mar 1993')");
//		dateOfBirthBtn.sendKeys(bDay);
		pause(2000);
		dateOfBirthBtn.sendKeys(Keys.ENTER);
		return this;
	}

	@FindBy(id = "subjectsInput")
	WebElement subjectsInput;

	@FindBy(id = "react-select-2-option-0")
	WebElement selectInput;

	public FormsPage addSubject(String[] subjects) {
		for (int i = 0; i < subjects.length; i++) {
			if (subjects[i] != null) {
				type(subjectsInput, subjects[i]);
				selectInput.click();
			}
		}
		return this;
	}

	@FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
	WebElement sports;

	@FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
	WebElement reading;

	@FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
	WebElement music;

	public FormsPage chooseHobbies(String[] hobbies) {
		for (int i = 0; i < hobbies.length; i++) {
			if (hobbies[i].equals("Sports")) {
				click(sports);
			}
			if (hobbies[i].equals("Reading")) {
				click(reading);
			}
			if (hobbies[i].equals("Music")) {
				click(music);
			}
		}
		return this;
	}

	@FindBy(id = "uploadPicture")
	WebElement chooseFile;

	public FormsPage uploadFile(String path) {
		chooseFile.sendKeys(path);
		pause(1000);
		return this;
	}
}
