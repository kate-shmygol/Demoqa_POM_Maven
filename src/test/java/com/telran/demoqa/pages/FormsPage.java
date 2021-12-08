package com.telran.demoqa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class FormsPage extends PageBase {
	JavascriptExecutor js;

	public FormsPage(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor) driver;
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
			pause(1000);
			dateOfBirthBtn.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.CONTROL + Keys.DELETE));
			pause(1000);
//			dateOfBirthBtn.click();
//			dateOfBirthBtn.clear();
//			dateOfBirthBtn.click();
		} else {
//			clearWebField(dateOfBirthBtn);
			dateOfBirthBtn.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		}
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('dateOfBirthInput').value='23 Mar 1993';");
//		jse.executeScript("document.getElementById('dateOfBirthInput').setAttribute('value', '23 Mar 1993')");
//		dateOfBirthBtn.sendKeys(bDay);
		pause(1000);
		dateOfBirthBtn.sendKeys(Keys.ENTER);
		return this;
	}

	@FindBy(css = ".react-datepicker__month-select")
	WebElement month;

	@FindBy(css = ".react-datepicker__year-select")
	WebElement year;

	public FormsPage chooseDate(String mo, String ye, String day) {
		clickWithJSExecutor(dateOfBirthBtn, 0, 200);
		Select select = new Select(month); // HTML <select> tag
		select.selectByVisibleText(mo);

		Select select1 = new Select(year); // HTML <select> tag
		select1.selectByVisibleText(ye);

		driver.findElement(By.xpath("//div[@class='react-datepicker__week']//div[.='" + day + "']")).click();

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

	@FindBy(id = "currentAddress")
	WebElement addr;

	public FormsPage typeAddress(String address) {
		typeWithJSExecutor(addr, 0, 300, address);
		return this;
	}

	@FindBy(id = "state")
	WebElement state;

	@FindBy(id = "react-select-3-input")
	WebElement selectState;

	public FormsPage inputState(String st) {
		clickWithJSExecutor(state, 0, 300);
		selectState.sendKeys(st);
		selectState.sendKeys(Keys.ENTER);
		return this;
	}

	@FindBy(id = "city")
	WebElement city;

	@FindBy(id = "react-select-4-input")
	WebElement selectCity;

	public FormsPage inputCity(String c) {
		click(city);
		selectCity.sendKeys(c);
		selectCity.sendKeys(Keys.ENTER);
		return this;
	}

	@FindBy(id = "submit")
	WebElement submit;

	public FormsPage clickOnSubmitButton() {
		click(submit);
		return this;
	}

	@FindBy(id = "example-modal-sizes-title-lg")
	WebElement modalTitle;

	@FindBy(id = "closeLargeModal")
	WebElement closeBtn;

	public String getTitleFormDialog() {
		return modalTitle.getText();
	}

	public FormsPage closeSuccessDialog() {
		closeBanner();
		clickWithJSExecutor(closeBtn, 0, 300);
		return this;
	}

	public FormsPage checkBoxJS() {
		// to handle checkbox
		js.executeScript("document.getElementById('hobbies-checkbox-1').checked=false;");
		js.executeScript("document.getElementById('hobbies-checkbox-1').checked=true;");
		return this;
	}

	public FormsPage alertWithJS() {
		// to generate Alert Pop-up window
		js.executeScript("alert('hello server');");
//		js.executeScript("window.confirm = function() { return true; }");
//		js.executeScript("arguments[0].click()", hrefCID);
		return this;
	}

	public FormsPage refreshBrowserJS() {
		// refresh browser window using JSE
		js.executeScript("history.go(0)");
		return this;
	}

	public FormsPage getTitlePageWithJS() {
		// to get the Title of our page
		pause(2000);
		String text = js.executeScript("return document.title;").toString();
		System.out.println("***********************" + "\n" + text);
		return this;
	}

	public FormsPage getUrlWithJS() {
		String urlText = js.executeScript("return document.URL;").toString();
		System.out.println("URL ---> " + urlText);
		return this;
	}
}
