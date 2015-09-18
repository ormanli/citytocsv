package com.serdarormanli.goeuro.service.internal;

import java.io.IOException;
import java.util.List;

import org.apache.commons.csv.CSVFormat;

import com.serdarormanli.goeuro.model.City;
import com.serdarormanli.goeuro.model.Template;

public interface ListCity {

	/**
	 * Gets template which implements logic of transfer
	 * 
	 * @return
	 */
	public List<Template<City>> getTemplates();

	/**
	 * Gets poi of given city
	 * 
	 * @param cityName
	 * @return
	 * @throws IOException
	 */
	public List<City> listCity(String cityName) throws IOException;

	/**
	 * Gets {@link CSVFormat} of this operation
	 * 
	 * @return
	 */
	public CSVFormat getCSVFormat();

	/**
	 * Gets fileName of result
	 * 
	 * @param cityName
	 * @param fileName
	 * @return
	 */
	public String getFileName(String cityName, String fileName);

}
