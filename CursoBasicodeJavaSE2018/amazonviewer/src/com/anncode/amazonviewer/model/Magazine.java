package com.anncode.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

public class Magazine extends Publication {
	
	public Magazine(String title, Date edititionDate, String editorial) {
		super(title, edititionDate, editorial);
	}
	
	@Override
	public String toString() {
		StringBuilder detailMagazine = new StringBuilder("\n :: MAGAZINE ::" +
				"\n Title: " + getTitle() +
				"\n Editorial: " + getEditorial() +
				"\n Edition Date: " + getEditionDate() +
				"\n Authors: ");
		for (int i = 0; i < getAuthors().length; i++) {
			detailMagazine.append("\t").append(getAuthors()[i]).append(" ");
		}
		return detailMagazine.toString();
	}

	public static ArrayList<Magazine> makeMagazineList() {
		ArrayList<Magazine> magazines = new ArrayList<>();
		String[] authors = new String[3];
		for (int i = 0; i < 3; i++) {
			authors[i] = "author "+i;
		}
		for (int i = 1; i <= 5; i++) {
			Magazine magazine = new Magazine("Magazine " + i, new Date(), "Editorial " + i);
			magazine.setAuthors(authors);
			magazines.add(magazine);
		}
		
		return magazines;
	}

}
