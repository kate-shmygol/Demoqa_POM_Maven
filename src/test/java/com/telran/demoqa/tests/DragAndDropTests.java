package com.telran.demoqa.tests;

import com.telran.demoqa.pages.DragAndDropPage;
import com.telran.demoqa.pages.MainPage;
import com.telran.demoqa.pages.SidePanelPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropTests extends TestBase {

	@BeforeMethod
	public void ensurePreconditions() {
		new MainPage(driver).getInteractions();
		new SidePanelPage(driver).selectDroppable();
	}

	@Test
	public void droppableTest() {
		new DragAndDropPage(driver).actionDragMe();
	}

	@Test
	public void droppableByTest() {
		new DragAndDropPage(driver).dragAndDropBy();
	}

	@Test
	public void dropByTest() {
		new DragAndDropPage(driver).dragAndDropBy100();
	}

	@Test
	public void dropAcceptTest() {
		new DragAndDropPage(driver).dragAndDropAccept();
		new DragAndDropPage(driver).dragAndDropNotAccept();
	}

//	@Test
//	public void dropRevertTest() {
//		new DragAndDropPage(driver).dragAndDropWillRevert();
//		new DragAndDropPage(driver).dragAndDropNotRevert();
//	}
}
