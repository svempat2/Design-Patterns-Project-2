package primeService.client;

import primeService.util.Debug;
import java.io.*;


/**
 *
 * @author Sandeep
 *
 */

public class ClientMenu
{

    /**
     *
     * constructor
     *
     */

    public ClientMenu()
    {
        Debug.getInstance().printMessage(2,"Constructor for ClientMenu");

    }


    public String toString() {
	String retValue = "\n I am a 2015 Volkswagen Bettle Convertible \n";
	return retValue;
    }
    

    /**
     *
     *@return int
     *
     */

    public int selectOption()
    {
        String input="0";

        System.out.println("Select your Options :\n\n");
        System.out.println("1) Set Client Name");
        System.out.println("2) Enter number to query for prime");
        System.out.println("3) What is the server response ? ");
        System.out.println("4) Quit");
        System.out.println("your Options :\n\n");
        
        try 
        {
            
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            input = bufferedReader.readLine();
        } 
        catch(NumberFormatException ex) 
        {
            System.out.println("Not a number !");
            System.exit(1);
        } 
        catch(IOException e) 
        {
             e.printStackTrace();
            System.exit(1);
        }
        
        return Integer.parseInt(input);
    }
}



