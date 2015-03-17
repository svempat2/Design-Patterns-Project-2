package primeService.socket;

import primeService.server.AllPrimeQueries;
import java.io.*;  
import java.net.*;  
import java.io.IOException;
import primeService.util.CheckPrime;
import java.io.BufferedReader;



/**
 *
 *
 * @author sandeep
 *
 */
public class PrimeServerWorker implements Runnable 
{

    private Socket s;
    private static final int THRESHOLD=3;

    public PrimeServerWorker(Socket sIN)
    {
        s=sIN;
    }


    public void run()
    {
        String messag;

        //AllPrimeQueries sP = AllPrimeQueries.getInstance();

        try
        {
            
            while(true)
            {
            
            BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
            messag=br.readLine();
            //System.out.println("Client recieved data : "+messag);
            String[] in;
            in=messag.split(" ");
            String name=in[0];
            String number=in[1];
            //System.out.println("Number :"+number);
            String msg=in[1];

            int inti=Integer.parseInt(number);

            if(inti>THRESHOLD)
            {
                CheckPrime cp=new CheckPrime(inti);
                boolean check=cp.IsPrime();

                if(check)
                {
                    AllPrimeQueries.getInstance().sendMessage(name,number);
                    msg="YES It is prime\n";
                }
                else
                    msg=" Not a Prime\n";
            }
            else
            {
                    msg="The given input number is not valid. It should be greater than 2\n";
            }





            BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            writer.write(msg + "\n");

            //DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            //dout.writeUTF("sending from server \n");
            writer.flush();
            }
        }
        catch(IOException e)
        {
            System.err.println(e);
        }
    }
    
    public String toString() {
	String retValue = "\n I am a 2015 Volkswagen Bettle Convertible \n";
	return retValue;
    }
}  
