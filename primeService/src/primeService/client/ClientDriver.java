package primeService.client;

import primeService.util.Debug;
import primeService.socket.PrimeClientSocket;
import primeService.socket.PrimeClientWorker;
import java.io.*;

/**
 * @author Sandeep 
 *
 *
 */

public class ClientDriver implements ClientInterface
{
    private int portNumber;
    private String hostName;
    private PrimeClientSocket pcs;
    private ClientMenu cm;
    private int option;
    private String clientName=null;
    int number;

    /**
     * constructor for ClientDriver
     *
     */
    public ClientDriver(int portNumberIN,String hostNameIN)
    {
        Debug.getInstance().printMessage(2,"Constructor for ClientDriver");
        portNumber=portNumberIN;
        hostName=hostNameIN;
    }
    
    public String toString() {
	String retValue = "\n I am a 2015 Volkswagen Bettle Convertible \n";
	return retValue;
    }

    /**
     *
     * @return void
     *
     */

    public void driveClient()
    {

        pcs=new PrimeClientSocket(portNumber,hostName);
        (new Thread(pcs)).start();
        //int number=0;
        //String resp;

        while(true)
        {
            cm=new ClientMenu();
            option=cm.selectOption();

            switch(option)
            {
                case 1:
                    try
                    {
                        System.out.println("\nEnter your Client Name : \n");
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                    clientName = bufferedReader.readLine();
                    }
                    catch(IOException e)
                    {
                        System.err.println(e);
                    }
                    break;
                case 2:
                    try
                    {
                        System.out.println("\nEnter your Prime number: \n");
                    BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(System.in));
                    String input = bufferedReader1.readLine();
                    number=Integer.parseInt(input);
                    }
                    catch(IOException e)
                    {
                        System.err.println(e);
                    }
                    break;
                case 3:
                    PrimeClientWorker.sendQuery(clientName,number);
                    PrimeClientWorker.getResponse();
                    break;
                case 4:
                    PrimeClientWorker.safeExit();
                    break;
                default:
                    System.err.println("You have Entered the Wrong option");
                    break;
            }


        }
    }
}



