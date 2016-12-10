package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BackendService {
	ArrayList<User> users = new ArrayList<User>();
	ArrayList<Book> books = new ArrayList<Book>();
	Scanner reader;
	File userFile = new File("./files/users.txt");
	File booksFile = new File("./files/books.txt");
	
	public BackendService(){
		this.downloadBooks();
		this.downloadUsers();
	}
	
	public ArrayList<User> getUsers(){
		return this.users;
	}
	
	public ArrayList<Book> getBooks(){
		return this.books;
	}
	
	private void downloadBooks(){
		
		try {
			reader= new Scanner(this.booksFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//Book has a title, author, description, ISBN, publisher, category and date published.

		reader.useDelimiter(";");
		Book newBook;
		while(reader.hasNextLine()){
			
			//Maps the text file to values of a book class
			String title = reader.next();
			String author = reader.next();
			String description = reader.next();
			String ISBN = reader.next();
			String publisher = reader.next();
			String category = reader.next();
			int year = reader.nextInt();
			int month = reader.nextInt();
			int date = reader.nextInt();
			
			//Creates a new Book object with these values
			newBook = new Book(title, author, description, ISBN, publisher, category, year, month, date);
			reader.nextLine();
			
			//Adds the book to the array
			books.add(newBook);
			
		}
		reader.close();
	}
	
	private void downloadUsers(){
		
		try {
			reader= new Scanner(this.userFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//Book has a title, author, description, ISBN, publisher, category and date published.

		reader.useDelimiter(";");
		User newUser;
		while(reader.hasNextLine()){
			String username = reader.next();
			String password = reader.next();
			String isAdminString = reader.next(); 
			
			boolean isAdmin = isAdminString.equals("true")? true: false;

			newUser = new User(username, password, isAdmin);
			reader.nextLine();
			users.add(newUser);
			
		}
		reader.close();
		
	}
	
	public User findUser(String username) throws Exception {
		for(User currentUser: this.users){
			if(currentUser.getUsername().equals(username)){
				return currentUser;
			}
		}throw new Exception("Could not find User Name");
		
		
	}
	

}
