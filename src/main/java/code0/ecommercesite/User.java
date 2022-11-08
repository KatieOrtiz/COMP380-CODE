package code0.ecommercesite;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

import org.springframework.format.annotation.DateTimeFormat;

public class User {
	@Size(min = 3, max = 50)
	private String name;
	
	@NotBlank
	@Email(message = "Please enter a valid e-mail address")
	private String email;
	
	@NotBlank
	@Size(min = 8, max = 15)
	private String password;
	
	
	@Size(max = 100)
	private String note;

	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date birthday;
	
	@NotBlank
	private String profession;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	@Override
	public String toString() {
		try {
			FileWriter myWriter = new FileWriter("files/user.txt");
			myWriter.write("User [name=" + name + ", email=" + email + ", note="
			+ note + ", birthday=" + birthday + ", profession=" + profession + "]");
			
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		  } catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		  }

		return "User [name=" + name + ", email=" + email + ", password=" + password + ", note="
				+ note + ", birthday=" + birthday + ", profession=" + profession + "]";
	}


}