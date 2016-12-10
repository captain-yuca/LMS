package main;

import java.io.PrintStream;
import java.util.Scanner;

public class UserInterface {
	private Scanner input = new Scanner(System.in);
	private PrintStream out = System.out;
	private User currentUser;
	private BackendService backendService;
	
	
	public void init(){
		out.println("Welcome to our system!");
		this.backendService = new BackendService();
		this.logIn();
		this.mainMenu();
	}
	public void logIn(){
		String username;
		String password;
		boolean isNextStep = false;
		do{
			out.print("Enter your User Name: ");
			username = input.nextLine();
			try{
				currentUser=this.backendService.findUser(username);
				isNextStep=true;
			}catch(Exception e){
				out.println(e);
			}
		}while(!isNextStep);
		isNextStep=false;
		do{
			out.print("Enter your Password: ");
			password = input.nextLine();
			if(this.currentUser.getPasswordString().equals(password)){
				isNextStep=true;
			}
			else{
				out.println("Incorrect Password, Try Again");
			}
		}while(!isNextStep);
		
	}
	private void mainMenu(){
		int chosenOption =-1;
		do {
			out.println("\n\n(1)..Read Books");
			out.println("(0)..Exit");
			chosenOption = input.nextInt();
			switch(chosenOption){
			case 1: this.viewBooks();;
					break;
			case 0: out.println("Bye!");
					break;
			}
		}while(chosenOption!=0);
		
	}
	private void viewBooks(){
		out.println("|**Title**|**Author**|**Description**|**ISBN**|**Publisher**|**Category**|PublishDate|");
		String bookString;
		for(Book cB : this.backendService.getBooks()){
			bookString = cB.getTitle()+"|"+cB.getAuthor()+"|"+cB.getDescription()+"|"+cB.getISBN()+"|"+cB.getPublisher()+"|"+cB.getCategory()+"|"+cB.getDate()+"|";
			out.println(bookString);		
		}
	}
}
