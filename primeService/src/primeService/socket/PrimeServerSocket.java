package primeService.socket;


import java.net.*;  
import java.io.*;  


/**
 *
 * @author sandeep
 *
 */


public class PrimeServerSocket implements Runnable
{ 
    private int portNumber;
    //private Socket s;
        
    public PrimeServerSocket(int portNumberIN)
    {
        portNumber=portNumberIN;
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
            ServerSocket ss=new ServerSocket(portNumber); 
           while(true)
           { 
               
               Socket s=ss.accept();  
               PrimeServerWorker psw=new PrimeServerWorker(s);
               (new Thread(psw)).start();
           }
        }
        catch(IOException e)
        {
            System.err.println(e);
        }
        finally
        {

        }
    }
    
    public String toString() {
	String retValue = "\n I am a 2015 Volkswagen Bettle Convertible \n";
	return retValue;
    }
}

