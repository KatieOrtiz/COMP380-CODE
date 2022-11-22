package code0.ecommercesite;
import java.io.*;
import java.util.*;

public class readfile{
	private Scanner x;
    String a;
    String b;
    String c;
    String d;
    String e;
    String f;
    String g;
	public void openFile(){
		
		try{
			x = new Scanner(new File("files/user.txt"));
		}
		catch(Exception e){
			System.out.println("could not find file");
		}
	}

	public void readFile(){
		 a = x.next();
         b = x.next();
         c = x.next();
         d = x.next();
         e = x.next();
         f = x.next();
         g = x.next();
	}   

    public String getA(){
        return a;
    }

    public String getB(){
        return b;
    }

    public String getC(){
        return c;
    }
    public String getD(){
        return d;
    }

    public String getE(){
        return e;
    }

    public String getF(){
        return f;
    }

    public String getG(){
        return g;
    }

    public void closeFile(){
        x.close();
    }
}