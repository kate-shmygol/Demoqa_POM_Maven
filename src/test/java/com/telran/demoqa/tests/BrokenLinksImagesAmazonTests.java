package com.telran.demoqa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrokenLinksImagesAmazonTests {

	WebDriver driver;

	@BeforeMethod
	public void ensurePreconditions() {
		driver = new ChromeDriver();
		driver.navigate().to("https://www.amazon.de");
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void getAllLinksAmazonTest() {
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		String url = "";
		System.out.println("Total links on the web page: " + allLinks.size());
		Iterator<WebElement> iterator = allLinks.iterator();
		while (iterator.hasNext()) {
			url = iterator.next().getText();
			System.out.println(url);
		}
	}

	@Test
	public void getBrokenLinksAmazonTest() {
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		for (int i = 0; i < allLinks.size(); i++) {
			WebElement element = allLinks.get(i);
			String url = element.getAttribute("href");
			verifyLinks(url);
		}
	}

	@Test
	public void getBrokenImagesAmazonTest() {
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println("We have " + images.size() + " images");

		for (int index = 0; index < images.size(); index++) {
			WebElement img = images.get(index);
			String imageURL = img.getAttribute("src");
			System.out.println("URL of Image " + (index + 1) + " is: " + imageURL);
			verifyLinks(imageURL);

			try {
				boolean imageDisplayed = (boolean) ((JavascriptExecutor) driver)
						.executeScript("return (typeof arguments[0].naturalWith != undefined && arguments[0].naturalWidth > 0);", img);
				if (imageDisplayed) {
					System.out.println("DISPLAY - OK");
					System.out.println("******************************");
				} else {
					System.out.println("DISPLAY - BROKEN");
					System.out.println("******************************");
				}
			} catch (Exception e) {
				System.out.println("ERROR");
			}
		}
	}

	private void verifyLinks(String linkUrl) {
		try {
			URL url = new URL(linkUrl);
			HttpURLConnection httpURL = (HttpURLConnection) url.openConnection();
			httpURL.setConnectTimeout(5000);
			httpURL.connect();
			if (httpURL.getResponseCode() >= 400) {
				System.out.println(linkUrl + " - " + httpURL.getResponseMessage() + " is a broken link ");
			} else {
				System.out.println(linkUrl + " - " + httpURL.getResponseMessage());
			}
		} catch (Exception e) {
			System.out.println(linkUrl + " - " + e.getMessage() + " broken link ");
		}
	}

	@AfterMethod(enabled = false)
	public void tearDown() {
		driver.quit();
	}
}
