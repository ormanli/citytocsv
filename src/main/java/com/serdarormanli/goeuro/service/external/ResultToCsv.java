package com.serdarormanli.goeuro.service.external;

import java.io.IOException;
import java.io.Writer;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import com.serdarormanli.goeuro.model.Template;

/***
 * Prints result to file
 * 
 * @author ormanli
 *
 */
public class ResultToCsv<T> implements ResultToFile {
	private final CSVFormat csvFileFormat;
	private final Writer writer;
	private final List<Template<T>> templates;
	private final List<T> result;

	public ResultToCsv(CSVFormat csvFileFormat, Writer writer, List<Template<T>> templates, List<T> result) {
		this.csvFileFormat = csvFileFormat;
		this.writer = writer;
		this.templates = templates;
		this.result = result;
	}

	@Override
	public void print() throws IOException {
		CSVPrinter csvFilePrinter = null;
		try {
			String[] header = new String[templates.size()];

			for (int i = 0; i < templates.size(); i++) {
				header[i] = templates.get(i).getHeader();
			}

			csvFilePrinter = new CSVPrinter(writer, csvFileFormat.withHeader(header));

			List<String> row = null;

			for (T record : result) {
				row = new LinkedList<String>();

				for (Template<T> string : templates) {
					row.add(string.getField(record));
				}

				csvFilePrinter.printRecord(row);
			}
		} finally {
			writer.flush();
			writer.close();
			csvFilePrinter.close();
		}
	}
}
