package com.anncode.amazonviewer.model;

public class Film {
	
	private final String title;
	private final String genre;
	private final String creator;
	private final int duration;
	private short year;
	private boolean viewed;
	
	
	
	public Film(String title, String genre, String creator, int duration) {
		super();
		this.title = title;
		this.genre = genre;
		this.creator = creator;
		this.duration = duration;
	}
	
	public String getTitle() {
		return title;
	}

	public String getGenre() {
		return genre;
	}

	public String getCreator() {
		return creator;
	}

	public int getDuration() {
		return duration;
	}

	public short getYear() {
		return year;
	}
	public void setYear(short year) {
		this.year = year;
	}
	public String isViewed() {
		String viewed;
		if(this.viewed) {
			viewed = "Sí";
		}else {
			viewed = "No";
		}
		
		return viewed;
	}
	
	public boolean getIsViewed() {
		return viewed;
	}
	public void setViewed(boolean viewed) {
		this.viewed = viewed;
	}
	
	
	

}
