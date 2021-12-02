package com.telran.demoqa.tests.bookStoreTests;

import com.telran.demoqa.data.BookData;
import com.telran.demoqa.pages.bookStorePages.BookStorePage;
import com.telran.demoqa.pages.MainPage;
import com.telran.demoqa.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchBookTests extends TestBase {

	@BeforeMethod
	public void ensurePreconditions() {
		new MainPage(driver).getBookStore();
	}

	@Test
	public void searchBookPositiveTest() {
		new BookStorePage(driver).typeInSearchFieldInput(BookData.BOOK_NAME);
		Assert.assertTrue(new BookStorePage(driver).takeNameOfBook().contains(BookData.BOOK_NAME));
	}

	@Test
	public void verifyEmptyFieldTest() {
		new BookStorePage(driver).typeInSearchFieldInput("  ");
		Assert.assertTrue(new BookStorePage(driver).verifyEmptyField().contains(""));
	}
}
