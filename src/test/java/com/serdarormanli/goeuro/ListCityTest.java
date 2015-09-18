package com.serdarormanli.goeuro;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.serdarormanli.goeuro.model.City;
import com.serdarormanli.goeuro.service.external.ResultToCsv;
import com.serdarormanli.goeuro.service.internal.ListCity;
import com.serdarormanli.goeuro.service.internal.ListCityImpl;

public class ListCityTest {

	@Test
	public void givenNameTest() throws Exception {
		ListCity listCity = new ListCityImpl();

		String fileName = listCity.getFileName("Berlin", "test.csv");

		assertEquals(fileName, "test.csv");
	}

	@Test
	public void parseResultTest() throws Exception {
		List<City> mockList = getMockBerlinList();

		assertTrue(mockList.size() > 0);
	}

	@Test
	public void writeToFileTest() throws Exception {
		ListCity listCity = new ListCityImpl();

		Writer mockWriter = mock(Writer.class);

		ResultToCsv<City> resultToCsv = new ResultToCsv<City>(listCity.getCSVFormat(), mockWriter, listCity.getTemplates(), getMockBerlinList());

		resultToCsv.print();
	}

	private List<City> getMockBerlinList() throws IOException {
		try (InputStream is = getClass().getResourceAsStream("/result.json")) {
			Type listType = new TypeToken<ArrayList<City>>() {
			}.getType();

			Reader br = new InputStreamReader(is);
			Gson gson = new Gson();
			List<City> cities = gson.fromJson(br, listType);

			ListCity mockedList = mock(ListCity.class);

			when(mockedList.listCity("Berlin")).thenReturn(cities);

			List<City> mockList = mockedList.listCity("Berlin");
			return mockList;
		}
	}
}
