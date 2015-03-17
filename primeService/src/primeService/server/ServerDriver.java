package primeService.server;

import primeService.util.Debug;
import primeService.socket.PrimeServerSocket;

import java.io.*;

/**
 *
 * @author sandeep
 *
 */

public class ServerDriver implements ServerInterface
{
    private int portNumber;
    private PrimeServerSocket pss;
    private ServerMenu sm;
    private int option;

    /**
     *
     * constructor for ServerDriver
     *
     */
    public ServerDriver(int portNumberIN)
    {
        portNumber=portNumberIN;
        Debug.getInstance().printMessage(2,"Constructor for ServerDriver");
    }

    /**
     *
     * @return void
     */

    public void driveServer()
    {

        pss=new PrimeServerSocket(portNumber);
        (new Thread(pss)).start();
        sm=new ServerMenu();

        while(true)
        {
            option=sm.selectOption();

            switch(option)
            {
                case 1:
                    try
                    {
                        System.out.println("\nEnter your Client Name : \n");
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                    String clientName = bufferedReader.readLine();
                    System.out.println(AllPrimeQueries.getInstance().getClientDetails(clientName));
                    }
                    catch(IOException e)
                    {
                        System.err.println(e);
                    }
                    break;
                case 2:
                    AllPrimeQueries.getInstance().printAllClientDetails();
                    break;

                case 3:
                    System.exit(0);
                    break;

                default:
                    System.err.println("Wrong Input");
                    break;
            }



        }
    }
    
    public String toString() {
	String retValue = "\n I am a 2015 Volkswagen Bettle Convertible \n";
	return retValue;
    }
}



