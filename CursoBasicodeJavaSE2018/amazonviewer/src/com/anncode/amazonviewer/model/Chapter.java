package com.anncode.amazonviewer.model;

import java.util.ArrayList;

public class Chapter extends Movie {

	private Serie serie;

	public Chapter(String title, String genre, String creator, int duration, short year, Serie serie) {
		super(title, genre, creator, duration, year);
		// TODO Auto-generated constructor stub
		this.setSerie(serie);
	}
	
	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	@Override
	public String toString() {
		return  "\n :: SERIE ::" +
				"\n Title: " + getSerie().getTitle() +
				"\n :: CHAPTER ::" + 
				"\n Title: " + getTitle() +
				"\n Year: " + getYear() + 
				"\n Creator: " + getCreator() +
				"\n Duration: " + getDuration();
	}
	
	
	public static ArrayList<Chapter> makeChaptersList(Serie serie) {
		ArrayList<Chapter> chapters = new ArrayList<>();
		
		for (int i = 1; i <= 5; i++) {
			chapters.add(new Chapter("Capituo "+i, "genero "+i, "creator" +i, 45, (short)(2017+i), serie));
		}
		
		return chapters;
	}
}
