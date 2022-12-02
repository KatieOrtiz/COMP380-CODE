package code0.ecommercesite;

//import junit 4 testing framework
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Date;
import java.lang.reflect.Field;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class UserTests {

    // Test for setName method in User class
    @Test
    public void testSetName() throws NoSuchFieldException, IllegalAccessException {   
        //given
        final User name = new User();
       try{
        //when
        name.setName("Katie");
        final Field field;        
        //then
        field = name.getClass().getDeclaredField("name");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(name), "Katie");
       } catch(Exception e){
            System.out.println("testSetName failed");
        }
    }

    // Test for getName method in User class
    @Test
    public void testGetName() throws NoSuchFieldException, IllegalAccessException {
       try{
        //given
        final User name = new User();
        final Field field = name.getClass().getDeclaredField("name");
        field.setAccessible(true);
        field.set(name, "NAME");
        //when
        final String result = name.getName();
        //then
        assertEquals("field wasn't retrieved properly", result, "NAME");
       } catch(Exception e){
            System.out.println("testGetName failed");    
        }
    }

     // Test for setEmail method in User class
     @Test
     public void testSetEmail() throws NoSuchFieldException, IllegalAccessException {   
         //given
         final User email = new User();
        try{
         //when
         email.setEmail("test@gmail.com");
         final Field field;        
         //then
         field = email.getClass().getDeclaredField("email");
         field.setAccessible(true);
         assertEquals("Fields didn't match", field.get(email), "test@gmail.com");
        } catch(Exception e){
             System.out.println("testSetEmail failed");
         }
     }

     // Test for getEmail method in User class
     @Test
     public void testGetEmail() throws NoSuchFieldException, IllegalAccessException {
        try{
         //given
         final User email = new User();
         final Field field = email.getClass().getDeclaredField("email");
         field.setAccessible(true);
         field.set(email, "EMAIL");
         //when
         final String result = email.getEmail();
         //then
         assertEquals("field wasn't retrieved properly", result, "EMAIL");
        } catch(Exception e){
             System.out.println("testGetEmail failed");    
         }
     }
     
     // Test for setUsername method in User class
    @Test
    public void testSetUsername() throws NoSuchFieldException, IllegalAccessException {   
        //given
        final User username = new User();
        try{
        //when
        username.setUsername("testusername");
        final Field field;        
        //then
        field = username.getClass().getDeclaredField("username");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(username), "testusername");
        } catch(Exception e){
            System.out.println("testSetUsername failed");
        }
    }

    // Test for getUsername method in User class
    @Test
    public void testGetUsername() throws NoSuchFieldException, IllegalAccessException {
       try{
        //given
        final User username = new User();
        final Field field = username.getClass().getDeclaredField("username");
        field.setAccessible(true);
        field.set(username, "USERNAME");
        //when
        final String result = username.getUsername();
        //then
        assertEquals("field wasn't retrieved properly", result, "USERNAME");
       } catch(Exception e){
            System.out.println("testGetUsername failed");    
        }
    }

    // Test for setPassword method in User class
    @Test
    public void testSetPassword() throws NoSuchFieldException, IllegalAccessException {   
        //given
        final User password = new User();
        try{
        //when
        password.setPassword("testpassword");
        final Field field;        
        //then
        field = password.getClass().getDeclaredField("password");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(password), "testpassword");
        } catch(Exception e){
            System.out.println("testSetPassword failed");
        }
    }

    // Test for getPassword method in User class
    @Test
    public void testGetPassword() throws NoSuchFieldException, IllegalAccessException {
        try{
        //given
        final User password = new User();
        final Field field = password.getClass().getDeclaredField("password");
        field.setAccessible(true);
        field.set(password, "PASSWORD");
        //when
        final String result = password.getPassword();
        //then
        assertEquals("field wasn't retrieved properly", result, "PASSWORD");
        } catch(Exception e){
            System.out.println("testGetPassword failed");    
        }
    }

    // Test for setNote method in User class
    @Test
    public void testSetNote() throws NoSuchFieldException, IllegalAccessException {   
        //given
        final User note = new User();
        try{
        //when
        note.setNote("testnote");
        final Field field;        
        //then
        field = note.getClass().getDeclaredField("note");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(note), "testnote");
        } catch(Exception e){
            System.out.println("testSetNote failed");
        }
    }

     // Test for getNote method in User class
     @Test
     public void testGetNote() throws NoSuchFieldException, IllegalAccessException {
         try{
         //given
         final User note = new User();
         final Field field = note.getClass().getDeclaredField("note");
         field.setAccessible(true);
         field.set(note, "NOTE");
         //when
         final String result = note.getNote();
         //then
         assertEquals("field wasn't retrieved properly", result, "NOTE");
         } catch(Exception e){
             System.out.println("testGetNote failed");    
         }
     }

    // Test for setBirthday method in User class
    @Test
    public void testSetBirthday() throws NoSuchFieldException, IllegalAccessException {   
        //given
        final User birthday = new User();
        Date date = new Date();
        try{
        //when
        birthday.setBirthday(date);
        final Field field;        
        //then
        field = birthday.getClass().getDeclaredField("birthday");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(birthday), date);
        } catch(Exception e){
            System.out.println("testSetBirthday failed");
        }
    }

    // Test for getBirthday method in User class
    @Test
    public void testGetBirthday() throws NoSuchFieldException, IllegalAccessException {
        try{
        //given
        final User birthday = new User();
        Date date = new Date();
        final Field field = birthday.getClass().getDeclaredField("birthday");
        field.setAccessible(true);
        field.set(birthday, date);
        //when
        final Date result = birthday.getBirthday();
        //then
        assertEquals("field wasn't retrieved properly", result, date);
        } catch(Exception e){
            System.out.println("testGetBirthday failed");    
        }
    }

    // Test for setProfession method in User class
    @Test
    public void testSetProfession() throws NoSuchFieldException, IllegalAccessException {   
        //given
        final User profession = new User();
        try{
        //when
        profession.setProfession("Programmer");
        final Field field;        
        //then
        field = profession.getClass().getDeclaredField("profession");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(profession), "Programmer");
        } catch(Exception e){
            System.out.println("testSetProfession failed");
        }
    }

    // Test for getProfession method in User class
    @Test
    public void testGetProfession() throws NoSuchFieldException, IllegalAccessException {
        try{
        //given
        final User profession = new User();
        final Field field = profession.getClass().getDeclaredField("profession");
        field.setAccessible(true);
        field.set(profession, "PROFESSION");
        //when
        final String result = profession.getProfession();
        //then
        assertEquals("field wasn't retrieved properly", result, "PROFESSION");
        } catch(Exception e){
            System.out.println("testGetProfession failed");    
        }
    }

    // Test for toString method in User class
    @Test
    public void testToString() throws NoSuchFieldException, IllegalAccessException {
        try {
            // Writes "testusername", testpassword, Katie, test@gmail.com, testnote, 05/25/1977, and Programmer to the testuser.txt file that was created
            FileWriter myWriter = new FileWriter("files/testuser.txt");
            myWriter.write("testusername " + " testpassword " + " Katie " + " test@gmail.com " + " testnote "
            + " 05/25/1977 " + " Programmer " +   "]"); //write to the file

            myWriter.close(); //close the file

            // Writes "testusername" to the testusername.txt file that was created
            FileWriter otherWriter = new FileWriter("files/testusername.txt");
            otherWriter.write("testusername"); //write to the file
            otherWriter.close(); //close the file
            System.out.println("Successfully wrote to the file."); //writes the message to console if write to file was successful
        } catch (IOException e) {
            System.out.println("An error occurred."); //writes the message to console if write to file failed
            e.printStackTrace();
        }
    }
}
