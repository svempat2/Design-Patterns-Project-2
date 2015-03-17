package primeService.server;

import primeService.util.Debug;
import java.io.*;


/**
 *
 * @author sandeep
 *
 */

public class ServerMenu
{


    public ServerMenu()
    {
        Debug.getInstance().printMessage(2,"Constructor server Menu");

    }

   

   /**
    *
    * @return int
    *
    */

    public int selectOption()
    {
            String input;
            int option=0;

        System.out.println("Select your Options :\n\n");
        System.out.println("1) ClientName");
        System.out.println("2) All Client");
        System.out.println("3) Quit");
        System.out.println("your Options :\n\n");
        
        try 
        {
            
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            input = bufferedReader.readLine();
            option=Integer.parseInt(input);
        } 
        catch (NumberFormatException ex) 
        {
            System.out.println("Not a number !");
        } 
        catch (IOException e) 
        {
             e.printStackTrace();
        }

        return option;
    }
    
    public String toString() {
	String retValue = "\n I am a 2015 Volkswagen Bettle Convertible \n";
	return retValue;
    }
}



