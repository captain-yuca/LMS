package main;

import java.util.GregorianCalendar;

public class Book {
	//Book has an author, description, ISBN, publisher, category and date published.
	private String title;
	private String author;
	private String description;
	private String ISBN;
	private String publisher;
	private String category;
	private GregorianCalendar publishDate;
	
	public Book(String title, String author, String description, String ISBN, String publisher, String category, int year, int month, int date){
		this.title=title;
		this.author=author;
		this.description=description;
		this.ISBN=ISBN;
		this.category=category;
		this.publishDate = new GregorianCalendar(year, month, date);
	}
	
	/*-------------------*/
	/*Getters and Setters*/
	/*-------------------*/
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}
	public int getDate(){
		
		return this.publishDate.get(0);
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public GregorianCalendar getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(GregorianCalendar publishDate) {
		this.publishDate = publishDate;
	}
	
}
