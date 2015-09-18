package com.serdarormanli.goeuro.model;

/***
 * Template class to define header name and how to get field value
 * 
 * @author ormanli
 *
 */
public abstract class Template<T> {
	private final String header;

	public Template(String header) {
		this.header = header;
	}

	public String getHeader() {
		return header;
	}

	public abstract String getField(T value);

}
