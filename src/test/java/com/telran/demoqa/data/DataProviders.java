package com.telran.demoqa.data;

import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

	@DataProvider
	public static Iterator<Object[]> newStudentFromCSV() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(
				DataProviders.class.getResourceAsStream("/Stundents.csv")));
		List<Object[]> userData = new ArrayList<Object[]>();
		String line = in.readLine();
		while (line != null) {
			userData.add(line.split(","));
			line = in.readLine();
		}
		in.close();
		return userData.iterator();
	}
}
