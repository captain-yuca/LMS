package main;

public class User {
	
	
	
	private String username;
	private Password password;
	private boolean isAdmin;
	
	public User(String username, String password, boolean isAdmin){
		this.username = username;
		this.password = new Password(password);
		this.isAdmin = isAdmin;
		
	}
	public User(String username, String password){
		this.username = username;
		this.password = new Password(password);
		this.isAdmin = false;
		
	}
	
	public Password getPassword(){
		return this.password;
	}
	
	public String getPasswordString(){
		return this.getPassword().getPassword();
	}
	
	public String getUsername(){
		return this.username;
	}
	
}
