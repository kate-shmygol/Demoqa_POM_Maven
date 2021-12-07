package com.telran.demoqa.data;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

	@DataProvider
	public Iterator<Object[]> newStudent() {

		List<Object[]> list = new ArrayList<>();
		list.add(new Object[]{
				StudentData.FIRST_NAME,
				StudentData.LAST_NAME,
				StudentData.E_MAIL,
				StudentData.PHONE,
				StudentData.GENDER,
				StudentData.B_DAY,
				StudentData.SUBJECTS,
				StudentData.HOBBIES,
				StudentData.FILE
//				StudentData.ADDRESS
//				StudentData.STATE
//				StudentData.CITY
		});

		return list.iterator();
	}

	@DataProvider
	public Iterator<Object[]> newStudentFromCSV() throws IOException {

		List<Object[]> list = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/Stundents.csv")));

		String line = reader.readLine();

		while (line != null) {

			String[] split = line.split(",");

			list.add(new Object[]{
//					StudentData.FIRST_NAME(split[0]),
					StudentData.LAST_NAME,
					StudentData.E_MAIL,
					StudentData.PHONE,
					StudentData.GENDER,
					StudentData.B_DAY,
					StudentData.SUBJECTS,
					StudentData.HOBBIES,
					StudentData.FILE
//				StudentData.ADDRESS
//				StudentData.STATE
//				StudentData.CITY});
			});

			line = reader.readLine();
		}

		return list.iterator();
	}
}
