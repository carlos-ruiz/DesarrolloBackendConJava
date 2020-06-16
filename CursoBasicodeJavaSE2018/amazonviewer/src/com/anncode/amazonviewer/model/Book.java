package com.anncode.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

public class Book extends Publication implements IVisualizable {
	private boolean alreadyRead;
	private int timeRead;
	
	
	public Book(String title, Date editionDate, String editorial, String[] authors) {
		super(title, editionDate, editorial);
		// TODO Auto-generated constructor stub
		setAuthors(authors);
	}

	public String isRead() {
		String isRead;
		if(alreadyRead) {
			isRead = "Sí";
		}else {
			isRead = "No";
		}
		
		return isRead;
	}

	public void setAlreadyRead(boolean alreadyRead) {
		this.alreadyRead = alreadyRead;
	}
	
	public boolean getIsReaded() {
		return alreadyRead;
	}


	public int getTimeRead() {
		return timeRead;
	}


	public void setTimeRead(int timeRead) {
		this.timeRead = timeRead;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder detailBook = new StringBuilder("\n :: BOOK ::" +
				"\n Title: " + getTitle() +
				"\n Editorial: " + getEditorial() +
				"\n Edition Date: " + getEditionDate() +
				"\n Authors: ");
		for (int i = 0; i < getAuthors().length; i++) {
			detailBook.append("\t").append(getAuthors()[i]).append(" ");
		}
		return detailBook.toString();
	}


	@Override
	public Date startToSee(Date dateI) {
		// TODO Auto-generated method stub
		return dateI;
	}


	@Override
	public void stopToSee(Date dateI, Date dateF) {
		// TODO Auto-generated method stub
		if (dateF.getTime() > dateI.getTime()) {
			setTimeRead((int)(dateF.getTime() - dateI.getTime()));
		}else {
			setTimeRead(0);
		}
	}
	
	public static ArrayList<Book> makeBookList() {
		ArrayList<Book> books = new ArrayList<>();
		String[] authors = new String[3];
		for (int i = 0; i < 3; i++) {
			authors[i] = "author "+i;
		}
		for (int i = 1; i <= 5; i++) {
			books.add(new Book("Book " + i, new Date(), "editorial " + i, authors));
		}
		
		return books;
	}
	
}
