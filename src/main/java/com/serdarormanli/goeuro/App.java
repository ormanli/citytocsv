package com.serdarormanli.goeuro;

import java.io.FileWriter;
import java.util.List;

import org.apache.log4j.Logger;

import com.serdarormanli.goeuro.model.City;
import com.serdarormanli.goeuro.service.external.ResultToCsv;
import com.serdarormanli.goeuro.service.internal.ListCity;
import com.serdarormanli.goeuro.service.internal.ListCityImpl;

public class App {
	private final static Logger logger = Logger.getLogger(App.class);

	public static void main(String[] args) {
		try {
			if (args.length < 1) {
				throw new IllegalArgumentException("Enter an argument");
			}

			String cityName = args[0];

			if (cityName == null || cityName.length() < 1) {
				throw new IllegalArgumentException("Enter an city name");
			}

			String fileName = null;

			if (args.length > 1) {
				fileName = args[1];
			}

			ListCity listCity = new ListCityImpl();
			List<City> cities = listCity.listCity(cityName);

			ResultToCsv<City> resultToCsv = new ResultToCsv<City>(listCity.getCSVFormat(), new FileWriter(listCity.getFileName(cityName, fileName)), listCity.getTemplates(), cities);

			resultToCsv.print();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
}
