package code0.ecommercesite;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

import org.springframework.format.annotation.DateTimeFormat;

public class User {
	//create variables, and set size limits to each
	@Size(min = 3, max = 50) //size for the user's name is between 3 and 50 
	private String name; //variable for name
	
	@NotBlank //email field can't be blank
	@Email(message = "Please enter a valid e-mail address") //error message to display if the email address field is not valid or blank
	private String email; //variable for email
	
	@NotBlank //username field can't be blank
	@Size(min = 3, max = 20) //size for the username is between 3 and 20 
	private String username; //variable for username

	@NotBlank //password field can't be blank
	@Size(min = 8, max = 15) //size for the password is between 8 and 15 
	private String password; //variable for password
	
	
	@Size(max = 100) //size for the note has a max limit of 100
	private String note; //variable for note

	
	@DateTimeFormat(pattern = "yyyy-mm-dd") //format for the date and time 
	private Date birthday; //variable for birthday
	
	@NotBlank //profession field can't be blank
	private String profession; //variable for profession


	
	/** 
	 * Gets the name that is entered into the full name field on the user signup page.
	 * @return String returns the user's name
	 */
	//set or return variables when called
	public String getName() {
		return name;
	}

	
	/** 
	 * Sets the name that is retrieved from the signup form and sets it equal to the name class variable.
	 * @param name the name that will be set for the user's full name
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	/** 
	 * Gets the email that is entered into the email field on the user signup page.
	 * @return String returns the user's email
	 */
	public String getEmail() {
		return email;
	}

	
	/** 
	 * Sets the email that is retrieved from the signup form and sets it equal to the email class variable.
	 * @param email the email that will be set for the user's email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	
	/** 
	 * Gets the username that is entered into the username field on the user login page.
	 * @return String returns the user's username
	 */
	public String getUsername(){
		return username;
	}

	
	/**
	 * Sets the username that is retrieved from the login form and sets it equal to the username class variable. 
	 * @param username the username that will be set for the user's username
	 */
	public void setUsername(String username){
		this.username = username;
	}

	
	/** 
	 * Gets the password that is entered into the password field on the user signup page.
	 * @return String returns the user's password
	 */
	public String getPassword() {
		return password;
	}

	
	/** 
	 * Sets the password that is retrieved from the signup form and sets it equal to the password class variable.
	 * @param password the password that will be set for the user's password
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	
	/** 
	 * Gets the note that is entered into the note field on the user signup page.
	 * @return String returns the user's note
	 */
	public String getNote() {
		return note;
	}

	
	/** 
	 * Sets the note that is retrieved from the signup form and sets it equal to the note class variable.
	 * @param note the note that will be set for the user's note
	 */
	public void setNote(String note) {
		this.note = note;
	}

	
	/** 
	 * Gets the birthday that is entered into the birthday field on the user signup page.
	 * @return Date returns the user's birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	
	/** 
	 * Sets the birthday that is retrieved from the signup form and sets it equal to the birthday class variable.
	 * @param birthday the birthday that will be set for the user's birthday
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	
	/** 
	 * Gets the profession that is entered into the profession field on the user signup page.
	 * @return String returns the user's profession
	 */
	public String getProfession() {
		return profession;
	}

	
	/**
	 * Sets the profession that is retrieved from the signup form and sets it equal to the profession class variable. 
	 * @param profession the profession that will be set for the user's profession
	 */
	public void setProfession(String profession) {
		this.profession = profession;
	}

	
	/** 
	 * Creates a file and writes the user's details to the file and outputs the user's details to the console
	 * @return String returns the user's details 
	 */
	@Override
	public String toString() {
		try {
			//writes to user.txt the information inputted from signup
			FileWriter myWriter = new FileWriter("files/user.txt");
			myWriter.write("username= " + username + " password= " + password + " name= " + name + " email= " + email + " note= "
			+ note + " birthday= " + birthday + " profession= " + profession +  "]"); //write to the file
			
			myWriter.close(); //close the file

			//writes the name of person to name.txt the information inputted from signup
			FileWriter otherWriter = new FileWriter("files/name.txt");
			otherWriter.write(name); //write to the file
			otherWriter.close(); //close the file

			System.out.println("Successfully wrote to the file."); //writes the message to console if write to file was successful
		  } catch (IOException e) {
			System.out.println("An error occurred."); //writes the message to console if write to file failed
			e.printStackTrace();
		  }

		return "User [name=" + name + ", email=" + email + ", username=" + username + ", password=" + password + ", note="
				+ note + ", birthday=" + birthday + ", profession=" + profession +  "]";
	}


}