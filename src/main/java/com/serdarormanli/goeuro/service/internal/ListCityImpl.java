package com.serdarormanli.goeuro.service.internal;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.csv.CSVFormat;

import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

import com.serdarormanli.goeuro.model.City;
import com.serdarormanli.goeuro.model.Template;
import com.serdarormanli.goeuro.service.api.GoEuroService;

public class ListCityImpl implements ListCity {

	private static final String BASE_URL = "http://api.goeuro.com";

	private static final Retrofit GO_EURO_SERVICE_BASE = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

	private static final GoEuroService GO_EURO_SERVICE = GO_EURO_SERVICE_BASE.create(GoEuroService.class);

	@Override
	public List<City> listCity(String cityName) throws IOException {
		Response<List<City>> response = GO_EURO_SERVICE.listCity(cityName).execute();

		List<City> cities = response.body();

		if (cities.size() < 1) {
			throw new IllegalStateException("No result found for " + cityName);
		}

		return cities;
	}

	@Override
	public CSVFormat getCSVFormat() {
		return CSVFormat.DEFAULT.withDelimiter(';').withRecordSeparator(System.lineSeparator());
	}

	@Override
	public String getFileName(String cityName, String fileName) {
		if (fileName == null || fileName.length() < 1) {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			fileName = cityName + "_" + format.format(new Date()) + ".csv";
		}

		return fileName;
	}

	@Override
	public List<Template<City>> getTemplates() {
		List<Template<City>> template = new ArrayList<Template<City>>();

		template.add(new Template<City>("id") {
			@Override
			public String getField(City value) {
				return value.getId().toString();
			}
		});

		template.add(new Template<City>("name") {
			@Override
			public String getField(City value) {
				return value.getName();
			}
		});

		template.add(new Template<City>("type") {
			@Override
			public String getField(City value) {
				return value.getType();
			}
		});

		template.add(new Template<City>("latitude") {
			@Override
			public String getField(City value) {
				return value.getGeoPosition().getLatitude().toString();
			}
		});

		template.add(new Template<City>("longitude") {
			@Override
			public String getField(City value) {
				return value.getGeoPosition().getLongitude().toString();
			}
		});

		return template;
	}
}
