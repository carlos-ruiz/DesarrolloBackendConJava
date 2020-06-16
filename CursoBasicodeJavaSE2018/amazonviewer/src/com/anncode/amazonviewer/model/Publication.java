package com.anncode.amazonviewer.model;

import java.util.Date;

public class Publication {
	
	private final String title;
	private final Date editionDate;
	private final String editorial;
	private String[] authors;

	public Publication(String title, Date editionDate, String editorial) {
		super();
		this.title = title;
		this.editionDate = editionDate;
		this.editorial = editorial;
	}
	
	public String getTitle() {
		return title;
	}

	public Date getEditionDate() {
		return editionDate;
	}

	public String getEditorial() {
		return editorial;
	}

	public String[] getAuthors() {
		return authors;
	}
	public void setAuthors(String[] authors) {
		this.authors = authors;
	}
	
	

}
