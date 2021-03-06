package com.anncode.amazonviewer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.anncode.amazonviewer.model.Book;
import com.anncode.amazonviewer.model.Chapter;
import com.anncode.amazonviewer.model.Magazine;
import com.anncode.amazonviewer.model.Movie;
import com.anncode.amazonviewer.model.Serie;
import com.sc.makereport.*;
import com.anncode.util.AmazonUtil;

public class Main {

	public static void main(String[] args) {
		showMenu();
	}
	
	public static void showMenu() {
		int exit = 0;
		do {
			
			System.out.println("BIENVENIDOS AMAZON VIEWER");
			System.out.println();
			System.out.println("Selecciona el número de la opción deseada");
			System.out.println("1. Movies");
			System.out.println("2. Series");
			System.out.println("3. Books");
			System.out.println("4. Magazines");
			System.out.println("5. Report");
			System.out.println("6. Report Today");
			System.out.println("0. Exit");
			
			//Leer la respuesta del usuario
			int response = AmazonUtil.validateUserResponseMenu(0, 6);

			switch (response) {
				case 0:
					//salir
					exit = 0;
					break;
				case 1:
					showMovies();
					break;
				case 2:
					showSeries();
					break;
				case 3:
					showBooks();
					break;
				case 4:
					showMagazines();
					break;
				case 5:
				try {
					makeReport();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					exit = 1;
					break;
				case 6:
					//Date date = new Date();
				try {
					makeReport(new Date());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					exit = 1;
					break;
	
				default:
					System.out.println();
					System.out.println("....¡¡Selecciona una opción!!....");
					System.out.println();
					exit = 1;
					break;
			}
			
			
		}while(exit != 0);
	}
	
	static ArrayList<Movie> movies = Movie.makeMoviesList();
	public static void showMovies() {
		int exit = 1;
		
		do {
			System.out.println();
			System.out.println(":: MOVIES ::");
			System.out.println();
			
			for (int i = 0; i < movies.size(); i++) { //1. Movie 1
				System.out.println(i+1 + ". " + movies.get(i).getTitle() + " Visto: " + movies.get(i).isViewed());
			}
			
			System.out.println("0. Regresar al Menu");
			System.out.println();
			
			//Leer Respuesta usuario
			int response = AmazonUtil.validateUserResponseMenu(0, movies.size());
			
			if(response == 0) {
				exit = 0;
				showMenu();
			}
			if (response > 0) {
				Movie movieSelected = movies.get(response-1);
				movieSelected.setViewed(true);
				Date startDate = movieSelected.startToSee(new Date());
				
				for (int i = 0; i < 100000; i++) {
					System.out.println("..........");
				}
				
				//Termine de verla
				movieSelected.stopToSee(startDate, new Date());
				System.out.println();
				System.out.println("Viste: " + movieSelected);
				System.out.println("Por: " + movieSelected.getTimeViewed() + " milisegundos");
			}
			
			
		}while(exit !=0);
		
	}
	static ArrayList<Serie> series = Serie.makeSeriesList();
	public static void showSeries() {
		int exit = 1;
		
		do {
			System.out.println();
			System.out.println(":: SERIES ::");
			System.out.println();
			
			for (int i = 0; i < series.size(); i++) { //1. Serie 1
				System.out.println(i+1 + ". " + series.get(i).getTitle() + " Visto: " + series.get(i).isViewed());
			}
			
			System.out.println("0. Regresar al Menu");
			System.out.println();
			
			//Leer Respuesta usuario
			int response = AmazonUtil.validateUserResponseMenu(0, series.size());
			
			if(response == 0) {
				exit = 0;
				showMenu();
			}
			
			if(response > 0) {
				showChapters(series.get(response-1).getChapters());
			}
			
			
		}while(exit !=0);
	}
	
	public static void showChapters(ArrayList<Chapter> chaptersOfSerieSelected) {
		int exit = 1;
		
		do {
			System.out.println();
			System.out.println(":: CHAPTERS ::");
			System.out.println();
			
			
			for (int i = 0; i < chaptersOfSerieSelected.size(); i++) { //1. Chapter 1
				System.out.println(i+1 + ". " + chaptersOfSerieSelected.get(i).getTitle() + " Visto: " + chaptersOfSerieSelected.get(i).isViewed());
			}
			
			System.out.println("0. Regresar al Menu");
			System.out.println();
			
			//Leer Respuesta usuario
			int response = AmazonUtil.validateUserResponseMenu(0, chaptersOfSerieSelected.size());
			
			if(response == 0) {
				exit = 0;
			}
			
			
			if(response > 0) {
				Chapter chapterSelected = chaptersOfSerieSelected.get(response-1);
				chapterSelected.setViewed(true);
				Date dateI = chapterSelected.startToSee(new Date());
				
				for (int i = 0; i < 100000; i++) {
					System.out.println("..........");
				}
				
				//Termine de verla
				chapterSelected.stopToSee(dateI, new Date());
				System.out.println();
				System.out.println("Viste: " + chapterSelected);
				System.out.println("Por: " + chapterSelected.getTimeViewed() + " milisegundos");
			}
		}while(exit !=0);
	}
	
	static ArrayList<Book> books= Book.makeBookList();
	public static void showBooks() {
		int exit = 1;
		
		do {
			System.out.println();
			System.out.println(":: BOOKS ::");
			System.out.println();
			
			for (int i = 0; i < books.size(); i++) { //1. Book 1
				System.out.println(i+1 + ". " + books.get(i).getTitle() + " Leído: " + books.get(i).isRead());
			}
			
			System.out.println("0. Regresar al Menu");
			System.out.println();
			
			//Leer Respuesta usuario
			int response = AmazonUtil.validateUserResponseMenu(0, books.size());
			
			if(response == 0) {
				exit = 0;
				showMenu();
			}
			
			if(response > 0) {
				Book bookSelected = books.get(response-1);
				bookSelected.setAlreadyRead(true);
				Date dateI = bookSelected.startToSee(new Date());
				
				for (int i = 0; i < 100000; i++) {
					System.out.println("..........");
				}
				
				//Termine de verla
				bookSelected.stopToSee(dateI, new Date());
				System.out.println();
				System.out.println("Leíste: " + bookSelected);
				System.out.println("Por: " + bookSelected.getTimeRead() + " milisegundos");
			}
			
		}while(exit !=0);
	}
	
	public static void showMagazines() {
		 ArrayList<Magazine> magazines = Magazine.makeMagazineList();
		int exit = 1;
		do {
			System.out.println();
			System.out.println(":: MAGAZINES ::");
			System.out.println();
			
			for (int i = 0; i < magazines.size(); i++) { //1. Book 1
				System.out.println(i+1 + ". " + magazines.get(i).getTitle());
			}
			
			System.out.println("0. Regresar al Menu");
			System.out.println();
			
			//Leer Respuesta usuario
			int response = AmazonUtil.validateUserResponseMenu(0, magazines.size());
			
			if(response == 0) {
				exit = 0;
				showMenu();
			}
			if(response > 0) {
				Magazine magazineSelected = magazines.get(response-1);

				for (int i = 0; i < 3; i++) {
					System.out.println("..........");
				}

				//Termine de verla
				System.out.println();
				System.out.println("Leíste: " + magazineSelected);
			}
			
		}while(exit !=0);
	}
	
	public static void makeReport() throws IOException {
		
		Report report = new Report();
		report.setNameFile("reporte");
		report.setExtension("txt");
		report.setTitle(":: VISTOS ::");
		StringBuilder contentReport = new StringBuilder();
		
		for (Movie movie : movies) {
			if (movie.getIsViewed()) {
				contentReport.append(movie.toString()).append("\n");
				
			}
		}
		
		for (Serie serie : series) {
			ArrayList<Chapter> chapters = serie.getChapters();
			for (Chapter chapter : chapters) {
				if (chapter.getIsViewed()) {
					contentReport.append(chapter.toString()).append("\n");
					
				}
			}	
		}
		
		
		for (Book book : books) {
			if (book.getIsReaded()) {
				contentReport.append(book.toString()).append("\n");
				
			}
		}

		report.setContent(contentReport.toString());
		report.makeReport();
		System.out.println("Reporte Generado");
		System.out.println();
	}
	
	public static void makeReport(Date date) throws IOException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-h-m-s-S");
		String dateString = df.format(date);
		Report report = new Report();
		
		report.setNameFile("reporte" + dateString);
		report.setExtension("txt");
		report.setTitle(":: VISTOS ::");
		
		
		SimpleDateFormat dfNameDays = new SimpleDateFormat("E, W MMM y");
		dateString = dfNameDays.format(date);
		StringBuilder contentReport = new StringBuilder("Date: " + dateString + "\n\n\n");
		
		for (Movie movie : movies) {
			if (movie.getIsViewed()) {
				contentReport.append(movie.toString()).append("\n");
				
			}
		}
		
		for (Serie serie : series) {
			ArrayList<Chapter> chapters = serie.getChapters();
			for (Chapter chapter : chapters) {
				if (chapter.getIsViewed()) {
					contentReport.append(chapter.toString()).append("\n");
					
				}
			}
		}
		
		for (Book book : books) {
			if (book.getIsReaded()) {
				contentReport.append(book.toString()).append("\n");
				
			}
		}
		report.setContent(contentReport.toString());
		report.makeReport();
		
		System.out.println("Reporte Generado");
		System.out.println();
	}
	
}















