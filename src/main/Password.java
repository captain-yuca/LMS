package main;

public class Password {
	
	
	public static int STRONG = 1;
	public static int MEDIUM = 2;
	public static int WEAK = 3;
	public static int INVALID = 4;


	private String password;
	
	public Password(String password){
		this.password=password;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public boolean longEnough(int lengthParam){
		if(this.getPassword().length()>= lengthParam){
			return true;
		}
		return false;
	}
	
	public boolean containsOneOf(String characters){
		String currentCharacter;
		
		for(int i=0; i<characters.length() ; i++){
			currentCharacter = new String(characters.substring(i, i+1));
			if(this.getPassword().contains(currentCharacter)){
				return true;
			}
		}
		return false;
	}
	
	// boolean containsNoneOf(String chars) - returns true iff password does not contain any of the chars in the given String
	public boolean containsNoneOf(String characters){
		return !this.containsOneOf(characters);
	}
	
	// boolean containsUpperCase() - returns true iff password contains at least one upper case letter
	public boolean containsUpperCase(){
		String currentPassword = this.getPassword();
		String lowerCasePassword = this.getPassword().toLowerCase();
		
		return !currentPassword.equals(lowerCasePassword);
	}
	
	// boolean containsUpperCase() - returns true iff password contains at least one lower case letter
	public boolean containsLowerCase(){
		String currentPassword = this.getPassword();
		String upperCasePassword = this.getPassword().toUpperCase();
		
		return !currentPassword.equals(upperCasePassword);
	}
	
	// safetyLevel() - Returns:
		//                 Password.STRONG (int 1) if password has at least 10 chars, at least one upper and one lower case letter, at least one digit and at least one of "!@#$%^&*()"
		//                 Password.MEDIUM (int 2) if password has at least 8 chars, at least one upper and one lower case letter, and at least one digit
		//                 Password.WEAK (int 3) if password has at least 8 chars, at least one upper and one lower case letter, and at least one digit
		//                 Password.INVALID (int 4) if password has less than 8 chars OR at least of of the chars '.' or '/'
		
	public int safetyLevel(){
		if(this.containsOneOf("./")){
			return this.INVALID;
		}
		else if(this.longEnough(10) && this.containsUpperCase() && this.containsLowerCase() && this.containsOneOf("123456789") && this.containsOneOf("!@#$%^&*()")){
			return this.STRONG;
		}
		else if(this.longEnough(8) && this.containsUpperCase() && this.containsLowerCase() && this.containsOneOf("123456789") ){
			return this.MEDIUM;
		}
		else if(this.longEnough(8) && this.containsUpperCase() && this.containsLowerCase() || this.containsOneOf("123456789")){
			return this.WEAK;
		}
		else{
			return this.INVALID;
		}
		
	}
}
