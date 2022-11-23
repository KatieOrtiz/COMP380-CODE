package code0.ecommercesite;
import java.io.*;
import java.util.*;

public class readfile{
    //set variables
	private Scanner x;
    String a;
    String b;
    String c;
    String d;
    String e;
    String f;
    String g;
    //opens file
	public void openFile(){
		try{
			x = new Scanner(new File("files/user.txt"));
		}
		catch(Exception e){
			System.out.println("could not find file");
		}
	}
    //puts the first strings from file into variables, namely username, password and first/last name
	public void readFile(){
		 a = x.next();
         b = x.next();
         c = x.next();
         d = x.next();
         e = x.next();
         f = x.next();
         g = x.next();
	}   


    
    /** 
     * Gets the first piece of data from the user.txt file, which is the username.
     * @return String returns the variable that is found, which is the username
     */
    //return found variables
    public String getA(){
        return a;
    }

    
    /** 
     * Gets the first piece of data from the user.txt file, which is the password.
     * @return String returns the variable that is found, which is the password
     */
    public String getB(){
        return b;
    }

    
    /** 
     * Gets the first piece of data from the user.txt file, which is the name.
     * @return String returns the variable that is found, which is the name
     */
    public String getC(){
        return c;
    }
    
    /** 
     * Gets the first piece of data from the user.txt file, which is the email.
     * @return String returns the variable that is found, which is the email
     */
    public String getD(){
        return d;
    }

    
    /** 
     * Gets the first piece of data from the user.txt file, which is the note.
     * @return String returns the variable that is found, which is the note
     */
    public String getE(){
        return e;
    }

    
    /** 
     * Gets the first piece of data from the user.txt file, which is the birthday.
     * @return String returns the variable that is found, which is the birthday
     */
    public String getF(){
        return f;
    }

    
    /** 
     * Gets the first piece of data from the user.txt file, which is the profession.
     * @return String returns the variable that is found, which is the profession
     */
    public String getG(){
        return g;
    }
    //being polite, close file after used
    public void closeFile(){
        x.close();
    }
}