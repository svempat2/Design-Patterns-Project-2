package primeService.socket;


import java.net.*;  
import java.io.*;  



/**
 *
 *
 * @author Sandeep
 *
 */

public class PrimeClientSocket implements Runnable
{ 
    private int portNumber;
    private String hostName;
    private Socket s;
    private PrimeClientWorker pcw;
    //private Socket s;
        


    /**
     *
     *
     * constructor
     *
     */
    public PrimeClientSocket(int portNumberIN,String hostNameIN)
    {
        portNumber=portNumberIN;
        hostName=hostNameIN;
    }



    /**
     *
     * @return void
     *
     */

    public void run()
    {
        try
        {
               s=new Socket(hostName,portNumber); 
               pcw=new PrimeClientWorker(s);
        }
        catch(IOException e)
        {
            System.err.println(e);
        }
        finally
        {
            //s.close();
        }
    }
    
    public String toString() {
	String retValue = "\n I am a 2015 Volkswagen Bettle Convertible \n";
	return retValue;
    }
}

