package primeService.socket;


import primeService.util.Debug;
import java.io.*;
import java.net.*;  


/**
 *
 * @author Sandeep
 *
 */

public class PrimeClientWorker
{

    static private Socket s;

    /**
     *
     * constructor 
     *
     */
    public PrimeClientWorker(Socket sIN)
    {
        PrimeClientWorker.s=sIN;
    }


    /**
     *
     * @return void
     * @param clienname number
     */
    public static void sendQuery(String clientName,int number)
    {
       
       try
       {

        String messag=clientName+" "+number;
        //System.out.println("Client side message is : "+messag);
            BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            writer.write(messag + "\n");
        writer.flush();
       }
       catch(IOException e)
       {
           System.err.println(e);
          // writer.close();
           System.exit(1);
       }
    }



    /**
     *
     * @return void
     *
     */
    public static void getResponse()
    {
        String resp;
       try
       {
            //putStream is=s.getInputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
            resp=br.readLine();
            Debug.getInstance().printMessage(1,resp);
            //System.out.println(resp);
       }
       catch(IOException e)
       {
           System.err.println(e);
       }


    }

    

    /**
     *
     * @return void
     */
    public static void safeExit()
    {
        System.exit(0);
        //s.close();
    }
    
    public String toString() {
	String retValue = "\n I am a 2015 Volkswagen Bettle Convertible \n";
	return retValue;
    }
}

